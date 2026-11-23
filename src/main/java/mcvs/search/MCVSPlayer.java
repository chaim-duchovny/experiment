package mcvs.search;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import game.Game;
import main.collections.FastArrayList;
import mcvs.abc.BoardEmbedding;
import mcvs.database.AtomicRunner;
import mcvs.database.NodeRecord;
import mcvs.database.SpiderAgent;
import mcvs.database.VectorDatabase;
import mcvs.matrices.WeightedMatrixBuilder;
import mcvs.util.Rewards;
import other.AI;
import other.context.Context;
import other.move.Move;

/**
 * MCVS: Monte Carlo Vector Search, implementing Section "Monte Carlo Vector Search
 * (MCVS)" of the paper end to end:
 * <ul>
 *   <li>Algorithm "Monte Carlo Vector Search (MCVS) - Main Loop" (cold start / activation)</li>
 *   <li>Algorithm "MCVS Move Selection" (PUCT + similarity bias + spider boost)</li>
 *   <li>Algorithm "Update Q and N (Backpropagation)"</li>
 *   <li>Algorithm "Atomic Runner (Background Agent)" via {@link AtomicRunner}</li>
 *   <li>Algorithm "Spider Search (Asynchronous Recommendation)" via {@link SpiderAgent}</li>
 * </ul>
 */
public class MCVSPlayer extends AI {

    private static final int NUM_ATOMIC_RUNNERS = 2;
    //private static final int RUNNER_INNER_ITERATIONS = 256;
    private static final int RUNNER_INNER_ITERATIONS = Integer.MAX_VALUE; /* In the chess experiment only */
    private static final int DEFAULT_ITERATION_BUDGET = Integer.MAX_VALUE;

    /** Detailed per-move rows for analysis. */
    private static final Path MOVE_STATS_CSV = Path.of("results", "mcvs_move_stats.csv");
    /** Markdown summary for the final experiment report. */
    private static final Path MOVE_STATS_MD  = Path.of("results", "mcvs_report.md");

    private int player = -1;
    private BoardEmbedding embedding;
    private VectorDatabase database;
    private final ZoneGuidance zone = ZoneGuidance.defaults();
    private final Random random = new Random();
    private final UCTPlayer fallback = new UCTPlayer();

    private AtomicReference<Context> rootRef;
    private ExecutorService runnerPool;
    private final List<AtomicRunner> runners = new ArrayList<>();

    /** Per-game CSV rows: ply,sims,simWin,simLoss,sA,prior,bestVisits,completeGames */
    private final List<String> moveLog = new ArrayList<>();

    // Running totals across the whole experiment (shared by all MCVSPlayer instances)
    private static final Object STATS_LOCK = new Object();
    private static long   totalDecisions = 0;
    private static long   totalSims      = 0;
    private static double sumSimWin      = 0.0;
    private static double sumSimLoss     = 0.0;
    private static double sumSA          = 0.0;

    public MCVSPlayer() {
        this.friendlyName = "MCVS";
    }

    @Override
    public void initAI(Game game, int playerID) {
        this.player = playerID;
        this.database = VectorDatabase.mcvsDatabase();
        this.rootRef = new AtomicReference<>();
        this.embedding = null;
        this.moveLog.clear();
        fallback.initAI(game, playerID);

        if (database.completeGames() == 0 || playerID == 1) {
            System.out.println("[MCVS] initAI player=" + playerID
                    + " key=" + VectorDatabase.activeGameKey()
                    + " completeGames=" + database.completeGames());
        }
    }

    @Override
    public boolean supportsGame(Game game) {
        return true;
    }

    @Override
    public void closeAI() {
        stopRunners();
        flushMoveLog();

        System.out.println("[MCVS] closeAI player=" + player
                + " db=" + System.identityHashCode(database)
                + " completeGames=" + (database != null ? database.completeGames() : -1));
    }

    private void ensureEmbedding(Context context) {
        if (embedding == null) {
            embedding = new BoardEmbedding(context);
        }
    }

