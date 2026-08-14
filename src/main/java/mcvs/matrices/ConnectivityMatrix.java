package mcvs.matrices;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import mcvs.abc.BoardEmbedding;
import mcvs.abc.GameStateSnapshot;
import mcvs.abc.TokenizedVector;

/**
 * Connectivity Matrix C(x(t)) that explicitly encodes the strategic notions
 * important in Hex and Breakthrough:
 *
 *   Hex-style:          real groups, classic bridges, soft influence/territory
 *   Breakthrough-style: rank progress (advancement), tandem support, breakthrough threat
 *   Common:             isolation = weakest-link penalty (rank-aware)
 *
 * Fuse weights can be tuned per game family.  All entries ∈ [0,1].
 */
public final class ConnectivityMatrix {

    // ---------- tunable constants ----------
    public static final double DEFAULT_INFLUENCE_RADIUS  = 2.5;   // soft influence (Hex territory)
    public static final double DEFAULT_ISOLATION_PENALTY = 0.28;
    public static final double BRIDGE_STRENGTH           = 0.92;  // classic 2-bridge

    // channel weights (sum ≈ 1)
    public static final double W_TOPO = 0.30;   // groups + bridges + influence
    public static final double W_ADV  = 0.40;   // advancement / progress
    public static final double W_SUP  = 0.15;   // tandem support / local defence
    public static final double W_THR  = 0.15;   // joint breakthrough threat

    public static final double ADV_RADIUS = 2.2;
    public static final double SUP_RADIUS = 1.9;

    /** Rank from which a piece is considered “advanced” (tune after inspecting Y coords). */
    public static final int ADVANCED_RANK_THRESHOLD = 5;

    private static final double EPS = 1e-6;

    private ConnectivityMatrix() {}

    // ------------------------------------------------------------------
    // Public API
    // ------------------------------------------------------------------

    public static double[][] compute(GameStateSnapshot snapshot) {
        return compute(snapshot, DEFAULT_INFLUENCE_RADIUS, DEFAULT_ISOLATION_PENALTY);
    }

    public static double[][] compute(GameStateSnapshot snapshot,
                                     double influenceRadius,
                                     double isolationPenalty) {

        final BoardEmbedding embedding = snapshot.embedding();
        final int n = snapshot.numSites();
        final double[][] c = new double[n][n];

        // 1) same-colour connected components (real groups)
        final int[] groupId = new int[n];
        Arrays.fill(groupId, -1);
        int numGroups = 0;
        for (int i = 0; i < n; i++) {
            final TokenizedVector ti = snapshot.token(i);
            if (!ti.isOccupied() || groupId[i] != -1) continue;
            floodFill(snapshot, embedding, i, ti.owner, groupId, numGroups);
            numGroups++;
        }

        final int[] groupSize = new int[Math.max(1, numGroups)];
        for (int i = 0; i < n; i++) {
            if (groupId[i] >= 0) groupSize[groupId[i]]++;
        }

        // 2) progress ranks (player-aware: higher = closer to opponent back rank)
        final int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            final TokenizedVector ti = snapshot.token(i);
            rank[i] = ti.isOccupied() ? rankOf(embedding, i, ti.owner) : 0;
        }

        // 3) fill every channel + fuse
        for (int i = 0; i < n; i++) {
            final TokenizedVector ti = snapshot.token(i);
            if (!ti.isOccupied()) continue;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                final TokenizedVector tj = snapshot.token(j);
                if (!tj.isOccupied() || tj.owner != ti.owner) continue;

                // ----- topological core (Hex groups + bridges + soft influence) -----
                double topo;
                if (groupId[i] == groupId[j]) {
                    topo = 1.0;                                     // solid connection
                } else {
                    final double dist = embedding.cellPlacement(i)
                                                 .distanceTo(embedding.cellPlacement(j));
                    if (dist <= influenceRadius) {
                        // soft influence / potential territory
                        final double raw = Math.exp(-dist / influenceRadius) - Math.exp(-1.0);
                        topo = Math.max(EPS, Math.min(1.0 - EPS, raw));
                    } else {
                        topo = 0.0;
                    }
                }
                if (formsBridge(snapshot, embedding, i, j)) {
                    topo = Math.max(topo, BRIDGE_STRENGTH);         // classic virtual connection
                }

                // ----- feature channels -----
                final double adv = advancement(i, j, rank, embedding);
                final double sup = support(i, j, snapshot, embedding);
                final double thr = threat(i, j, rank, embedding);

                // ----- fuse (all channels stay in [0,1]) -----
                final double fused = W_TOPO * topo
                                   + W_ADV  * adv
                                   + W_SUP  * sup
                                   + W_THR  * thr;
                c[i][j] = clamp01(fused);
            }

