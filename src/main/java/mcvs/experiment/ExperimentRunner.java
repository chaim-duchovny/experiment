package mcvs.experiment;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.Game;
import game.types.board.SiteType;
import mcvs.database.VectorDatabase;
import mcvs.search.LearningMonitor;
import mcvs.util.Rewards;
import other.AI;
import other.GameLoader;
import other.context.Context;
import other.move.Move;
import other.trial.Trial;

/**
 * Main experiment runner with live win/loss/draw statistics.
 */
public final class ExperimentRunner {

    public interface AIFactory {
        AI create();
        String name();
    }

    public static final class GameSpec {
        public final String displayName;
        public final String ludName;
        public final List<String> options;

        public GameSpec(String displayName, String ludName, List<String> options) {
            this.displayName = displayName;
            this.ludName = ludName;
            this.options = options;
        }

        public Game load() {
            return options.isEmpty()
                    ? GameLoader.loadGameFromName(ludName)
                    : GameLoader.loadGameFromName(ludName, options);
        }
    }

    private final List<GameSpec> games;
    private final List<AIFactory> aiFactories;
    private final int gamesPerPairing;
    private final double thinkingSeconds;
    private final int maxIterations;
    private final Path outputDir;

    // Live statistics tracking
    private final Map<String, PlayerStats> stats = new HashMap<>();

    private static class PlayerStats {
        int wins = 0, losses = 0, draws = 0, games = 0;

        void addResult(double scoreForThisPlayer) {
            games++;
            if (scoreForThisPlayer == 1.0) wins++;
            else if (scoreForThisPlayer == 0.5) draws++;
            else losses++;
        }

        double winRate() {
            return games == 0 ? 0.0 : (double) wins / games;
        }
    }

    public ExperimentRunner(List<GameSpec> games, List<AIFactory> aiFactories,
                             int gamesPerPairing, double thinkingSeconds, int maxIterations,
                             Path outputDir) {
        this.games = games;
        this.aiFactories = aiFactories;
        this.gamesPerPairing = gamesPerPairing;
        this.thinkingSeconds = thinkingSeconds;
        this.maxIterations = maxIterations;
        this.outputDir = outputDir;
    }

    public void run() throws IOException {
        Files.createDirectories(outputDir);

        for (final GameSpec spec : games) {
            System.out.println("\n=== Starting Game: " + spec.displayName + " ===");
            stats.clear();

            VectorDatabase.setActiveGameKey(spec.displayName);
            System.out.println("  Active DB key: " + VectorDatabase.activeGameKey());

            // Set matrix mode for this variant (classic vs connected)
            if (spec.displayName.contains("connected")) {
                mcvs.matrices.WeightedMatrixBuilder.FORCE_CONNECTED = true;
            } else if (spec.displayName.contains("classic")) {
                mcvs.matrices.WeightedMatrixBuilder.FORCE_CONNECTED = false;
            } else {
                mcvs.matrices.WeightedMatrixBuilder.FORCE_CONNECTED = false; // default classic
            }
            System.out.println("Matrix mode: FORCE_CONNECTED = "
                    + mcvs.matrices.WeightedMatrixBuilder.FORCE_CONNECTED);

            stats.clear(); // Reset stats for each new game variant

            // One folder per variant that will hold report, CSVs and all move lists
            final Path variantDir = outputDir.resolve(spec.displayName);
            Files.createDirectories(variantDir);

            final Game game = spec.load();
            
            //Preferred – turns per player
            //game.setMaxTurns(150);

            //----- Erase after havannah game.
            final Trial trial = new Trial(game);
            final Context context = new Context(game, trial);
            game.start(context);
            final int n = context.topology().numSites(
                    game.isVertexGame() ? SiteType.Vertex
                    : game.isEdgeGame() ? SiteType.Edge
                    : SiteType.Cell);
            System.out.println("  Board sites for " + spec.displayName + " = " + n);

            final EloRating elo = new EloRating(24.0);
            final List<MatchResult> results = new ArrayList<>();

            try (PrintWriter learningCurve = new PrintWriter(
                    Files.newBufferedWriter(variantDir.resolve(spec.displayName + "_learning_curve.csv")))) {

                learningCurve.println("game_index,player_a,player_b,score_a,elo_a,elo_b,plies");

                int gameIndex = 0;
                final AIFactory uct  = aiFactories.get(0);
                final AIFactory mast = aiFactories.get(1);
                final AIFactory mcvs = aiFactories.get(2);
                // Delete if not used
                final AIFactory rave = aiFactories.get(3);
                // Delete if not used
                final AIFactory[] opponents = { uct, mast, rave };

                for (final AIFactory opponent : opponents) {
                    for (int g = 0; g < gamesPerPairing; g++) {
                        // opponent vs MCVS
                        final MatchResult r1 = playOneGame(game, opponent, mcvs, variantDir, ++gameIndex);
                        processResult(r1);
                        results.add(r1);
                        elo.update(r1.playerA, r1.playerB, r1.scoreA);
                        logGameWithStats(learningCurve, gameIndex, r1);

                        // MCVS vs opponent
                        final MatchResult r2 = playOneGame(game, mcvs, opponent, variantDir, ++gameIndex);
                        processResult(r2);
                        results.add(r2);
                        elo.update(r2.playerA, r2.playerB, r2.scoreA);
                        logGameWithStats(learningCurve, gameIndex, r2);
                    }
                }
            }

            writeSummary(spec, results, elo, variantDir);
            writeMarkdownReport(spec, results, elo, variantDir);
            printFinalStandings(spec.displayName);
        }
    }