    /** Keeps NUM_ATOMIC_RUNNERS background threads (Algorithm "Atomic Runner") alive
     *  for the whole game, continuously re-seeded from the live root via rootRef. */
    private void ensureRunnersStarted(Game game) {
        if (runnerPool != null) {
            return;
        }
        runnerPool = Executors.newFixedThreadPool(NUM_ATOMIC_RUNNERS);
        for (int i = 0; i < NUM_ATOMIC_RUNNERS; i++) {
            final AtomicRunner runner = new AtomicRunner(
                    game, rootRef, database, embedding, player, RUNNER_INNER_ITERATIONS);
            runners.add(runner);
            runnerPool.submit(runner);
        }

        System.out.println("[MCVS] started " + NUM_ATOMIC_RUNNERS
                + " runners for key=" + VectorDatabase.activeGameKey()
                + " sharedDb=" + System.identityHashCode(VectorDatabase.mcvsDatabase()));
    }

    private void stopRunners() {
        for (final AtomicRunner runner : runners) {
            runner.requestStop();
        }
        if (runnerPool != null) {
            runnerPool.shutdownNow();
            runnerPool = null;
        }
        runners.clear();
    }

    @Override
    public Move selectAction(Game game, Context context, double maxSeconds,
                            int maxIterations, int maxDepth) {
        System.out.println("===== REAL MCVS selectAction CALLED =====");
        ensureEmbedding(context);
        rootRef.set(context.deepCopy());
        ensureRunnersStarted(game);

        final int rootDepth = context.trial().numMoves();
        final boolean active = database.isActive();
        final int games = database.completeGames();

        System.out.printf("[MCVS] ply=%d  isActive=%s  completeGames=%d%n",
                        rootDepth, active, games);

        if (!active) {
            System.out.println("[MCVS] → falling back to UCT");
            return fallback.selectAction(game, context, maxSeconds, maxIterations, maxDepth);
        }

        return mcvsSelect(game, context, maxSeconds, maxIterations, rootDepth);
    }

    //@Override
    //public Move selectAction(Game game, Context context, double maxSeconds,
                            //int maxIterations, int maxDepth) {
        //System.out.println("===== REAL MCVS selectAction CALLED =====");
        //ensureEmbedding(context);
        //rootRef.set(context.deepCopy());
        //ensureRunnersStarted(game);

        //final int rootDepth = context.trial().numMoves();

        //if (!database.isActive()) {
            //if (rootDepth == 0) {
                //System.out.println("[MCVS] cold-start (db games=" + database.completeGames() + ")");
            //}
            //return fallback.selectAction(game, context, maxSeconds, maxIterations, maxDepth);
        //}

        //return mcvsSelect(game, context, maxSeconds, maxIterations, rootDepth);
    //}

