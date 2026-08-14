package mcvs.matrices;

import mcvs.abc.BoardEmbedding;
import mcvs.abc.GameStateSnapshot;
import other.context.Context;

/**
 * Builds W = A×D×T (classic) or W_conn = A×D×T×C (connected).
 * FORCE_CONNECTED: null = classic (safe default), true = force C, false = force classic.
 */
public final class WeightedMatrixBuilder {

    /** null = classic; true = connected; false = classic. Set once before a run. */
    public static volatile Boolean FORCE_CONNECTED = false;

    private WeightedMatrixBuilder() {}

    public static double[][] build(Context context, BoardEmbedding embedding, int perspective) {
        final GameStateSnapshot snapshot = new GameStateSnapshot(context, embedding, perspective);
        final double[][] a = AdjacencyMatrix.compute(snapshot);
        final double[][] d = DistanceMatrix.compute(snapshot, a);
        final double[][] t = TokenMatrix.compute(snapshot);
        if (Boolean.TRUE.equals(FORCE_CONNECTED)) {
            final double[][] c = ConnectivityMatrix.compute(snapshot);
            return WeightedMatrix.computeConnected(a, d, t, c);
        }
        return WeightedMatrix.compute(a, d, t);
    }
}
