package mcvs.matrices;

import mcvs.abc.GameStateSnapshot;
import mcvs.abc.TokenizedVector;

/**
 * Builds the Token Matrix T(x(t)), Definition "Token Matrix T":
 *
 * <pre>
 *   T(x(t)) = diag(T_1, ..., T_n),   T_i = v(kappa(t,B_i)) if occupied, else 0.
 * </pre>
 */
public final class TokenMatrix {

    private TokenMatrix() {}

    public static double[][] compute(GameStateSnapshot snapshot) {
        final int n = snapshot.numSites();
        final double[][] t = new double[n][n];
        for (int i = 0; i < n; i++) {
            final TokenizedVector token = snapshot.token(i);
            t[i][i] = token.isOccupied() ? token.value() : 0.0;
        }
        return t;
    }
}
