package mcvs.matrices;

import mcvs.abc.AffineVector;
import mcvs.abc.BoardEmbedding;
import mcvs.abc.GameStateSnapshot;

/**
 * Builds the Distance Matrix D(x(t)), Definition "Distance Matrix D(x(t))":
 *
 * <pre>
 *   D[i,j](t) = || B_i.c(t-1) - B_j.c(t-1) ||_2   if i != j and A[i,j] = 1 (adjacent pair)
 *             = || B_i.c(t-1) - I.c(t-1)   ||_2   if cell i or j is isolated
 *             = 0                                  if i == j
 * </pre>
 *
 * <p>Because every B_i is a pure translation applied to the fixed centre c(0) (Section
 * "Group Operation"), {@code || B_i.c(0) - B_j.c(0) ||} reduces to the plain Euclidean
 * distance between the two cells' embedded board coordinates, and
 * {@code || B_i.c(0) - I.c(0) ||} reduces to the distance from cell i to the board
 * centre.
 */
public final class DistanceMatrix {

    private DistanceMatrix() {}

    public static double[][] compute(GameStateSnapshot snapshot, double[][] a) {
        final BoardEmbedding embedding = snapshot.embedding();
        final int n = snapshot.numSites();
        final double[][] d = new double[n][n];
        final AffineVector center = embedding.center0();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    d[i][j] = 0.0;
                } else if (a[i][j] == 1.0) {
                    d[i][j] = embedding.cellPlacement(i).distanceTo(embedding.cellPlacement(j));
                } else if (a[i][i] == 1.0 || a[j][j] == 1.0) {
                    // one of the two endpoints is an isolated piece: distance to c(0).
                    final AffineVector isolatedCell = (a[i][i] == 1.0)
                            ? embedding.cellPlacement(i)
                            : embedding.cellPlacement(j);
                    d[i][j] = isolatedCell.distanceTo(center);
                } else {
                    d[i][j] = 0.0;
                }
            }
        }
        return d;
    }
}
