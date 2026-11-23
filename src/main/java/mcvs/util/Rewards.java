package mcvs.util;

/**
 * Small helper for converting Ludii's {@code Trial.ranking()} output into a
 * normalised score in [0,1] (1.0 = win, 0.5 = draw, 0.0 = loss).
 *
 * <p>Ludii's {@code Trial.ranking()} returns, for each player, their final
 * <em>rank</em> (1.0 = outright 1st place/win, 2.0 = 2nd place, etc., with tied
 * players receiving the averaged rank -- e.g. 1.5 each in a 2-player draw), not an
 * already-normalised win/loss score. All reward signals used by the search
 * algorithms in this project (UCT/MAST backpropagation, the tournament's win-rate
 * reporting) need a normalised score, so every consumer of {@code ranking()} in this
 * codebase goes through this helper instead of using the raw rank directly.
 */
public final class Rewards {

    private Rewards() {}

    /**
     * Converts a raw rank (as returned by {@code Trial.ranking()[player]}) into a
     * normalised score in [0,1], where 1.0 = win, 0.0 = loss, and intermediate values
     * (e.g. 0.5 for a 2-player draw) represent ties, assuming {@code numPlayers >= 2}.
     */
    public static double normalizedScore(double rank, int numPlayers) {
        if (numPlayers <= 1) {
            return 1.0;
        }
        return (numPlayers - rank) / (numPlayers - 1.0);
    }

    public static double normalizedScore(double[] ranking, int player, int numPlayers) {
        return normalizedScore(ranking[player], numPlayers);
    }
}
