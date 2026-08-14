package mcvs.database;

import java.util.List;

import game.Game;
import main.collections.FastArrayList;
import mcvs.abc.BoardEmbedding;
import mcvs.matrices.Similarity;
import mcvs.matrices.WeightedMatrixBuilder;
import other.context.Context;
import other.move.Move;

public final class SpiderAgent {

    private final VectorDatabase database;
    private final BoardEmbedding embedding;
    private final int perspective;   // MCVS player id (self)

    public SpiderAgent(VectorDatabase database, BoardEmbedding embedding, int perspective) {
        this.database = database;
        this.embedding = embedding;
        this.perspective = perspective;
    }

    public Move recommend(Game game, Context context, FastArrayList<Move> candidates, int rootDepth) {
        final int targetDepth = rootDepth + 1;
        final int window = 5;
        List<NodeRecord> winPool = database.queryByLevel(NodeRecord.Outcome.WIN, targetDepth);
        if (winPool.isEmpty()) {
            winPool = new java.util.ArrayList<>();
            for (int d = Math.max(0, targetDepth - window); d <= targetDepth + window; d++) {
                if (d == targetDepth) continue;
                winPool.addAll(database.queryByLevel(NodeRecord.Outcome.WIN, d));
            }
        }

        if (winPool.isEmpty()) {
            return null;
        }
        
        if (winPool.isEmpty()) {
            return null;
        }

        NodeRecord bestTemplate = null;
        double bestQn = Double.NEGATIVE_INFINITY;
        for (final NodeRecord record : winPool) {
            final double qn = record.q * Math.log(1 + record.n);
            if (qn > bestQn) {
                bestQn = qn;
                bestTemplate = record;
            }
        }
        if (bestTemplate == null) {
            return null;
        }

        Move best = null;
        double bestSim = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < candidates.size(); i++) {
            final Context child = context.deepCopy();
            game.apply(child, candidates.get(i));
            final double[][] wChild = WeightedMatrixBuilder.build(child, embedding, perspective);
            final double sim = Similarity.similarity(wChild, bestTemplate.weightedMatrix);
            if (sim > bestSim) {
                bestSim = sim;
                best = candidates.get(i);
            }
        }
        return best;
    }
}