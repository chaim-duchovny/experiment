package mcvs.search;

import java.util.ArrayList;
import java.util.List;

import main.collections.FastArrayList;
import other.move.Move;

/**
 * Generic MCTS tree node shared by {@link UCTPlayer} and {@link MASTPlayer}. Q(s,a) /
 * N(s,a) are stored on the CHILD node (the standard convention: {@code child.q()} /
 * {@code child.visitCount} are the statistics of the action that produced this child
 * from its parent), matching Algorithm "Update Q and N (Backpropagation)":
 * {@code N(s,a) += 1; Q(s,a) += (R - Q(s,a)) / N(s,a)}.
 */
public final class TreeNode {

    public final TreeNode parent;
    public final Move moveFromParent;
    public final int mover; // player who made moveFromParent (mover at the parent state)
    public final List<TreeNode> children = new ArrayList<>();

    public FastArrayList<Move> untriedMoves;
    public double totalValue = 0.0;
    public int visitCount = 0;

    public TreeNode(TreeNode parent, Move moveFromParent, int mover) {
        this.parent = parent;
        this.moveFromParent = moveFromParent;
        this.mover = mover;
    }

    /** Q(s,a) = running mean of all rewards backpropagated through this node. */
    public double q() {
        return visitCount == 0 ? 0.0 : totalValue / visitCount;
    }

    /** Algorithm "Update Q and N (Backpropagation)": N += 1, Q += (R - Q)/N. */
    public void backpropagate(double reward) {
        visitCount++;
        totalValue += reward;
    }
}
