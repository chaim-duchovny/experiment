package mcvs.database;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import mcvs.matrices.Similarity;
import mcvs.matrices.WeightedMatrix;

/**
 * Persistent, per-game database D = {D_win, D_loss, D_draw}.
 * One shared instance per variant key via {@link #mcvsDatabase()}.
 */
public final class VectorDatabase {

    //private static final double MERGE_THRESHOLD = 1.0e-6;
    private static final double MERGE_THRESHOLD = 1.0e-6;
    //private static final int MAX_NODES = 300_000;
    private static final int MAX_NODES = 300_000;
    //private static final int PRUNE_INTERVAL_GAMES = 25_000;
    private static final int PRUNE_INTERVAL_GAMES = 1_000;
    //private static int pruneSizeThreshold = 250_000;
    private static int pruneSizeThreshold = 30_000;

    private static int minVisitsForDepth(int depth) {
        if (depth <= 4)  return 100;
        if (depth <= 10) return 50;
        return 25;
    }

    public static void setPruneSizeThreshold(int newThreshold) {
        pruneSizeThreshold = newThreshold;
    }

    public static int pruneSizeThreshold() {
        return pruneSizeThreshold;
    }

    // ---- per-variant registry ----
    private static final Map<String, VectorDatabase> PER_GAME_DATABASES = new ConcurrentHashMap<>();
    private static volatile String activeGameKey = "default";

    public static void setActiveGameKey(String gameKey) {
        activeGameKey = gameKey;
    }

    public static String activeGameKey() {
        return activeGameKey;
    }

    public static VectorDatabase mcvsDatabase() {
        return mcvsDatabase(activeGameKey);
    }

    public static VectorDatabase mcvsDatabase(String gameKey) {
        return PER_GAME_DATABASES.computeIfAbsent(gameKey, k -> new VectorDatabase());
    }

    // ---- instance state ----
    private final Map<Integer, List<NodeRecord>> win  = new ConcurrentHashMap<>();
    private final Map<Integer, List<NodeRecord>> loss = new ConcurrentHashMap<>();
    private final Map<Integer, List<NodeRecord>> draw = new ConcurrentHashMap<>();

    private final AtomicInteger completeGames = new AtomicInteger(0);
    private final AtomicInteger nodeCount     = new AtomicInteger(0);

    private static final int ACTIVATION_GAMES = 1;
    
    public boolean isActive() {
        return completeGames.get() >= ACTIVATION_GAMES;
    }

    public int completeGames() {
        return completeGames.get();
    }

    public int totalSize() {
        return nodeCount.get();
    }

    public int partitionSize(NodeRecord.Outcome outcome) {
        int total = 0;
        for (final List<NodeRecord> pool : partitionFor(outcome).values()) {
            total += pool.size();
        }
        return total;
    }

    public VectorDatabase copy() {
        final VectorDatabase snapshot = new VectorDatabase();
        copyPartitionInto(win,  snapshot.win,  NodeRecord.Outcome.WIN);
        copyPartitionInto(loss, snapshot.loss, NodeRecord.Outcome.LOSS);
        copyPartitionInto(draw, snapshot.draw, NodeRecord.Outcome.DRAW);
        snapshot.completeGames.set(this.completeGames.get());
        snapshot.nodeCount.set(this.nodeCount.get());
        return snapshot;
    }

    private static void copyPartitionInto(Map<Integer, List<NodeRecord>> source,
                                          Map<Integer, List<NodeRecord>> dest,
                                          NodeRecord.Outcome outcome) {
        for (final Map.Entry<Integer, List<NodeRecord>> entry : source.entrySet()) {
            final int depth = entry.getKey();
            final List<NodeRecord> copiedPool = new CopyOnWriteArrayList<>();
            for (final NodeRecord r : entry.getValue()) {
                copiedPool.add(new NodeRecord(depth, r.weightedMatrix, r.q, r.n, outcome));
            }
            dest.put(depth, copiedPool);
        }
    }