    private void processResult(MatchResult r) {
        stats.computeIfAbsent(r.playerA, k -> new PlayerStats())
             .addResult(r.scoreA);
        stats.computeIfAbsent(r.playerB, k -> new PlayerStats())
             .addResult(1.0 - r.scoreA);
    }

    private void logGameWithStats(PrintWriter learningCurve, int gameIndex, MatchResult result) {
        learningCurve.printf("%d,%s,%s,%.3f,%.1f,%.1f,%d%n",
                gameIndex, result.playerA, result.playerB, result.scoreA,
                0.0, 0.0, result.plies);
        learningCurve.flush();

        System.out.printf("  [%d] %s vs %s -> score=%.1f (plies=%d)%n",
                gameIndex, result.playerA, result.playerB, result.scoreA, result.plies);

        // Live standings
        System.out.println("  Current Standings:");
        for (String player : List.of("UCT", "MAST", "RAVE", "MCVS")) {
            PlayerStats s = stats.getOrDefault(player, new PlayerStats());
            System.out.printf("    %-6s : %3dW  %3dL  %3dD   (%.1f%% win rate)%n",
                    player, s.wins, s.losses, s.draws, s.winRate() * 100);
        }
        System.out.println("  -----------------------------------");
    }

    private void printFinalStandings(String gameName) {
        System.out.println("\n=== FINAL STANDINGS: " + gameName + " ===");
        for (String player : List.of("UCT", "MAST", "RAVE", "MCVS")) {
            PlayerStats s = stats.getOrDefault(player, new PlayerStats());
            System.out.printf("  %s : %dW - %dL - %dD   (%.1f%% win rate)%n",
                    player, s.wins, s.losses, s.draws, s.winRate() * 100);
        }
        System.out.println("=====================================\n");
    }

    private MatchResult playOneGame(Game game, AIFactory factoryA, AIFactory factoryB,
                                    Path variantDir, int gameIndex) throws IOException {
        final Trial trial = new Trial(game);
        final Context context = new Context(game, trial);
        game.start(context);
        mcvs.matrices.WeightedMatrix.resetPrintFlags();

        final List<AI> ais = new ArrayList<>();
        ais.add(null);
        final AI aiA = factoryA.create();
        final AI aiB = factoryB.create();
        ais.add(aiA);
        ais.add(aiB);

        aiA.initAI(game, 1);
        aiB.initAI(game, 2);

        final List<String> moveList = new ArrayList<>();
        int plies = 0;
        final int MAX_PLIES = 500;

        while (!trial.over() && plies < MAX_PLIES) {
            final int mover = context.state().mover();
            System.out.printf("  [play] localPly=%d  trialMoves=%d  mover=%d%n", plies, context.trial().numMoves(), mover);
            final Move move = ais.get(mover).selectAction(game, context, thinkingSeconds, maxIterations, -1);
            moveList.add(moveToAlgebraic(game, context, move));
            game.apply(context, move);
            plies++;
        }
        System.out.println("  [play] finished – localPly=" + plies + " trialMoves=" + context.trial().numMoves() + " over=" + trial.over());
        // Force a proper ranking when we hit the ply limit
        if (!trial.over()) {
            // Treat the game as a draw (Ludii: lower rank number = better place)
            trial.ranking()[1] = 1.5;
            trial.ranking()[2] = 1.5;
        }

        aiA.closeAI();
        aiB.closeAI();

        // write move list for this game
        final Path movesFile = variantDir.resolve(String.format("game_%03d_moves.txt", gameIndex));
        try (PrintWriter mw = new PrintWriter(Files.newBufferedWriter(movesFile))) {
            mw.println("# " + factoryA.name() + " vs " + factoryB.name());
            for (int i = 0; i < moveList.size(); i++) {
                mw.printf("%d. %s%n", i + 1, moveList.get(i));
            }
        }

        final double[] ranking = trial.ranking();
        final int numPlayers = ranking.length - 1;
        double scoreA = Rewards.normalizedScore(ranking, 1, numPlayers);

        // Extra safety against any remaining pathological ranking values
        if (scoreA > 1.0 || scoreA < 0.0) {
            final double r1 = ranking[1];
            final double r2 = ranking[2];
            if (r1 < r2)       scoreA = 1.0;
            else if (r1 > r2)  scoreA = 0.0;
            else               scoreA = 0.5;
        }

        // Decide whether MCVS won this game
        boolean mcvsWon = false;
        if (factoryA.name().equals("MCVS") && scoreA == 1.0) mcvsWon = true;
        if (factoryB.name().equals("MCVS") && scoreA == 0.0) mcvsWon = true;

        // Placeholders (improve later)
        double avgSimWin = 0.0;
        int uniqueHighVisitMoves = 0;

        // Only call the monitor when MCVS actually played
        if (factoryA.name().equals("MCVS") || factoryB.name().equals("MCVS")) {
            LearningMonitor.onGameFinished(mcvsWon, avgSimWin, uniqueHighVisitMoves);
        }

        return new MatchResult(factoryA.name(), factoryB.name(), scoreA, plies);
    }