    /** Algorithm "MCVS Move Selection". */
    private Move mcvsSelect(Game game, Context context, double maxSeconds, int maxIterations, int rootDepth) {
        final FastArrayList<Move> candidates = game.moves(context).moves();
        if (candidates.size() == 1) {
            return candidates.get(0);
        }

        final long stopTime = maxSeconds > 0
                ? System.currentTimeMillis() + (long) (maxSeconds * 1000.0)
                : Long.MAX_VALUE;
        final int iterationLimit = maxIterations > 0 ? maxIterations : DEFAULT_ITERATION_BUDGET;

        final int numCandidates = candidates.size();
        final double[] qSum = new double[numCandidates];
        final int[] visits = new int[numCandidates];
        int parentVisits = 0;

        // Precompute the resulting weighted matrix for every candidate move once; it
        // does not change across iterations (the candidate's resulting *state* is
        // fixed), only the PUCT statistics (Q, N) evolve.
        final double[][][] candidateMatrices = new double[numCandidates][][];
        for (int i = 0; i < numCandidates; i++) {
            final Context child = context.deepCopy();
            game.apply(child, candidates.get(i));
            candidateMatrices[i] = WeightedMatrixBuilder.build(child, embedding, this.player);
        }

        final double[] sValues = new double[numCandidates];
        for (int i = 0; i < numCandidates; i++) {
            final double sw = database.maxSimilarityNearDepth(
                    candidateMatrices[i], NodeRecord.Outcome.WIN, rootDepth + 1, 5);
            final double sl = database.maxSimilarityNearDepth(
                    candidateMatrices[i], NodeRecord.Outcome.LOSS, rootDepth + 1, 5);
            sValues[i] = sw - zone.gamma * sl;  // raw scores, may all be ~0.00x
        }

        // Relative ranking: z-score so small gaps still matter
        double mean = 0.0;
        for (final double s : sValues) mean += s;
        mean /= Math.max(1, numCandidates);

        double var = 0.0;
        for (final double s : sValues) {
            final double d = s - mean;
            var += d * d;
        }
        final double std = Math.sqrt(var / Math.max(1, numCandidates)) + 1e-12;

        final double[] relative = new double[numCandidates];
        for (int i = 0; i < numCandidates; i++) {
            relative[i] = (sValues[i] - mean) / std;  // order preserved, scale fixed
        }
        final double[] priors = zone.priorSoftmax(relative);

        int iterations = 0;
        while (iterations < iterationLimit && System.currentTimeMillis() < stopTime && !wantsInterrupt) {
            // --- PUCT-guided selection with similarity bias (Section "Zone Guidance") ---
            int chosen = 0;
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < numCandidates; i++) {
                final double q = visits[i] == 0 ? 0.0 : qSum[i] / visits[i];
                final double score = zone.puctScore(q, priors[i], parentVisits, visits[i]);
                if (score > bestScore) {
                    bestScore = score;
                    chosen = i;
                }
            }

            // --- SimulateFrom(s'): fast self-play rollout + continuous zone-guided reward ---
            final Context simContext = context.deepCopy();
            game.apply(simContext, candidates.get(chosen));
            final double reward = simulateFrom(game, simContext, rootDepth + 1);

            // --- Algorithm "Update Q and N (Backpropagation)" ---
            visits[chosen]++;
            qSum[chosen] += reward;
            parentVisits++;
            iterations++;
        }

        int best = 0;
        int bestVisits = -1;
        for (int i = 0; i < numCandidates; i++) {
            if (visits[i] > bestVisits) {
                bestVisits = visits[i];
                best = i;
            }
        }

        // Spider Agents: asynchronous high-Q/high-N + similarity recommendation
        // (Algorithm "Spider Search"). Only allowed to override a near-tie, so a
        // handful of background samples cannot destabilise a clear PUCT winner.
        final SpiderAgent spider = new SpiderAgent(database, embedding, this.player);
        final Move spiderBoost = spider.recommend(game, context, candidates, rootDepth);
        if (spiderBoost != null) {
            final int spiderIdx = candidates.indexOf(spiderBoost);
            if (spiderIdx >= 0 && visits[spiderIdx] >= 0.8 * bestVisits) {
                best = spiderIdx;
            }
        }

        // ----- similarity to win/loss DB + number of sims (console + report) -----
        final double simWin = database.maxSimilarityAtDepth(
                candidateMatrices[best], NodeRecord.Outcome.WIN, rootDepth + 1);
        final double simLoss = database.maxSimilarityAtDepth(
                candidateMatrices[best], NodeRecord.Outcome.LOSS, rootDepth + 1);

        if (rootDepth % 10 == 0) {
            System.out.printf(
                "[MCVS] ply=%d sims=%d simWin=%.3f simLoss=%.3f games=%d%n",
                rootDepth, iterations, simWin, simLoss, database.completeGames());
            //System.out.printf(
                    //"[MCVS] ply=%d sims=%d simWin=%.3f simLoss=%.3f games=%d%n",
                    //rootDepth, iterations, simWin, simLoss, database.completeGames());
        }

        moveLog.add(String.format(
                "%d,%d,%.4f,%.4f,%.4f,%.4f,%d,%d",
                rootDepth, iterations,
                simWin, simLoss, sValues[best], priors[best],
                bestVisits, database.completeGames()));

        synchronized (STATS_LOCK) {
            totalDecisions++;
            totalSims  += iterations;
            sumSimWin  += simWin;
            sumSimLoss += simLoss;
            sumSA      += sValues[best];
        }

