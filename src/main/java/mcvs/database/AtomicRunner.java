package mcvs.database;

import java.util.concurrent.atomic.AtomicReference;
import mcvs.database.VectorDatabase;
import game.Game;
import mcvs.abc.BoardEmbedding;
import mcvs.matrices.WeightedMatrixBuilder;
import mcvs.search.UCTPlayer;
import mcvs.util.Rewards;
import other.context.Context;
import other.move.Move;

/**
 * Atomic Runner (Algorithm "Atomic Runner (Background Agent)"): a background thread
 * that continuously plays full self-play games to a terminal state, starting from the
 * <em>current</em> live root of the actual game (kept up to date via {@code rootRef}
 * by {@code MCVSPlayer}), and records the resulting per-ply weighted matrices into the
 * persistent {@link VectorDatabase}, partitioned by final outcome relative to
 * {@code perspectivePlayer} (the MCVS agent's own player index).
 *
 * <p>Uses a lightweight embedded {@link UCTPlayer} with a hard wall-clock time budget
 * so that background traces always finish even on slow games such as Chess.
 */
public final class AtomicRunner implements Runnable {

    private final Game game;
    private final AtomicReference<Context> rootRef;
    private final VectorDatabase database;
    private final BoardEmbedding embedding;
    private final int perspectivePlayer;
    private final int innerIterations;   // kept for compatibility, but time is the real limit

    private volatile boolean stop = false;

    public AtomicRunner(Game game, AtomicReference<Context> rootRef, VectorDatabase database,
                         BoardEmbedding embedding, int perspectivePlayer, int innerIterations) {
        this.game = game;
        this.rootRef = rootRef;
        this.database = database;
        this.embedding = embedding;
        this.perspectivePlayer = perspectivePlayer;
        this.innerIterations = innerIterations;
    }

    public void requestStop() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                playOneTrace();
            } catch (final Exception ex) {
                System.err.println("[AtomicRunner] failed: " + ex);
                ex.printStackTrace();
            }
        }
    }

    /** Fixed thinking time given to the background UCT on every move. */
    private static final double SECONDS_PER_BACKGROUND_MOVE = 0.25;   // 100 ms – tune 0.05–0.25

    /** Absolute wall-clock limit for one whole background game (safety net). */
    private static final double RUNNER_TIME_LIMIT_SECONDS = 25.0;

    private void playOneTrace() {
        final Context root = rootRef.get();
        if (root == null) {
            return;
        }

        final Context context = root.deepCopy();
        final GameTrace trace = new GameTrace();
        final int startDepth = context.trial().numMoves();

        final UCTPlayer inner = new UCTPlayer();
        final int numPlayers = game.players().count();
        for (int p = 1; p <= numPlayers; p++) {
            inner.initAI(game, p);
        }

        int guard = 0;
        final int guardLimit = 2000;
        final long deadline = System.currentTimeMillis()
                + (long) (RUNNER_TIME_LIMIT_SECONDS * 1000.0);

        while (!context.trial().over()
                && !stop
                && guard < guardLimit
                && System.currentTimeMillis() < deadline) {

            trace.record(WeightedMatrixBuilder.build(context, embedding, perspectivePlayer));

            // Fixed short time per move (the important change)
            final Move move = inner.selectAction(
                    game,
                    context,
                    SECONDS_PER_BACKGROUND_MOVE,   // ← fixed 100 ms
                    Integer.MAX_VALUE,
                    -1);

            game.apply(context, move);
            guard++;
        }

        if (context.trial().over()) {
            trace.record(WeightedMatrixBuilder.build(context, embedding, perspectivePlayer));
            final double[] ranking = context.trial().ranking();
            final NodeRecord.Outcome outcome = classify(ranking, numPlayers);

            final VectorDatabase shared = VectorDatabase.mcvsDatabase();
            shared.commitTrace(trace, outcome, startDepth);
            final int games = shared.completeGames();

            System.out.println("[AtomicRunner] COMMITTED to shared db="
                    + System.identityHashCode(shared)
                    + " completeGames=" + games
                    + " totalSize=" + shared.totalSize()
                    + " outcome=" + outcome);

            if (database != null && database != shared) {
                database.commitTrace(trace, outcome, startDepth);
            }
        }
    }

    private NodeRecord.Outcome classify(double[] ranking, int numPlayers) {
        final double score = Rewards.normalizedScore(ranking, perspectivePlayer, numPlayers);
        if (score >= 1.0 - 1e-9) {
            return NodeRecord.Outcome.WIN;
        }
        if (score <= 1e-9) {
            return NodeRecord.Outcome.LOSS;
        }
        return NodeRecord.Outcome.DRAW;
    }
}


// The atomic runner bellow was used for the rest of the games. The atomic runner above is kept for the game of chess only.

