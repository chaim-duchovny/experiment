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
 * MAST: Move-Average Sampling Technique (Finnsson &amp; Bjornsson, 2008), one of the
 * three baseline players compared against MCVS in the paper's experimental framework.
 * Reuses {@link UCTPlayer}'s UCB1 tree policy but replaces the uniform-random default
 * (rollout) policy with an epsilon-greedy policy over a global table of average move
 * rewards, updated after every rollout.
 */
public class MASTPlayer extends UCTPlayer {

    // key -> {sum of rewards, occurrence count}
    private final Map<String, double[]> moveStats = new ConcurrentHashMap<>();
    private final double epsilon;

    public MASTPlayer() {
        this(Math.sqrt(2.0), 0.2);
    }

    public MASTPlayer(double explorationConstant, double epsilon) {
        super(explorationConstant);
        this.friendlyName = "MAST";
        this.epsilon = epsilon;
    }

    private static String key(Move move) {
        return move.toString();
    }

    @Override
    protected double[] rollout(Context context, Game game) {
        final List<String> playedKeys = new ArrayList<>();
        final List<Integer> playedMovers = new ArrayList<>();

        while (!context.trial().over()) {
            final FastArrayList<Move> legal = game.moves(context).moves();
            final Move move = selectMastMove(legal);
            playedKeys.add(key(move));
            playedMovers.add(context.state().mover());
            game.apply(context, move);
        }

        final double[] ranking = context.trial().ranking();
        final int numPlayers = ranking.length - 1;
        for (int i = 0; i < playedKeys.size(); i++) {
            final double reward = Rewards.normalizedScore(ranking, playedMovers.get(i), numPlayers);
            final double[] stats = moveStats.computeIfAbsent(playedKeys.get(i), k -> new double[2]);
            synchronized (stats) {
                stats[0] += reward;
                stats[1] += 1;
            }
        }
        return ranking;
    }

    private Move selectMastMove(FastArrayList<Move> legal) {
        if (legal.size() == 1 || random.nextDouble() < epsilon) {
            return legal.get(random.nextInt(legal.size()));
        }
        Move best = null;
        double bestValue = Double.NEGATIVE_INFINITY;
        for (final Move move : legal) {
            final double[] stats = moveStats.get(key(move));
            final double value = (stats == null) ? 0.0 : stats[0] / stats[1];
            if (value > bestValue) {
                bestValue = value;
                best = move;
            }
        }
        return best;
    }
}
