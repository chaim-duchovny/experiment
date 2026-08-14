package mcvs.database;

/**
 * One entry of the persistent per-game database (Algorithm "Database Creation and
 * Node Storage" / Definition "The abc Model", {@code Node(t) = {(kappa_1, kappa_2, x(t))}}).
 *
 * <p>{@code q}/{@code n} play the role of the paper's action value Q(s,a) and visit
 * count N(s,a) (Algorithm "Update Q and N (Backpropagation)"), but aggregated at the
 * database level: whenever an Atomic Runner (Algorithm "Atomic Runner") commits a new
 * trace whose weighted matrix at a given depth nearly duplicates an existing record
 * (see {@link VectorDatabase}), we merge it into that record via the same running-mean
 * update {@code Q += (R - Q) / N} rather than storing a new near-identical row. This is
 * what allows {@link SpiderAgent} to meaningfully rank templates by "high Q and high
 * N" (Algorithm "Spider Search").
 */
public final class NodeRecord {

    public enum Outcome { WIN, LOSS, DRAW }

    public final int depth;                 // t
    public final double[][] weightedMatrix;  // W(x(t))
    public final Outcome outcome;            // partition (D_win / D_loss / D_draw)

    public volatile double q; // aggregated action value
    public volatile int n;    // aggregated visit count

    public NodeRecord(int depth, double[][] weightedMatrix, double q, int n, Outcome outcome) {
        this.depth = depth;
        this.weightedMatrix = weightedMatrix;
        this.q = q;
        this.n = n;
        this.outcome = outcome;
    }
}