    public void commitTrace(GameTrace trace, NodeRecord.Outcome outcome, int startDepth) {
        final double outcomeReward = outcome == NodeRecord.Outcome.WIN ? 1.0
                : outcome == NodeRecord.Outcome.LOSS ? 0.0
                : 0.5;

        final Map<Integer, List<NodeRecord>> partition = partitionFor(outcome);
        for (int i = 0; i < trace.length(); i++) {
            final int depth = startDepth + i;
            final double[][] w = trace.matrixAt(i);
            final List<NodeRecord> pool =
                    partition.computeIfAbsent(depth, d -> new CopyOnWriteArrayList<>());

            final NodeRecord existing = findNearDuplicate(pool, w);
            if (existing != null) {
                synchronized (existing) {
                    existing.n++;
                    existing.q += (outcomeReward - existing.q) / existing.n;
                }
            } else {
                pool.add(new NodeRecord(depth, w, outcomeReward, 1, outcome));
                nodeCount.incrementAndGet();
            }
        }

        final int gamesSoFar = completeGames.incrementAndGet();
        if (gamesSoFar % PRUNE_INTERVAL_GAMES == 0 || totalSize() >= pruneSizeThreshold) {
            pruneLowVisitNodes();
        }
        enforceCapacity();
    }

    public List<NodeRecord> queryByLevel(NodeRecord.Outcome outcome, int depth) {
        return partitionFor(outcome).getOrDefault(depth, List.of());
    }

    public double maxSimilarityAtDepth(double[][] w, NodeRecord.Outcome outcome, int depth) {
        double best = 0.0;
        for (final NodeRecord record : queryByLevel(outcome, depth)) {
            final double sim = Similarity.similarity(w, record.weightedMatrix);
            if (sim > best) {
                best = sim;
            }
        }
        return best;
    }

    public NodeRecord bestMatch(double[][] w, NodeRecord.Outcome outcome, int depth) {
        NodeRecord best = null;
        double bestSim = Double.NEGATIVE_INFINITY;
        for (final NodeRecord record : queryByLevel(outcome, depth)) {
            final double sim = Similarity.similarity(w, record.weightedMatrix);
            if (sim > bestSim) {
                bestSim = sim;
                best = record;
            }
        }
        return best;
    }

    private synchronized void pruneLowVisitNodes() {
        final int[] bandRemoved = new int[3];
        int removed = 0;
        removed += pruneMap(win,  bandRemoved);
        removed += pruneMap(loss, bandRemoved);
        removed += pruneMap(draw, bandRemoved);

        if (removed > 0) {
            nodeCount.addAndGet(-removed);
            System.out.printf(
                    "[VectorDatabase] pruned %d low-visit nodes "
                            + "(early n<%d: %d, mid n<%d: %d, late n<%d: %d) "
                            + "at games=%d (size now %d)%n",
                    removed,
                    minVisitsForDepth(1),  bandRemoved[0],
                    minVisitsForDepth(5),  bandRemoved[1],
                    minVisitsForDepth(11), bandRemoved[2],
                    completeGames.get(),
                    totalSize());
        }
    }

    private static int pruneMap(Map<Integer, List<NodeRecord>> partition, int[] bandRemoved) {
        int removed = 0;
        for (final Map.Entry<Integer, List<NodeRecord>> entry : partition.entrySet()) {
            final int depth = entry.getKey();
            final List<NodeRecord> pool = entry.getValue();
            final int minVisits = minVisitsForDepth(depth);

            final int before = pool.size();
            if (before == 0) {
                continue;
            }

            boolean hasSurvivor = false;
            for (final NodeRecord r : pool) {
                if (r.n >= minVisits) {
                    hasSurvivor = true;
                    break;
                }
            }

            if (hasSurvivor) {
                pool.removeIf(r -> r.n < minVisits);
            } else {
                NodeRecord best = null;
                for (final NodeRecord r : pool) {
                    if (best == null || r.q > best.q) {
                        best = r;
                    }
                }
                final NodeRecord keep = best;
                pool.removeIf(r -> r != keep);
            }

            final int delta = before - pool.size();
            removed += delta;
            if (depth <= 4) {
                bandRemoved[0] += delta;
            } else if (depth <= 10) {
                bandRemoved[1] += delta;
            } else {
                bandRemoved[2] += delta;
            }
        }
        return removed;
    }