        return candidates.get(best);
    }

    /**
     * SimulateFrom(s'): plays a fast random self-play rollout to a terminal state and
     * returns the continuous zone-guided reward R (Definition
     * "Continuous Zone-Guided Reward"), used in place of the classical +-1 outcome as
     * the MCTS backpropagation signal.
     */
    private double simulateFrom(Game game, Context context, int depth) {
        while (!context.trial().over()) {
            final FastArrayList<Move> legal = game.moves(context).moves();
            game.apply(context, legal.get(random.nextInt(legal.size())));
        }
        final double[] ranking = context.trial().ranking();
        return Rewards.normalizedScore(ranking, this.player, ranking.length - 1);
    }

    /**
     * Append this game's move rows to the CSV and refresh the Markdown summary
     * used in the final experiment report.
     */
    private void flushMoveLog() {
        if (moveLog.isEmpty() && totalDecisions == 0) {
            return;
        }

        // --- CSV (detailed rows) ---
        try {
            if (MOVE_STATS_CSV.getParent() != null) {
                Files.createDirectories(MOVE_STATS_CSV.getParent());
            }
            final boolean writeHeader = !Files.exists(MOVE_STATS_CSV)
                    || Files.size(MOVE_STATS_CSV) == 0;
            try (BufferedWriter w = Files.newBufferedWriter(
                    MOVE_STATS_CSV,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {
                if (writeHeader) {
                    w.write("ply,sims,simWin,simLoss,sA,prior,bestVisits,completeGames");
                    w.newLine();
                }
                for (final String row : moveLog) {
                    w.write(row);
                    w.newLine();
                }
            }
            if (!moveLog.isEmpty()) {
                System.out.println("[MCVS] wrote " + moveLog.size()
                        + " move-stat rows to " + MOVE_STATS_CSV);
            }
        } catch (IOException e) {
            System.err.println("[MCVS] failed to write CSV: " + e.getMessage());
        }

        // --- Markdown summary for the final report ---
        writeMarkdownReport();

        moveLog.clear();
    }

    private void writeMarkdownReport() {
        synchronized (STATS_LOCK) {
            if (totalDecisions == 0) {
                return;
            }
            final double avgSims    = (double) totalSims / totalDecisions;
            final double avgSimWin  = sumSimWin  / totalDecisions;
            final double avgSimLoss = sumSimLoss / totalDecisions;
            final double avgSA      = sumSA      / totalDecisions;

            final String md = ""
                    + "# MCVS Move Statistics\n\n"
                    + "Generated at: " + java.time.Instant.now() + "\n\n"
                    + "## Summary (all decisions so far)\n\n"
                    + "| Metric | Value |\n"
                    + "|--------|------:|\n"
                    + String.format("| Decisions | %d |\n", totalDecisions)
                    + String.format("| Avg simulations (sims) | %.1f |\n", avgSims)
                    + String.format("| Avg similarity to **win** DB | %.4f |\n", avgSimWin)
                    + String.format("| Avg similarity to **loss** DB | %.4f |\n", avgSimLoss)
                    + String.format("| Avg zone score $s_A$ | %.4f |\n", avgSA)
                    + "\n"
                    + "## Notes\n\n"
                    + "- `sims` = number of MCVS PUCT iterations used for the chosen move.\n"
                    + "- `simWin` / `simLoss` = max normalized Frobenius similarity of the chosen "
                    + "child matrix $W$ to templates in the win / loss partitions at that depth.\n"
                    + "- Detailed per-move rows are in `mcvs_move_stats.csv`.\n";

            try {
                if (MOVE_STATS_MD.getParent() != null) {
                    Files.createDirectories(MOVE_STATS_MD.getParent());
                }
                // overwrite so the file always reflects the full experiment so far
                Files.writeString(MOVE_STATS_MD, md);
                System.out.println("[MCVS] updated Markdown report → " + MOVE_STATS_MD);
            } catch (IOException e) {
                System.err.println("[MCVS] failed to write MD: " + e.getMessage());
            }
        }
    }
}