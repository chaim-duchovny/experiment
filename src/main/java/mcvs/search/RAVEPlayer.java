package mcvs.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import game.Game;
import main.collections.FastArrayList;
import mcvs.util.Rewards;
import other.context.Context;
import other.move.Move;

/**
 * UCT + RAVE (Rapid Action Value Estimation / AMAF).
 * Selection: (1-β)·Q + β·Q_RAVE, with β = sqrt(k / (3N + k)).
 */
public class RAVEPlayer extends UCTPlayer {

    /** key -> {sumReward, count} */
    private final Map<String, double[]> raveStats = new ConcurrentHashMap<>();
    private final double raveK; // equivalence parameter (e.g. 3000)

    public RAVEPlayer() {
        this(Math.sqrt(2.0), 3000.0);
    }

    public RAVEPlayer(double explorationConstant, double raveK) {
        super(explorationConstant);
        this.friendlyName = "RAVE";
        this.raveK = raveK;
    }

    private static String key(Move move) {
        return move.toString();
    }

    @Override
    protected TreeNode selectUcb(TreeNode node) {
        TreeNode best = null;
        double bestScore = Double.NEGATIVE_INFINITY;
        for (final TreeNode child : node.children) {
            final double score = raveScore(node, child);
            if (score > bestScore) {
                bestScore = score;
                best = child;
            }
        }
        return best;
    }

    private double raveScore(TreeNode parent, TreeNode child) {
        if (child.visitCount == 0) {
            return Double.POSITIVE_INFINITY;
        }
        final double q = child.q();
        final double[] rs = raveStats.get(key(child.moveFromParent));
        final double qRave = (rs == null || rs[1] == 0) ? 0.0 : rs[0] / rs[1];
        final double n = child.visitCount;
        final double beta = Math.sqrt(raveK / (3.0 * n + raveK));
        final double exploit = (1.0 - beta) * q + beta * qRave;
        final double explore = explorationConstant
                * Math.sqrt(Math.log(parent.visitCount + 1) / n);
        return exploit + explore;
    }

    @Override
    protected double[] rollout(Context context, Game game) {
        final List<String> playedKeys = new ArrayList<>();
        final List<Integer> playedMovers = new ArrayList<>();

        while (!context.trial().over()) {
            final FastArrayList<Move> legal = game.moves(context).moves();
            final Move move = legal.get(random.nextInt(legal.size()));
            playedKeys.add(key(move));
            playedMovers.add(context.state().mover());
            game.apply(context, move);
        }

        final double[] ranking = context.trial().ranking();
        final int numPlayers = ranking.length - 1;

        // AMAF: every move in the playout gets the terminal reward for its mover
        for (int i = 0; i < playedKeys.size(); i++) {
            final double reward = Rewards.normalizedScore(ranking, playedMovers.get(i), numPlayers);
            final double[] stats = raveStats.computeIfAbsent(playedKeys.get(i), k -> new double[2]);
            synchronized (stats) {
                stats[0] += reward;
                stats[1] += 1;
            }
        }
        return ranking;
    }
}