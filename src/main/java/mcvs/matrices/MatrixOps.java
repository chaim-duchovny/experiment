package mcvs.matrices;

/**
 * Plain, ordinary (non-Hadamard) matrix multiplication used for every A x D x T and
 * A x D x T x C product in this project. Kept deliberately close to the mathematical
 * notation of the paper: {@code result = X @ Y}, i.e. {@code result[i][j] = sum_p X[i][p] * Y[p][j]}.
 */
public final class MatrixOps {

    private MatrixOps() {}

    public static double[][] multiply(double[][] x, double[][] y) {
        final int n = x.length;
        final int k = y.length;
        final int m = y.length == 0 ? 0 : y[0].length;
        final double[][] result = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < k; p++) {
                final double xip = x[i][p];
                if (xip == 0.0) {
                    continue;
                }
                final double[] yp = y[p];
                final double[] ri = result[i];
                for (int j = 0; j < m; j++) {
                    ri[j] += xip * yp[j];
                }
            }
        }
        return result;
    }
}
