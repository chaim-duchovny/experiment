package mcvs.abc;

/**
 * The tokenized vector {@code kappa(t,B_i) = (kappa_1, kappa_2, ...)} of Definition
 * "Tokenized Vector" and Eq. "Tokenized-Vector":
 *
 * <pre>
 *   kappa_1(B_i) = 1 if B_i is occupied by a piece, 0 otherwise
 *   kappa_2(B_i) = the piece's colour / type / strategic value token
 * </pre>
 *
 * <p>{@code kappa_2} generalises the paper's worked Go example (black = 2, white = 3,
 * Section "Algebraic Structure Analysis") to an arbitrary number of players via
 * {@code value = playerIndex + 1}, so that Player 1 -> 2, Player 2 -> 3, etc. This is
 * exactly the convention used by the paper's example (Piece A / first player -> 2,
 * Piece B / second player -> 3).
 */
public final class TokenizedVector {

    public final int siteIndex;
    public final int kappa1;   // occupancy indicator
    public final int owner;    // player index, 0 = empty
    public final double kappa2; // strategic value token v(kappa)

    public TokenizedVector(int siteIndex, int kappa1, int owner, double kappa2) {
        this.siteIndex = siteIndex;
        this.kappa1 = kappa1;
        this.owner = owner;
        this.kappa2 = kappa2;
    }

    public boolean isOccupied() {
        return kappa1 == 1;
    }

    /** v(kappa): maps the tokenized vector to a strategic-importance value, used
     *  directly by the Token Matrix T (Definition "Token Matrix T"). */
    public double value() {
        return kappa2;
    }

    public static TokenizedVector empty(int siteIndex) {
        return new TokenizedVector(siteIndex, 0, 0, 0.0);
    }
}
