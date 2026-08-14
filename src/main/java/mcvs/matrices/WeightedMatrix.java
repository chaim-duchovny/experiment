package mcvs.matrices;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Weighted Adjacency Matrix {@code W(x(t)) = A(x(t)) x D(x(t)) x T(x(t))}, Definition
 * "Weighted Adjacency Matrix", and its connectivity-augmented counterpart
 * {@code W_conn(x(t)) = A(x(t)) x D(x(t)) x T(x(t)) x C(x(t))} used for "connected
 * games" (see {@link ConnectivityMatrix}, {@link GameClassifier}).
 *
 * <p>Both products are <b>ordinary matrix multiplication</b> ({@link MatrixOps#multiply}),
 * never an element-wise/Hadamard product, exactly as written in the paper's notation.
 *
 * <p>{@code Sim(W, W1) = ||W - W1||_F} is the Frobenius norm defined in Section
 * "Zone Guidance" (see {@link #frobeniusDistance}); see {@link Similarity} for the
 * bounded, normalized similarity actually used by the prior/reward computations.
 */
public final class WeightedMatrix {

    private WeightedMatrix() {}

    // Guards so the "chosen matrix" message prints only once per game; reset via
    // resetPrintFlags() at the start of each new game (see ExperimentRunner.playOneGame).
    private static final AtomicBoolean PRINTED_UNCONNECTED = new AtomicBoolean(false);
    private static final AtomicBoolean PRINTED_CONNECTED = new AtomicBoolean(false);

    /** Call once at the start of each new game so the next compute()/computeConnected()
     *  call in that game prints again. */
    public static void resetPrintFlags() {
        PRINTED_UNCONNECTED.set(false);
        PRINTED_CONNECTED.set(false);
    }

    /** {@code W = A x D x T}, ordinary matrix multiplication. */
    public static double[][] compute(double[][] a, double[][] d, double[][] t) {
        if (PRINTED_UNCONNECTED.compareAndSet(false, true)) {
            System.out.println("Weighted matrix chosen: W = A x D x T (unconnected)");
        }
        return MatrixOps.multiply(MatrixOps.multiply(a, d), t);
    }

    /** {@code W_conn = A x D x T x C}, ordinary matrix multiplication, for games
     *  classified as "connected games" by {@link GameClassifier}. */
    public static double[][] computeConnected(double[][] a, double[][] d, double[][] t, double[][] c) {
        if (PRINTED_CONNECTED.compareAndSet(false, true)) {
            System.out.println("Weighted matrix chosen: W_conn = A x D x T x C (connected)");
        }
        final double[][] w = MatrixOps.multiply(MatrixOps.multiply(a, d), t);
        return MatrixOps.multiply(w, c);
    }

    /** {@code Sim(W, W1) = ||W - W1||_F}, literally as defined in Section "Zone Guidance". */
    public static double frobeniusDistance(double[][] w1, double[][] w2) {
        double sum = 0.0;
        final int n = w1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final double diff = w1[i][j] - w2[i][j];
                sum += diff * diff;
            }
        }
        return Math.sqrt(sum);
    }
}