            // diagonal = isolation / weakest-link penalty (rank-aware)
            final boolean isolated = groupSize[groupId[i]] == 1;
            if (isolated) {
                // more advanced isolated pieces are slightly less punished
                // (they are dangerous runners) but still penalised
                final double rankFactor = 1.0 + 0.12 * rank[i];
                c[i][i] = Math.min(1.0, isolationPenalty * rankFactor);
            } else {
                c[i][i] = 1.0;
            }
        }
        return c;
    }

    // ------------------------------------------------------------------
    // Feature-channel helpers  (the numbers that encode “what I wrote”)
    // ------------------------------------------------------------------

    /**
     * Advancement / progress channel (Breakthrough).
     * High when both pieces are advanced and spatially close.
     */
    private static double advancement(int i, int j, int[] rank, BoardEmbedding embedding) {
        final int ri = rank[i];
        final int rj = rank[j];

        final double progress = 0.5 * (clamp01(ri / 7.0) + clamp01(rj / 7.0)); // 8×8 → /7

        final boolean bothAdvanced = ri >= ADVANCED_RANK_THRESHOLD
                                  && rj >= ADVANCED_RANK_THRESHOLD;
        final boolean oneVeryFar   = Math.max(ri, rj) >= ADVANCED_RANK_THRESHOLD + 2;

        final double base = bothAdvanced ? 0.88
                          : (oneVeryFar  ? 0.68 : 0.32 * progress);

        final double dist = embedding.cellPlacement(i)
                                     .distanceTo(embedding.cellPlacement(j));
        final double spatial = Math.exp(-dist / ADV_RADIUS);
        return clamp01(base * spatial);
    }

    /**
     * Support / tandem defence channel (Breakthrough).
     * 1.0 if direct neighbours; otherwise soft decay inside SUP_RADIUS.
     */
    private static double support(int i, int j,
                                  GameStateSnapshot snapshot,
                                  BoardEmbedding embedding) {
        for (final int n : embedding.neighbours(i)) {
            if (n == j) return 1.0;                 // perfect local support
        }
        final double dist = embedding.cellPlacement(i)
                                     .distanceTo(embedding.cellPlacement(j));
        if (dist > SUP_RADIUS) return 0.0;
        return clamp01(0.72 * Math.exp(-dist / SUP_RADIUS));
    }

    /**
     * Joint breakthrough-threat channel.
     * High when at least one piece is deep and the two are close.
     */
    private static double threat(int i, int j, int[] rank, BoardEmbedding embedding) {
        final int maxRank = Math.max(rank[i], rank[j]);
        if (maxRank < ADVANCED_RANK_THRESHOLD + 1) return 0.0;

        final double dist = embedding.cellPlacement(i)
                                     .distanceTo(embedding.cellPlacement(j));
        if (dist <= 2.0 && maxRank >= ADVANCED_RANK_THRESHOLD + 2) return 0.90;
        if (dist <= 3.0) return 0.55;
        return 0.0;
    }

    // ------------------------------------------------------------------
    // Rank extraction (player-aware)
    // ------------------------------------------------------------------

    /**
     * Progress rank of a site (higher = closer to the opponent’s back rank).
     * Uses the Y coordinate stored by BoardEmbedding.
     * Black (owner==2) advances toward low Y → invert so higher number = more advanced.
     */
    private static int rankOf(BoardEmbedding embedding, int site, int owner) {
        final double[] xy = embedding.cellPlacement(site).components(); // [x, y]
        int raw = (int) Math.round(xy[1]);          // typically 1 .. 8

        if (owner == 2) {                           // Ludii: 1 = P1 (White), 2 = P2 (Black)
            raw = 9 - raw;
        }
        return raw;
    }

    private static double clamp01(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }

    // ------------------------------------------------------------------
    // Existing helpers (unchanged)
    // ------------------------------------------------------------------

    private static boolean formsBridge(GameStateSnapshot snapshot,
                                       BoardEmbedding embedding,
                                       int a, int b) {
        if (a == b) return false;
        final TokenizedVector ta = snapshot.token(a);
        final TokenizedVector tb = snapshot.token(b);
        if (!ta.isOccupied() || !tb.isOccupied() || ta.owner != tb.owner) return false;

        // already adjacent → not a bridge
        for (final int n : embedding.neighbours(a)) {
            if (n == b) return false;
        }

        final List<Integer> commonEmpty = new ArrayList<>();
        for (final int n : embedding.neighbours(a)) {
            if (snapshot.token(n).isOccupied()) continue;
            for (final int m : embedding.neighbours(b)) {
                if (m == n) {
                    commonEmpty.add(n);
                    break;
                }
            }
        }
        return commonEmpty.size() == 2;   // classic two empty cells that complete the bridge
    }

    private static void floodFill(GameStateSnapshot snapshot,
                                  BoardEmbedding embedding,
                                  int start, int owner,
                                  int[] groupId, int group) {
        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        groupId[start] = group;
        while (!stack.isEmpty()) {
            final int cur = stack.pop();
            for (final int neighbour : embedding.neighbours(cur)) {
                if (groupId[neighbour] == -1) {
                    final TokenizedVector tn = snapshot.token(neighbour);
                    if (tn.isOccupied() && tn.owner == owner) {
                        groupId[neighbour] = group;
                        stack.push(neighbour);
                    }
                }
            }
        }
    }
}