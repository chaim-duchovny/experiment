#!/usr/bin/env python3
"""
Verify the abc + matrix model (A, D, T, W) for:
  - paper 2x2 Go example
  - Chess, English Draughts (Checkers), Hex, Breakthrough
"""

import numpy as np
from dataclasses import dataclass
from typing import List, Tuple, Optional
import math

# ---------------------------------------------------------------------------
# Core data structures (mirror of Java AffineVector / TokenizedVector / ...)
# ---------------------------------------------------------------------------

@dataclass
class Token:
    site: int
    kappa1: int          # 0/1 occupancy
    owner: int           # 0 = empty, 1..n players
    kappa2: float        # strategic value

    def is_occupied(self) -> bool:
        return self.kappa1 == 1

    def value(self) -> float:
        return self.kappa2

@dataclass
class Board:
    name: str
    n: int
    coords: np.ndarray          # (n, 2) Euclidean centroids
    neighbours: List[List[int]] # adjacency list
    tokens: List[Token]

# ---------------------------------------------------------------------------
# Matrix builders (exact Java semantics)
# ---------------------------------------------------------------------------

def adjacency_matrix(board: Board) -> np.ndarray:
    n = board.n
    A = np.zeros((n, n))
    for i, ti in enumerate(board.tokens):
        if not ti.is_occupied():
            continue
        has_occ_nei = False
        for j in board.neighbours[i]:
            if board.tokens[j].is_occupied():
                A[i, j] = 1.0
                has_occ_nei = True
        if not has_occ_nei:          # isolated piece → self-loop
            A[i, i] = 1.0
    return A

def distance_matrix(board: Board, A: np.ndarray) -> np.ndarray:
    n = board.n
    D = np.zeros((n, n))
    centre = np.zeros(2)             # c(0) = (0,0)
    for i in range(n):
        for j in range(n):
            if i == j:
                D[i, j] = 0.0
            elif A[i, j] == 1.0:
                D[i, j] = np.linalg.norm(board.coords[i] - board.coords[j])
            elif A[i, i] == 1.0 or A[j, j] == 1.0:
                # isolated endpoint → distance to board centre
                iso = board.coords[i] if A[i, i] == 1.0 else board.coords[j]
                D[i, j] = np.linalg.norm(iso - centre)
            else:
                D[i, j] = 0.0
    return D

def token_matrix(board: Board) -> np.ndarray:
    n = board.n
    T = np.zeros((n, n))
    for i, t in enumerate(board.tokens):
        T[i, i] = t.value() if t.is_occupied() else 0.0
    return T

def weighted_matrix(A: np.ndarray, D: np.ndarray, T: np.ndarray) -> np.ndarray:
    """W[i,j] = A[i,j] * D[i,j] * T[i,i]   (Hadamard + row scale)"""
    n = A.shape[0]
    W = np.zeros((n, n))
    for i in range(n):
        tii = T[i, i]
        for j in range(n):
            W[i, j] = A[i, j] * D[i, j] * tii
    return W

def frobenius(W1: np.ndarray, W2: np.ndarray) -> float:
    return np.linalg.norm(W1 - W2)

def similarity(W1: np.ndarray, W2: np.ndarray) -> float:
    return 1.0 / (1.0 + frobenius(W1, W2))

# ---------------------------------------------------------------------------
# Generic invariant checks
# ---------------------------------------------------------------------------

def check_invariants(board: Board, A, D, T, W, tol=1e-9) -> List[str]:
    errors = []
    n = board.n

    # dimensions
    for name, M in [("A", A), ("D", D), ("T", T), ("W", W)]:
        if M.shape != (n, n):
            errors.append(f"{name} shape {M.shape} != ({n},{n})")

    # T diagonal & non-negative
    for i in range(n):
        for j in range(n):
            if i != j and abs(T[i, j]) > tol:
                errors.append(f"T[{i},{j}] should be 0")
            if i == j and T[i, j] < -tol:
                errors.append(f"T[{i},{i}] negative")

    # empty cells produce zero rows/cols in A
    for i, t in enumerate(board.tokens):
        if not t.is_occupied():
            if np.any(np.abs(A[i, :]) > tol) or np.any(np.abs(A[:, i]) > tol):
                errors.append(f"empty cell {i} has non-zero A")

    # A[i,j]==1 ⇒ D[i,j] == Euclidean (when i≠j)
    for i in range(n):
        for j in range(n):
            if abs(A[i, j] - 1.0) < tol and i != j:
                expected = np.linalg.norm(board.coords[i] - board.coords[j])
                if abs(D[i, j] - expected) > tol:
                    errors.append(f"D[{i},{j}]={D[i,j]} != euclid {expected}")

    # W formula
    for i in range(n):
        for j in range(n):
            expected = A[i, j] * D[i, j] * T[i, i]
            if abs(W[i, j] - expected) > tol:
                errors.append(f"W[{i},{j}] formula mismatch")

    # self-similarity
    if abs(frobenius(W, W)) > tol:
        errors.append("||W-W||_F != 0")
    if abs(similarity(W, W) - 1.0) > tol:
        errors.append("Sim(W,W) != 1")

    return errors

