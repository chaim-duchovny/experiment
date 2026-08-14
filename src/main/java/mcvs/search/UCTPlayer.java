package mcvs.search;

import java.util.Random;

import game.Game;
import main.collections.FastArrayList;
import mcvs.util.Rewards;
import other.AI;
import other.context.Context;
import other.move.Move;

/**
 * Standard UCT / MCTS baseline player. This corresponds to the degenerate case of the
 * paper's PUCT-style score (Section "Zone Guidance")
 * {@code Score(s,a) = Q(s,a) + c * P(a) * sqrt(N(s)) / (1+N(s,a))}
 * with a uniform prior {@code P(a) = 1/|A(s)|} and no similarity bias -- i.e. plain
 * UCB1. Used both as an experimental baseline ({@code mcvs.experiment.ExperimentRunner})
 * and as the internal search policy of {@code MCVSPlayer}'s cold-start fallback and
 * {@code AtomicRunner}'s background self-play.
 */
public class UCTPlayer extends AI {

    protected int player = -1;
    protected final double explorationConstant;
    protected final Random random = new Random();

    public UCTPlayer() {
        this(Math.sqrt(2.0));
    }

    public UCTPlayer(double explorationConstant) {
        this.friendlyName = "UCT";
        this.explorationConstant = explorationConstant;
    }

    @Override
    public void initAI(Game game, int playerID) {
        this.player = playerID;
    }

    @Override
    public boolean supportsGame(Game game) {
        return true;
    }

    @Override
    public Move selectAction(Game game, Context context, double maxSeconds, int maxIterations, int maxDepth) {
        final TreeNode root = new TreeNode(null, null, context.state().mover());
        root.untriedMoves = new FastArrayList<>(game.moves(context).moves());

        if (root.untriedMoves.isEmpty()) {
            // Should not normally happen (Ludii always supplies at least a pass move),
            // but guards against a degenerate call.
            return null;
        }

        final long stopTime = maxSeconds > 0 ? System.currentTimeMillis() + (long) (maxSeconds * 1000.0) : Long.MAX_VALUE;
        final int iterationLimit = maxIterations > 0 ? maxIterations : Integer.MAX_VALUE;

        int iterations = 0;
        while (iterations < iterationLimit && System.currentTimeMillis() < stopTime && !wantsInterrupt) {
            final Context iterContext = copyContext(context);
            final TreeNode selected = treePolicy(root, iterContext, game);
            final double[] rewards = rollout(iterContext, game);
            backpropagate(selected, rewards);
            iterations++;
        }

        final TreeNode best = bestChild(root);
        return best == null ? root.untriedMoves.get(0) : best.moveFromParent;
    }

    /** Standard MCTS tree policy: descend via UCB1 until an unexpanded node is found. */
    protected TreeNode treePolicy(TreeNode node, Context context, Game game) {
        TreeNode current = node;
        while (!context.trial().over()) {
            if (!current.untriedMoves.isEmpty()) {
                return expand(current, context, game);
            } else if (!current.children.isEmpty()) {
                current = selectUcb(current);
                game.apply(context, current.moveFromParent);
            } else {
                return current;
            }
        }
        return current;
    }

    protected TreeNode expand(TreeNode node, Context context, Game game) {
        final int idx = random.nextInt(node.untriedMoves.size());
        final Move move = node.untriedMoves.removeSwap(idx);
        final int mover = context.state().mover();
        game.apply(context, move);

        final TreeNode child = new TreeNode(node, move, mover);
        child.untriedMoves = context.trial().over()
                ? new FastArrayList<>()
                : new FastArrayList<>(game.moves(context).moves());
        node.children.add(child);
        return child;
    }

    protected TreeNode selectUcb(TreeNode node) {
        TreeNode best = null;
        double bestScore = Double.NEGATIVE_INFINITY;
        for (final TreeNode child : node.children) {
            final double score = ucbScore(node, child);
            if (score > bestScore) {
                bestScore = score;
                best = child;
            }
        }
        return best;
    }

    protected double ucbScore(TreeNode parent, TreeNode child) {
        if (child.visitCount == 0) {
            return Double.POSITIVE_INFINITY;
        }
        final double exploitation = child.q();
        final double exploration = explorationConstant
                * Math.sqrt(Math.log(parent.visitCount + 1) / child.visitCount);
        return exploitation + exploration;
    }

    /** Uniform random playout to a terminal state, returning Trial.ranking(). */
    protected double[] rollout(Context context, Game game) {
        while (!context.trial().over()) {
            final FastArrayList<Move> legal = game.moves(context).moves();
            final Move move = legal.get(random.nextInt(legal.size()));
            game.apply(context, move);
        }
        return context.trial().ranking();
    }

    /** Algorithm "Update Q and N (Backpropagation)", applied along the path to root.
     *  {@code ranking} holds Ludii's raw per-player rank (1.0 = win, 2.0 = loss, etc.,
     *  1-indexed with index 0 unused), which is normalised to [0,1] via
     *  {@link Rewards#normalizedScore(double[], int, int)} before being used as the
     *  backpropagated reward. */
    protected void backpropagate(TreeNode node, double[] ranking) {
        final int numPlayers = ranking.length - 1;
        TreeNode current = node;
        while (current != null && current.parent != null) {
            final double reward = Rewards.normalizedScore(ranking, current.mover, numPlayers);
            current.backpropagate(reward);
            current = current.parent;
        }
    }

    protected TreeNode bestChild(TreeNode root) {
        TreeNode best = null;
        int bestVisits = -1;
        for (final TreeNode child : root.children) {
            if (child.visitCount > bestVisits) {
                bestVisits = child.visitCount;
                best = child;
            }
        }
        return best;
    }
}
