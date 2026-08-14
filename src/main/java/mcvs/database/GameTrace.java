package mcvs.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Accumulates the per-ply weighted matrices W(x(t)) of a single self-play game before
 * it is committed to the persistent {@link VectorDatabase} (used by
 * {@link AtomicRunner}, Algorithm "Atomic Runner (Background Agent)").
 */
public final class GameTrace {

    private final List<double[][]> matricesByPly = new ArrayList<>();

    public void record(double[][] w) {
        matricesByPly.add(w);
    }

    public int length() {
        return matricesByPly.size();
    }

    public double[][] matrixAt(int plyIndex) {
        return matricesByPly.get(plyIndex);
    }
}
