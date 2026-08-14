package mcvs.matrices;

import mcvs.abc.BoardEmbedding;
import mcvs.abc.GameStateSnapshot;
import mcvs.abc.TokenizedVector;

/**
 * Builds the Adjacency Matrix A(x(t)), Definition "Adjacency Matrix":
 *
 * <pre>
 *   A[i,j](t) = 1  if two pieces are adjacent on the board
 *             = 1  isolated piece   (self-loop, i == j)
 *             = 0  otherwise
 * </pre>
 *
 * <p>Adjacency is restricted to <b>occupied</b> cells: an edge only exists between two
 * cells that both hold a piece and are topological neighbours on the board graph.
 * Isolation is determined via Definition "Isolated Pieces Set": a piece is isolated
 * when none of its board-graph neighbours are occupied.
 *
 * <p>The matrix is indexed over <b>all</b> board cells (fixed size n = number of
 * sites of the given game/board-size), not just the occupied ones -- this matches the
 * paper's worked 2x2-board example (Section "Algebraic Structure Analysis"), which
 * keeps unoccupied rows/columns as all-zero rather than compacting the matrix. Fixing
 * the dimension also makes the Frobenius similarity between states of the same game
 * well-defined (Section "Zone Guidance").
 */
public final class AdjacencyMatrix {

    private AdjacencyMatrix() {}

    public static double[][] compute(GameStateSnapshot snapshot) {
        final BoardEmbedding embedding = snapshot.embedding();
        final int n = snapshot.numSites();
        final double[][] a = new double[n][n];

        for (int i = 0; i < n; i++) {
            final TokenizedVector ti = snapshot.token(i);
            if (!ti.isOccupied()) {
                continue;
            }

            boolean hasOccupiedNeighbour = false;
            for (final int j : embedding.neighbours(i)) {
                if (snapshot.token(j).isOccupied()) {
                    a[i][j] = 1.0;
                    hasOccupiedNeighbour = true;
                }
            }

            // Definition "Isolated Pieces Set": no occupied neighbour => isolated piece.
            if (!hasOccupiedNeighbour) {
                a[i][i] = 1.0;
            }
        }
        return a;
    }
}