/* 
package mcvs.database;

import java.util.concurrent.atomic.AtomicReference;
import mcvs.database.VectorDatabase;
import game.Game;
import mcvs.abc.BoardEmbedding;
import mcvs.matrices.WeightedMatrixBuilder;
import mcvs.search.UCTPlayer;
import mcvs.util.Rewards;
import other.context.Context;
import other.move.Move;
*/

/**
 * Atomic Runner (Algorithm "Atomic Runner (Background Agent)"): a background thread
 * that continuously plays full self-play games to a terminal state, starting from the
 * <em>current</em> live root of the actual game (kept up to date via {@code rootRef}
 * by {@code MCVSPlayer}), and records the resulting per-ply weighted matrices into the
 * persistent {@link VectorDatabase}, partitioned by final outcome relative to
 * {@code perspectivePlayer} (the MCVS agent's own player index).
 *
 * <p>The paper's pseudocode says "Run full MCTS simulation from s until terminal"; we
 * use a lightweight embedded {@link UCTPlayer} (small iteration budget) to keep
 * background trace generation computationally tractable while still producing
 * non-trivial, skillful self-play traces (rather than pure random rollouts).
 */
/* 
public final class AtomicRunner implements Runnable {

    private final Game game;
    private final AtomicReference<Context> rootRef;
    private final VectorDatabase database;
    private final BoardEmbedding embedding;
    private final int perspectivePlayer;
    private final int innerIterations;

    private volatile boolean stop = false;

    public AtomicRunner(Game game, AtomicReference<Context> rootRef, VectorDatabase database,
                         BoardEmbedding embedding, int perspectivePlayer, int innerIterations) {
        this.game = game;
        this.rootRef = rootRef;
        this.database = database;
        this.embedding = embedding;
        this.perspectivePlayer = perspectivePlayer;
        this.innerIterations = innerIterations;
    }

    public void requestStop() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                playOneTrace();
            } catch (final Exception ex) {
                System.err.println("[AtomicRunner] failed: " + ex);
                ex.printStackTrace();
            }
        }
    }

    private void playOneTrace() {
        final Context root = rootRef.get();
        if (root == null) {
            return;
        }

        final Context context = root.deepCopy();
        final GameTrace trace = new GameTrace();
        final int startDepth = context.trial().numMoves();

        final UCTPlayer inner = new UCTPlayer();
        final int numPlayers = game.players().count();
        for (int p = 1; p <= numPlayers; p++) {
            inner.initAI(game, p);
        }

        // Safety guard against runaway/non-terminating traces in pathological positions.
        int guard = 0;
        final int guardLimit = 2000;

        while (!context.trial().over() && !stop && guard < guardLimit) {
            trace.record(WeightedMatrixBuilder.build(context, embedding, perspectivePlayer));
            final Move move = inner.selectAction(game, context, -1.0, innerIterations, -1);
            game.apply(context, move);
            guard++;
        }

        if (context.trial().over()) {
            trace.record(WeightedMatrixBuilder.build(context, embedding, perspectivePlayer));
            final double[] ranking = context.trial().ranking();
            final NodeRecord.Outcome outcome = classify(ranking, numPlayers);

            // Commit to the shared persistent DB (this is what MCVSPlayer reads)
            final VectorDatabase shared = VectorDatabase.mcvsDatabase();
            shared.commitTrace(trace, outcome, startDepth);
            final int games = shared.completeGames();
            if (games % 100 == 0) {
                System.out.println("[AtomicRunner] COMMITTED to shared db="
                        + System.identityHashCode(shared)
                        + " completeGames=" + games
                        + " totalSize=" + shared.totalSize());
            }

            // Optional: also keep the runner-local DB if you still use it
            if (database != null && database != shared) {
                database.commitTrace(trace, outcome, startDepth);
            }
        } else {
            // silent or rare log only
            // System.out.println("[AtomicRunner] aborted without terminal, plies="
            //         + (context.trial().numMoves() - startDepth));
        }
    }

    private NodeRecord.Outcome classify(double[] ranking, int numPlayers) {
        // Trial.ranking() returns a raw rank (1.0 = 1st/win, 2.0 = 2nd/loss, with ties
        // averaged, e.g. 1.5 each for a 2-player draw) -- normalise it to [0,1] before
        // classifying (see mcvs.util.Rewards for the full rationale).
        final double score = Rewards.normalizedScore(ranking, perspectivePlayer, numPlayers);
        if (score >= 1.0 - 1e-9) {
            return NodeRecord.Outcome.WIN;
        }
        if (score <= 1e-9) {
            return NodeRecord.Outcome.LOSS;
        }
        return NodeRecord.Outcome.DRAW;
    }
}
*/