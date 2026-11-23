package mcvs.abc;

import java.awt.geom.Point2D;
import java.util.List;

import game.types.board.SiteType;
import other.context.Context;
import other.topology.TopologyElement;

/**
 * Builds the <b>static board</b> (SB) of the abc model (Definition "The abc Model"):
 * for every board site {@code B_i} we precompute its fixed affine placement matrix
 * (a pure translation from the board centre) and its topological neighbours, once per
 * game, from Ludii's {@link other.topology.Topology}.
 *
 * <p>The centre {@code c(0)} is fixed at the origin in homogeneous coordinates, as
 * stated in Section "Monte Carlo Vector Search (MCVS)", Stage 1: "the board is
 * centered at the origin in homogeneous coordinates: c(0) = (0,0,1)^T."
 *
 * <p>This embedding is reused, unchanged, for every state of a given game instance:
 * only the {@link TokenizedVector} occupancy/owner information (Section "Algebraic
 * Structure Analysis") changes from one game state x(t) to the next.
 */
public final class BoardEmbedding {

    private final SiteType siteType;
    private final int numSites;
    private final AffineVector[] cellPlacements; // B_i for i = 0..numSites-1
    private final int[][] neighbourIndices;      // board adjacency graph, used by A(x(t))
    private final AffineVector center0;          // c(0)

    public BoardEmbedding(Context context) {
        this.siteType = context.game().isVertexGame() ? SiteType.Vertex
                : context.game().isEdgeGame() ? SiteType.Edge
                : SiteType.Cell;

        final List<? extends TopologyElement> elements = context.topology().getGraphElements(siteType);
        this.numSites = elements.size();
        this.cellPlacements = new AffineVector[numSites];
        this.neighbourIndices = new int[numSites][];

        for (final TopologyElement e : elements) {
            final Point2D p = e.centroid();
            cellPlacements[e.index()] = new AffineVector(new double[] { p.getX(), p.getY() });

            final List<? extends TopologyElement> neighbours = e.neighbours();
            final int[] idx = new int[neighbours.size()];
            for (int k = 0; k < neighbours.size(); k++) {
                idx[k] = neighbours.get(k).index();
            }
            neighbourIndices[e.index()] = idx;
        }

        this.center0 = AffineVector.identity(2);
    }

    public SiteType siteType() {
        return siteType;
    }

    public int numSites() {
        return numSites;
    }

    /** The fixed placement matrix B_i (translation from c(0) to the centroid of site i). */
    public AffineVector cellPlacement(int i) {
        return cellPlacements[i];
    }

    /** Topological neighbours of site i, used to build the Adjacency Matrix A(x(t)). */
    public int[] neighbours(int i) {
        return neighbourIndices[i];
    }

    /** c(0), the fixed board centre in homogeneous coordinates. */
    public AffineVector center0() {
        return center0;
    }
}
