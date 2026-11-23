package mcvs.search;

import mcvs.abc.BoardEmbedding;
import other.move.Move;

/**
 * Turns a Ludii Move into a short algebraic / coordinate string.
 * Chess-like 8x8 boards → e2-e4
 * Hex / other → site labels or from-to indices as fallback.
 */
public final class MoveFormatter {

    private MoveFormatter() {}

    public static String format(Move move, BoardEmbedding embedding) {
        if (move == null) {
            return "?";
        }

        // Prefer explicit from → to when both are valid board sites
        final int from = move.from();
        final int to   = move.to();

        if (from >= 0 && to >= 0 && from != to) {
            return siteName(from, embedding) + "-" + siteName(to, embedding);
        }
        if (to >= 0) {
            // drop / place-only move (e.g. Hex, Connect4)
            return siteName(to, embedding);
        }
        if (from >= 0) {
            return siteName(from, embedding);
        }

        // Last resort: strip the noisy Ludii wrapper if possible
        String s = move.toString();
        if (s == null) {
            return "?";
        }
        // keep only the first [Move:...] segment if present
        final int start = s.indexOf("[Move:");
        if (start >= 0) {
            final int end = s.indexOf(']', start);
            if (end > start) {
                s = s.substring(start, end + 1);
            }
        }
        return s.replaceAll("\\s+", "");
    }

    /** Map a site index to a human label (e2, A3, …). */
    private static String siteName(int site, BoardEmbedding embedding) {
        if (embedding == null) {
            return Integer.toString(site);
        }

        final int n = embedding.numSites();

        // Chess / Checkers / Breakthrough style 8×8 (64 cells)
        if (n == 64) {
            return chessSquare(site);
        }

        // Try Ludii’s own label if the embedding exposed topology labels
        // (BoardEmbedding does not store labels; fall back to index)
        return Integer.toString(site);
    }

    /**
     * Ludii Chess cells are usually row-major from a8..h1 or a1..h8.
     * The common Ludii layout for Chess.lud is:
     *   site 0 = a8, 1 = b8, … 7 = h8, 8 = a7, … 63 = h1
     * Adjust the rank formula if your GUI shows the opposite.
     */
    private static String chessSquare(int site) {
        if (site < 0 || site > 63) {
            return Integer.toString(site);
        }
        final int file = site % 8;          // 0=a … 7=h
        final int rank = 8 - (site / 8);    // 0→8, 1→7, … 7→1  (a8 top)
        return String.valueOf((char) ('a' + file)) + rank;
    }
}