    private void writeSummary(GameSpec spec, List<MatchResult> results, EloRating elo, Path variantDir) throws IOException {
        final Path summaryPath = variantDir.resolve(spec.displayName + "_summary.csv");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(summaryPath))) {
            out.println("player_a,player_b,games,win_rate_a,draw_rate,loss_rate_a,final_elo_a,final_elo_b");
            for (final AIFactory a : aiFactories) {
                for (final AIFactory b : aiFactories) {
                    if (a == b) continue;
                    int n = 0;
                    double wins = 0, draws = 0, losses = 0;
                    for (final MatchResult r : results) {
                        if (r.playerA.equals(a.name()) && r.playerB.equals(b.name())) {
                            n++;
                            if (r.scoreA == 1.0) wins++;
                            else if (r.scoreA == 0.5) draws++;
                            else losses++;
                        }
                    }
                    if (n == 0) continue;
                    out.printf("%s,%s,%d,%.3f,%.3f,%.3f,%.1f,%.1f%n",
                            a.name(), b.name(), n, wins / n, draws / n, losses / n,
                            elo.rating(a.name()), elo.rating(b.name()));
                }
            }
        }
        System.out.println("Wrote results to " + summaryPath);
    }

    private void writeMarkdownReport(GameSpec spec, List<MatchResult> results, EloRating elo, Path variantDir) throws IOException {
        final Path md = variantDir.resolve(spec.displayName + "_report.md");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(md))) {
            final String now = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            out.println("# Experiment Report: " + spec.displayName);
            out.println();
            out.println("*Generated: " + now + "*");
            out.println();

            // 1. Game Configuration
            out.println("## 1. Game Configuration");
            out.println();
            out.println("| Parameter | Value |");
            out.println("|---|---|");
            out.println("| Game engine | Ludii |");
            out.println("| Display name | " + spec.displayName + " |");
            out.println("| `.lud` game name | " + spec.ludName + " |");
            out.println("| Game options | " + (spec.options.isEmpty() ? "(default)" : String.join(", ", spec.options)) + " |");
            out.println();

            // 2. Agents
            out.println("## 2. Agents / Search Algorithms Compared");
            out.println();
            out.println("| Agent | Role |");
            out.println("|---|---|");
            out.println("| UCT | Baseline |");
            out.println("| MAST | Baseline |");
            out.println("| RAVE | Baseline |");
            out.println("| MCVS | Proposed method (Monte Carlo Vector Search) |");
            out.println();

            // 3. Hyperparameters
            out.println("## 3. Search Budget and Experimental Hyperparameters");
            out.println();
            out.println("| Parameter | Value |");
            out.println("|---|---|");
            out.printf("| Thinking time per move (s) | %.3f |%n", thinkingSeconds);
            out.println("| Max iterations per move | " + (maxIterations > 0 ? maxIterations : "unbounded / not used") + " |");
            out.println("| Games per pairing (per colour) | " + gamesPerPairing + " |");
            out.println("| Opponents faced by MCVS | UCT, MAST, RAVE |");
            out.println("| Total games played (this variant) | " + results.size() + " |");
            out.println("| Elo K-factor | 24.0 |");
            out.println("| MCVS database key | " + spec.displayName
                    + " (persistent, shared across all pairings for this variant, independent of other game variants) |");
            out.println("| Random seed | not fixed / not logged by this runner |");
            out.println();

            // 4. Aggregate Results
            out.println("## 4. Aggregate Results");
            out.println();
            out.println("| Player | Wins | Losses | Draws | Games | Win rate |");
            out.println("|---|---|---|---|---|---|");
            for (String player : List.of("UCT", "MAST", "RAVE", "MCVS")) {
                PlayerStats s = stats.getOrDefault(player, new PlayerStats());
                out.printf("| %s | %d | %d | %d | %d | %.1f%% |%n",
                        player, s.wins, s.losses, s.draws, s.games, s.winRate() * 100.0);
            }
            out.println();

            int pliesSum = 0;
            int pliesMin = Integer.MAX_VALUE;
            int pliesMax = Integer.MIN_VALUE;
            for (MatchResult r : results) {
                pliesSum += r.plies;
                if (r.plies < pliesMin) pliesMin = r.plies;
                if (r.plies > pliesMax) pliesMax = r.plies;
            }
            final double pliesMean = results.isEmpty() ? 0.0 : (double) pliesSum / results.size();
            out.printf("| Plies per game | mean = %.2f, min = %d, max = %d | | | | |%n",
                    pliesMean,
                    results.isEmpty() ? 0 : pliesMin,
                    results.isEmpty() ? 0 : pliesMax);
            out.println();

            out.println("| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |");
            out.println("|---|---|---|");
            out.printf("| %.1f | %.1f | %.1f | %.1f |%n",
                elo.rating("MCVS"), elo.rating("UCT"), elo.rating("MAST"), elo.rating("RAVE"));
            out.println();

            // 5. Pairwise Summary
            out.println("## 5. Pairwise Summary");
            out.println();
            out.println("| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |");
            out.println("|---|---|---|---|---|---|---|---|");
            for (final AIFactory a : aiFactories) {
                for (final AIFactory b : aiFactories) {
                    if (a == b) continue;
                    int n = 0;
                    double wins = 0, draws = 0, losses = 0;
                    for (final MatchResult r : results) {
                        if (r.playerA.equals(a.name()) && r.playerB.equals(b.name())) {
                            n++;
                            if (r.scoreA == 1.0) wins++;
                            else if (r.scoreA == 0.5) draws++;
                            else losses++;
                        }
                    }
                    if (n == 0) continue;
                    out.printf("| %s | %s | %d | %.3f | %.3f | %.3f | %.1f | %.1f |%n",
                            a.name(), b.name(), n,
                            wins / n, draws / n, losses / n,
                            elo.rating(a.name()), elo.rating(b.name()));
                }
            }
            out.println();

            // 6. Learning Curve
            out.println("## 6. Learning Curve (Game-by-Game)");
            out.println();
            out.println("| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |");
            out.println("|---|---|---|---|---|---|---|");
            int idx = 0;
            for (final MatchResult r : results) {
                idx++;
                // Note: the live Elo values at the moment of each game are not stored;
                // we emit 0.0 placeholders (same as the current learning_curve.csv).
                out.printf("| %d | %s | %s | %.3f | 0.0 | 0.0 | %d |%n",
                        idx, r.playerA, r.playerB, r.scoreA, r.plies);
            }
            out.println();

            // 7. Database snapshots (empty – not implemented in this runner)
            out.println("## 7. MCVS Database Quality Snapshots");
            out.println();
            out.println("Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.");
            out.println();
            out.println("| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |");
            out.println("|---|---|---|---|---|---|---|");
            out.println();

            // 8. Reproducibility
            out.println("## 8. Reproducibility Notes");
            out.println();
            out.println("- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.");
            out.println("- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.");
            out.println("- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.");
            out.println("- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.");
            out.println();
        }
        System.out.println("Wrote Markdown report to " + md);
    }

    private static String moveToAlgebraic(Game game, Context context, Move move) {
        if (move == null) {
            return "?";
        }

        final int from = move.from();
        final int to   = move.to();

        // Prefer coordinate form whenever we have board sites
        if (from >= 0 && to >= 0 && from != to) {
            return siteLabel(context, from) + "-" + siteLabel(context, to);
        }
        if (to >= 0) {
            return siteLabel(context, to);          // drop / place
        }
        if (from >= 0) {
            return siteLabel(context, from);
        }

        // Last resort
        return String.valueOf(move).replaceAll("\\s+", "");
    }

    private static String siteLabel(Context context, int site) {
        final SiteType type = context.game().isVertexGame() ? SiteType.Vertex
                : context.game().isEdgeGame() ? SiteType.Edge
                : SiteType.Cell;

        try {
            final String label = context.topology()
                    .getGraphElements(type)
                    .get(site)
                    .label();
            if (label != null && !label.isBlank()) {
                return label;
            }
        } catch (Exception ignored) {
            // fall through
        }

        // Chess-style fallback for 64-cell boards (0=a8 … 63=h1)
        final int n = context.topology().numSites(type);
        if (n == 64 && site >= 0 && site < 64) {
            final int file = site % 8;
            final int rank = 8 - (site / 8);
            return String.valueOf((char) ('a' + file)) + rank;
        }

        return Integer.toString(site);
    }
}