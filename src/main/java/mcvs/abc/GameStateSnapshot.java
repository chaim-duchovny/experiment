package mcvs.abc;

import other.context.Context;
import other.state.container.ContainerState;

/**
 * A level-t vector game graph {@code x(t) = b(t).c(t)} (Eq. "abc_formulation"): a
 * snapshot of the tokenized vectors {@code kappa(t,B_i)} for every cell {@code B_i} of
 * the static board SB, given the current Ludii {@link Context}.
 *
 * <p>This is the fundamental input consumed by the Adjacency/Distance/Token matrix
 * builders in {@code mcvs.matrices} (Section "Algebraic Structure Analysis").
 */
public final class GameStateSnapshot {

    private final BoardEmbedding embedding;
    private final TokenizedVector[] tokens;

    public GameStateSnapshot(Context context, BoardEmbedding embedding, int perspective) {
        this.embedding = embedding;
        final int n = embedding.numSites();
        this.tokens = new TokenizedVector[n];

        final ContainerState containerState = context.containerState(0);
        for (int i = 0; i < n; i++) {
            final int who = containerState.who(i, embedding.siteType());
            if (who <= 0) {
                tokens[i] = TokenizedVector.empty(i);
            } else {
                // self = 2.0, any other player = 3.0
                final double kappa2 = (who == perspective) ? 2.0 : 3.0;
                tokens[i] = new TokenizedVector(i, 1, who, kappa2);
            }
        }
    }

    public int numSites() {
        return embedding.numSites();
    }

    public TokenizedVector token(int i) {
        return tokens[i];
    }

    public BoardEmbedding embedding() {
        return embedding;
    }
}