    private synchronized void enforceCapacity() {
        int total = totalSize();
        while (total > MAX_NODES) {
            NodeRecord worst = null;
            List<NodeRecord> worstPool = null;
            for (final Map<Integer, List<NodeRecord>> partition : List.of(win, loss, draw)) {
                for (final List<NodeRecord> pool : partition.values()) {
                    for (final NodeRecord r : pool) {
                        if (worst == null
                                || r.n < worst.n
                                || (r.n == worst.n && r.q < worst.q)) {
                            worst = r;
                            worstPool = pool;
                        }
                    }
                }
            }
            if (worst == null) {
                break;
            }
            worstPool.remove(worst);
            nodeCount.decrementAndGet();
            total--;
        }
    }

    private Map<Integer, List<NodeRecord>> partitionFor(NodeRecord.Outcome outcome) {
        switch (outcome) {
            case WIN:
                return win;
            case LOSS:
                return loss;
            default:
                return draw;
        }
    }

    private static NodeRecord findNearDuplicate(List<NodeRecord> pool, double[][] w) {
        for (final NodeRecord record : pool) {
            if (WeightedMatrix.frobeniusDistance(record.weightedMatrix, w) < MERGE_THRESHOLD) {
                return record;
            }
        }
        return null;
    }

    public synchronized void exportToJson(Path path) throws IOException {
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("{\n");
            writer.write("  \"generatedAt\": \"" + java.time.Instant.now() + "\",\n");
            writer.write("  \"isActive\": " + isActive() + ",\n");
            writer.write("  \"completeGames\": " + completeGames.get() + ",\n");
            writer.write("  \"totalNodes\": " + totalSize() + ",\n");
            writer.write("  \"partitions\": {\n");
            appendPartitionJson(writer, "win", win);
            writer.write(",\n");
            appendPartitionJson(writer, "loss", loss);
            writer.write(",\n");
            appendPartitionJson(writer, "draw", draw);
            writer.write("\n  }\n");
            writer.write("}\n");
        }
    }

    private static void appendPartitionJson(BufferedWriter writer, String name,
                                            Map<Integer, List<NodeRecord>> partition)
            throws IOException {
        writer.write("    \"" + name + "\": {\n");
        final List<Integer> depths = new ArrayList<>(partition.keySet());
        Collections.sort(depths);
        for (int di = 0; di < depths.size(); di++) {
            final int depth = depths.get(di);
            writer.write("      \"" + depth + "\": [\n");
            final List<NodeRecord> pool = partition.get(depth);
            for (int i = 0; i < pool.size(); i++) {
                final NodeRecord r = pool.get(i);
                writer.write("        {\"n\": " + r.n
                        + ", \"q\": " + r.q
                        + ", \"matrix\": " + matrixToJson(r.weightedMatrix)
                        + "}");
                writer.write(i < pool.size() - 1 ? ",\n" : "\n");
            }
            writer.write("      ]");
            writer.write(di < depths.size() - 1 ? ",\n" : "\n");
        }
        writer.write("    }");
    }

    private static String matrixToJson(double[][] m) {
        if (m == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder("[");
        for (int r = 0; r < m.length; r++) {
            sb.append("[");
            for (int c = 0; c < m[r].length; c++) {
                sb.append(m[r][c]);
                if (c < m[r].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (r < m.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Max similarity at {@code depth}, or if that pool is empty, the best over
     * [depth - window, depth + window] (clamped to >= 0).
     */
    public double maxSimilarityNearDepth(double[][] w, NodeRecord.Outcome outcome, int depth, int window) {
        double best = maxSimilarityAtDepth(w, outcome, depth);
        if (best > 0.0 || window <= 0) {
            return best;
        }
        for (int d = Math.max(0, depth - window); d <= depth + window; d++) {
            if (d == depth) continue;
            final double sim = maxSimilarityAtDepth(w, outcome, d);
            if (sim > best) best = sim;
        }
        return best;
    }
}