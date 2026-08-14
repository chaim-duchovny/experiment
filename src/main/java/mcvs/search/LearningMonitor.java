package mcvs.search;   

import java.util.ArrayDeque;
import java.util.Deque;

public class LearningMonitor {

    private static final int WINDOW = 200;
    private static final Deque<Boolean> recentResults = new ArrayDeque<>();
    private static final Deque<Double>  recentSimWin  = new ArrayDeque<>();
    private static final Deque<Integer> recentUniqueLines = new ArrayDeque<>();

    private static int totalGames = 0;
    private static int earlyWins  = 0;
    private static final int EARLY_GAMES = 300;

    public static void onGameFinished(boolean won,
                                  double avgSimWinOfPlayedMoves,
                                  int uniqueHighVisitMoves) {

        totalGames++;

        // ★ MUST appear for every call
        System.out.println("[LearningMonitor] called  totalGames=" + totalGames);

        recentResults.addLast(won);
        if (recentResults.size() > WINDOW) recentResults.removeFirst();

        recentSimWin.addLast(avgSimWinOfPlayedMoves);
        if (recentSimWin.size() > WINDOW) recentSimWin.removeFirst();

        recentUniqueLines.addLast(uniqueHighVisitMoves);
        if (recentUniqueLines.size() > WINDOW) recentUniqueLines.removeFirst();

        if (totalGames <= EARLY_GAMES && won) earlyWins++;

        // Print every time for now (remove the % 100 later)
        if (totalGames % 10 == 0) {
            printReport();
        }
    }

    private static void printReport() {
        double recentWinRate = averageBoolean(recentResults);
        double earlyWinRate  = totalGames >= EARLY_GAMES
                            ? earlyWins / (double) EARLY_GAMES
                            : recentWinRate;

        double avgSimWin = averageDouble(recentSimWin);
        double avgFocus  = averageInt(recentUniqueLines);

        // ----- console -----
        System.out.println("========== MCVS Learning Report ==========");
        System.out.printf("Games so far               : %d%n", totalGames);
        System.out.printf("Early win-rate (first %d)  : %.3f%n", EARLY_GAMES, earlyWinRate);
        System.out.printf("Recent win-rate (last %d)  : %.3f%n", WINDOW, recentWinRate);
        System.out.printf("Avg SimWin on played moves : %.3f%n", avgSimWin);
        System.out.printf("Search concentration       : %.1f  (lower = more focused)%n", avgFocus);
        System.out.println("-------------------------------------------");

        String phase;
        if (totalGames < EARLY_GAMES) {
            phase = "Phase: early / cold-start (expect near-UCT behaviour)";
        } else if (recentWinRate > earlyWinRate + 0.05 && avgSimWin > 0.55) {
            phase = "Phase: LEARNING visible – recent wins higher + SimWin rising";
        } else if (recentWinRate > earlyWinRate + 0.05) {
            phase = "Phase: win-rate improving (check if SimWin is also rising)";
        } else {
            phase = "Phase: no clear learning yet";
        }
        System.out.println(phase);
        System.out.println("===========================================\n");

        // ----- also write to file -----
        try {
            java.nio.file.Path logPath = java.nio.file.Path.of("results", "learning_monitor.log");
            if (logPath.getParent() != null) {
                java.nio.file.Files.createDirectories(logPath.getParent());
            }
            try (java.io.PrintWriter pw = new java.io.PrintWriter(
                    new java.io.FileWriter(logPath.toFile(), true))) {   // append = true
                pw.println("========== MCVS Learning Report ==========");
                pw.printf("Games so far               : %d%n", totalGames);
                pw.printf("Early win-rate (first %d)  : %.3f%n", EARLY_GAMES, earlyWinRate);
                pw.printf("Recent win-rate (last %d)  : %.3f%n", WINDOW, recentWinRate);
                pw.printf("Avg SimWin on played moves : %.3f%n", avgSimWin);
                pw.printf("Search concentration       : %.1f  (lower = more focused)%n", avgFocus);
                pw.println("-------------------------------------------");
                pw.println(phase);
                pw.println("===========================================\n");
            }
        } catch (Exception e) {
            System.err.println("[LearningMonitor] failed to write log: " + e.getMessage());
        }
    }

    private static double averageBoolean(Deque<Boolean> d) {
        if (d.isEmpty()) return 0.0;
        int sum = 0;
        for (boolean b : d) if (b) sum++;
        return sum / (double) d.size();
    }

    private static double averageDouble(Deque<Double> d) {
        if (d.isEmpty()) return 0.0;
        double sum = 0;
        for (double v : d) sum += v;
        return sum / d.size();
    }

    private static double averageInt(Deque<Integer> d) {
        if (d.isEmpty()) return 0.0;
        int sum = 0;
        for (int v : d) sum += v;
        return sum / (double) d.size();
    }
}