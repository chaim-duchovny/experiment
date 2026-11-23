package mcvs.search;

import mcvs.database.NodeRecord;
import mcvs.database.VectorDatabase;

/**
 * Implements the "Zone Guidance" section of the paper end-to-end:
 * <ul>
 *   <li>the similarity-augmented softmax prior P(a) ("Mathematical Integration")</li>
 *   <li>the PUCT-style selection score
 *       {@code Score(s,a) = Q(s,a) + c * P(a) * sqrt(N(s)) / (1+N(s,a))}</li>
 * </ul>
 */
public final class ZoneGuidance {

    public final double beta;   // softmax temperature for P(a)
    public final double gamma;  // loss-avoidance weight in s_a
    public final double delta;  // draw weight in s_a
    public final double eta;    // draw importance in the zone-guided reward R
    public final double epsilon; // R denominator regulariser
    public final double explorationConstant; // c in Score(s,a)

    public ZoneGuidance(double beta, double gamma, double delta, double eta,
                         double epsilon, double explorationConstant) {
        this.beta = beta;
        this.gamma = gamma;
        this.delta = delta;
        this.eta = eta;
        this.epsilon = epsilon;
        this.explorationConstant = explorationConstant;
    }

    public static ZoneGuidance defaults() {
        return new ZoneGuidance(1.0, 1.0, 0.5, 0.5, 1e-6, Math.sqrt(2.0));
    }

    /**
     * {@code s_a = max Sim(win) - gamma * max Sim(loss) + delta * max Sim(draw)},
     * evaluated at a fixed depth (the ply of the candidate successor state).
     */
    private static final int DEPTH_WINDOW = 5;

    public double sA(double[][] wCandidate, VectorDatabase db, int depth) {
        final double simWin  = db.maxSimilarityNearDepth(wCandidate, NodeRecord.Outcome.WIN,  depth, DEPTH_WINDOW);
        final double simLoss = db.maxSimilarityNearDepth(wCandidate, NodeRecord.Outcome.LOSS, depth, DEPTH_WINDOW);
        final double simDraw = db.maxSimilarityNearDepth(wCandidate, NodeRecord.Outcome.DRAW, depth, DEPTH_WINDOW);
        return simWin - gamma * simLoss + delta * simDraw;
    }

    /** P(a) = softmax_a(beta * s_a) over the set of candidate actions. */
    public double[] priorSoftmax(double[] sValues) {
        final int k = sValues.length;
        final double[] p = new double[k];

        double max = Double.NEGATIVE_INFINITY;
        for (final double s : sValues) {
            max = Math.max(max, s);
        }
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            p[i] = Math.exp(beta * (sValues[i] - max));
            sum += p[i];
        }
        for (int i = 0; i < k; i++) {
            p[i] /= sum;
        }
        return p;
    }

    /** Score(s,a) = Q(s,a) + c * P(a) * sqrt(N(s)) / (1 + N(s,a)). */
    public double puctScore(double q, double priorP, int parentVisits, int actionVisits) {
        return q + explorationConstant * priorP * Math.sqrt(parentVisits) / (1.0 + actionVisits);
    }
}