# ---------------------------------------------------------------------------
# Paper 2×2 Go example (the only numeric ground-truth)
# ---------------------------------------------------------------------------

def paper_2x2_go() -> Board:
    """
    Paper layout (indices 0..3 = Cell11, Cell21, Cell12, Cell22):
      Piece B (κ2=3) at (-1,-1) → index 1
      Piece A (κ2=2) at ( 1, 1) → index 2
    Neighbours: 1↔2
    """
    coords = np.array([
        [-1.,  1.],   # 0 Cell11
        [-1., -1.],   # 1 Cell21  (Piece B)
        [ 1.,  1.],   # 2 Cell12  (Piece A)
        [ 1., -1.],   # 3 Cell22
    ])
    neighbours = [[1, 2], [0, 3], [0, 3], [1, 2]]  # 4-connected
    tokens = [
        Token(0, 0, 0, 0.0),
        Token(1, 1, 2, 3.0),   # white / second player
        Token(2, 1, 1, 2.0),   # black / first player
        Token(3, 0, 0, 0.0),
    ]
    return Board("Paper_2x2_Go", 4, coords, neighbours, tokens)

def expected_paper_matrices():
    A = np.array([
        [0, 0, 0, 0],
        [0, 0, 1, 0],
        [0, 1, 0, 0],
        [0, 0, 0, 0],
    ], dtype=float)
    # distance between ( -1,-1) and (1,1) = sqrt(8) ≈ 2.828
    # but paper shows D with 1s – they used a simplified / normalised board.
    # We follow the *formula* and the final W the paper prints:
    # W = [[0,0,0,0],[0,0,3,0],[0,2,0,0],[0,0,0,0]]
    # That forces D[1,2]=D[2,1]=1 when the token values are applied.
    D = np.array([
        [0, 0, 0, 0],
        [0, 0, 1, 0],
        [0, 1, 0, 0],
        [0, 0, 0, 0],
    ], dtype=float)
    T = np.array([
        [0, 0, 0, 0],
        [0, 3, 0, 0],
        [0, 0, 2, 0],
        [0, 0, 0, 0],
    ], dtype=float)
    W = np.array([
        [0, 0, 0, 0],
        [0, 0, 3, 0],
        [0, 2, 0, 0],
        [0, 0, 0, 0],
    ], dtype=float)
    return A, D, T, W

# ---------------------------------------------------------------------------
# Synthetic boards for the four real games
# ---------------------------------------------------------------------------

def make_grid(rows: int, cols: int, diag=False) -> Tuple[np.ndarray, List[List[int]]]:
    """Row-major grid, 4-connected (or 8-connected if diag=True)."""
    n = rows * cols
    coords = np.zeros((n, 2))
    for r in range(rows):
        for c in range(cols):
            i = r * cols + c
            # centre the board at origin
            coords[i] = [c - (cols - 1) / 2.0, (rows - 1) / 2.0 - r]
    neighbours = [[] for _ in range(n)]
    dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    if diag:
        dirs += [(-1, -1), (-1, 1), (1, -1), (1, 1)]
    for r in range(rows):
        for c in range(cols):
            i = r * cols + c
            for dr, dc in dirs:
                rr, cc = r + dr, c + dc
                if 0 <= rr < rows and 0 <= cc < cols:
                    neighbours[i].append(rr * cols + cc)
    return coords, neighbours

def chess_sample() -> Board:
    """8×8 chess, a few pieces with paper-style values."""
    coords, neigh = make_grid(8, 8)
    tokens = [Token(i, 0, 0, 0.0) for i in range(64)]
    # white pawn e2 (file e=4, rank 2 → row 6)
    tokens[6 * 8 + 4] = Token(6 * 8 + 4, 1, 1, 2.0)
    # black pawn e7
    tokens[1 * 8 + 4] = Token(1 * 8 + 4, 1, 2, 3.0)
    # white king e1
    tokens[7 * 8 + 4] = Token(7 * 8 + 4, 1, 1, 17.0)
    # black king e8
    tokens[0 * 8 + 4] = Token(0 * 8 + 4, 1, 2, 19.0)
    return Board("Chess_sample", 64, coords, neigh, tokens)

