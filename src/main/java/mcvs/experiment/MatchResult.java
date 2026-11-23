package mcvs.experiment;

/** Outcome of a single tournament game between two named AI players. */
public final class MatchResult {

    public final String playerA;
    public final String playerB;
    public final double scoreA; // 1.0 win / 0.5 draw / 0.0 loss, from playerA's perspective
    public final int plies;

    public MatchResult(String playerA, String playerB, double scoreA, int plies) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.scoreA = scoreA;
        this.plies = plies;
    }
}
