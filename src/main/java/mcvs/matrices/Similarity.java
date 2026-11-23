package mcvs.matrices;

/**
 * Normalized similarity used throughout "Zone Guidance". The paper's formal
 * Definition of {@code Sim(W,W1) = ||W-W1||_F} (see {@link WeightedMatrix#frobeniusDistance})
 * is an unbounded Frobenius <em>distance</em> (0 = identical, larger = more
 * different). However every downstream use of Sim in the paper -- the prior score
 * {@code s_a = max Sim(win) - gamma*max Sim(loss) + delta*max Sim(draw)}, the
 * continuous zone-guided reward R, and "the closest template in the database" --
 * takes a <em>maximum</em> and treats a larger Sim value as "more similar". The paper
 * itself calls this the <em>"normalized Frobenius similarity"</em> (Section "Zone
 * Guidance", "Mathematical Integration"), confirming that a bounded, inversely
 * distance-related score is intended rather than the raw norm.
 *
 * <p>We therefore implement the monotonically-decreasing-in-distance transform
 * <pre>
 *   simNorm(W,W1) = 1 / (1 + ||W-W1||_F)   in (0,1], 1 = identical
 * </pre>
 * for all prior/reward computations in {@code mcvs.search.ZoneGuidance}, while
 * {@link WeightedMatrix#frobeniusDistance} remains available for direct fidelity to
 * the raw Definition when the distance itself (rather than a bounded similarity) is
 * needed.
 */
public final class Similarity {

    private Similarity() {}

    public static double similarity(double[][] w1, double[][] w2) {
        return 1.0 / (1.0 + WeightedMatrix.frobeniusDistance(w1, w2));
    }
}