def checkers_sample() -> Board:
    """8×8 English draughts, a few men + one king."""
    coords, neigh = make_grid(8, 8, diag=True)  # draughts uses diagonals
    tokens = [Token(i, 0, 0, 0.0) for i in range(64)]
    # dark squares only matter, but we still embed all 64
    tokens[5 * 8 + 2] = Token(5 * 8 + 2, 1, 1, 2.0)   # white man
    tokens[2 * 8 + 5] = Token(2 * 8 + 5, 1, 2, 3.0)   # black man
    tokens[0 * 8 + 1] = Token(0 * 8 + 1, 1, 2, 5.0)   # black king
    return Board("Checkers_sample", 64, coords, neigh, tokens)

def hex_sample() -> Board:
    """
    Small 3×3 Hex (9 cells). Hex adjacency is 6-connected on a hex grid.
    For simplicity we use a hexagonal offset layout.
    """
    # axial coordinates for a 3×3 hex patch
    axial = []
    for q in range(3):
        for r in range(3):
            axial.append((q, r))
    n = len(axial)
    # convert axial → cartesian
    coords = np.zeros((n, 2))
    for i, (q, r) in enumerate(axial):
        coords[i] = [np.sqrt(3) * (q + r / 2), 1.5 * r]
    # centre
    coords -= coords.mean(axis=0)

    # hex neighbours (axial)
    dirs = [(+1, 0), (+1, -1), (0, -1), (-1, 0), (-1, +1), (0, +1)]
    neighbours = [[] for _ in range(n)]
    idx = {p: i for i, p in enumerate(axial)}
    for i, (q, r) in enumerate(axial):
        for dq, dr in dirs:
            nb = (q + dq, r + dr)
            if nb in idx:
                neighbours[i].append(idx[nb])

    tokens = [Token(i, 0, 0, 0.0) for i in range(n)]
    tokens[0] = Token(0, 1, 1, 2.0)   # player 1
    tokens[4] = Token(4, 1, 2, 3.0)   # player 2
    tokens[8] = Token(8, 1, 1, 2.0)   # player 1
    return Board("Hex_sample", n, coords, neighbours, tokens)

def breakthrough_sample() -> Board:
    """8×8 Breakthrough (same topology as Chess)."""
    coords, neigh = make_grid(8, 8)
    tokens = [Token(i, 0, 0, 0.0) for i in range(64)]
    # white pieces on rank 7 & 8 (rows 6,7)
    for c in range(8):
        tokens[6 * 8 + c] = Token(6 * 8 + c, 1, 1, 2.0)
        tokens[7 * 8 + c] = Token(7 * 8 + c, 1, 1, 2.0)
    # black pieces on rank 1 & 2 (rows 0,1)
    for c in range(8):
        tokens[0 * 8 + c] = Token(0 * 8 + c, 1, 2, 3.0)
        tokens[1 * 8 + c] = Token(1 * 8 + c, 1, 2, 3.0)
    return Board("Breakthrough_sample", 64, coords, neigh, tokens)

# ---------------------------------------------------------------------------
# Runner
# ---------------------------------------------------------------------------

def run_one(board: Board, expected: Optional[Tuple] = None):
    print(f"\n{'='*60}")
    print(f"  {board.name}   (n={board.n})")
    print(f"{'='*60}")

    A = adjacency_matrix(board)
    D = distance_matrix(board, A)
    T = token_matrix(board)
    W = weighted_matrix(A, D, T)

    errors = check_invariants(board, A, D, T, W)

    if expected is not None:
        eA, eD, eT, eW = expected
        for name, got, exp in [("A", A, eA), ("D", D, eD), ("T", T, eT), ("W", W, eW)]:
            if not np.allclose(got, exp, atol=1e-6):
                errors.append(f"{name} does not match paper expected values")
                print(f"  --- {name} got ---\n{got}")
                print(f"  --- {name} expected ---\n{exp}")

    if errors:
        print("  FAILED:")
        for e in errors:
            print("   •", e)
        return False
    else:
        print("  PASSED all invariants" + (" + paper numeric match" if expected else ""))
        # small pretty-print for tiny boards
        if board.n <= 9:
            print("  A =\n", A)
            print("  T =\n", T)
            print("  W =\n", W)
        return True

def main():
    results = []

    # 1. Paper ground truth
    results.append(run_one(paper_2x2_go(), expected_paper_matrices()))

    # 2. Real-game synthetic samples
    results.append(run_one(chess_sample()))
    results.append(run_one(checkers_sample()))
    results.append(run_one(hex_sample()))
    results.append(run_one(breakthrough_sample()))

    print("\n" + "=" * 60)
    print(f"  SUMMARY: {sum(results)}/{len(results)} boards passed")
    print("=" * 60)
    if not all(results):
        raise SystemExit(1)

if __name__ == "__main__":
    main()