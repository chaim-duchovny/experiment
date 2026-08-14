package mcvs.experiment;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard incremental Elo rating tracker used by {@link ExperimentRunner} to report
 * relative playing strength between UCT / MAST / MCVS across the tournament
 * (deliverable: "Main experiment runner that plays tournaments and outputs win rates,
 * Elo, learning curves").
 */
public final class EloRating {

    private final Map<String, Double> ratings = new HashMap<>();
    private final double kFactor;

    public EloRating(double kFactor) {
        this.kFactor = kFactor;
    }

    public double rating(String player) {
        return ratings.getOrDefault(player, 1200.0);
    }

    /** scoreA: 1.0 = win for playerA, 0.5 = draw, 0.0 = loss. */
    public void update(String playerA, String playerB, double scoreA) {
        final double ra = rating(playerA);
        final double rb = rating(playerB);
        final double expectedA = 1.0 / (1.0 + Math.pow(10.0, (rb - ra) / 400.0));
        final double expectedB = 1.0 - expectedA;
        ratings.put(playerA, ra + kFactor * (scoreA - expectedA));
        ratings.put(playerB, rb + kFactor * ((1.0 - scoreA) - expectedB));
    }
}
