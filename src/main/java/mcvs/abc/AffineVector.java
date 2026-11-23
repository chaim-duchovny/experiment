package mcvs.abc;

import java.util.Arrays;

/**
 * Represents an affine placement/translation matrix in homogeneous coordinates, as
 * defined in the paper's Section "Group Operation":
 *
 * <pre>
 *   B = [ I_n   v ]
 *       [ 0     1 ]
 * </pre>
 *
 * Every B_i / T_i used by this framework (piece placement and piece movement, see
 * Sections "Detailed Derivation of abc Model Case 1" and "Complete Algebraic
 * Development of Case 2") is a pure translation, so we only need to store the
 * translation part {@code v = (a_1, ..., a_n)} plus the implicit homogeneous
 * coordinate {@code 1}. Because translation matrices commute
 * (B_1 B_2 = B_2 B_1, shown explicitly in Case 1), composition of two such matrices
 * reduces to plain vector addition -- this is exactly the group operation defined in
 * "Group Operation":
 *
 * <pre>
 *   &lt;v_1,1&gt; (+) &lt;v_2,1&gt; = &lt;a_1+b_1, ..., a_n+b_n, 1&gt;
 *   z (.) &lt;v_1,1&gt;       = &lt;z*a_1, ..., z*a_n, 1&gt;
 * </pre>
 */
public final class AffineVector {

    private final double[] v; // translation part (a_1, ..., a_n)

    public AffineVector(double[] v) {
        this.v = v.clone();
    }

    /** The identity affine matrix B(0) = I, i.e. the zero translation. */
    public static AffineVector identity(int n) {
        return new AffineVector(new double[n]);
    }

    public int dim() {
        return v.length;
    }

    public double[] components() {
        return v.clone();
    }

    /** Group sum: {@code <v1,1> (+) <v2,1> = <v1+v2,1>} (Eq. in Section "Group Operation"). */
    public AffineVector oplus(AffineVector other) {
        final double[] r = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            r[i] = v[i] + other.v[i];
        }
        return new AffineVector(r);
    }

    /** Scalar multiplication: {@code z (.) <v,1> = <z*v,1>}. */
    public AffineVector scale(double z) {
        final double[] r = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            r[i] = z * v[i];
        }
        return new AffineVector(r);
    }

    /**
     * Applies this translation to a homogeneous "centre" point c, i.e. computes B*c.
     * Since B is a pure translation, B*c = c + v.
     */
    public double[] apply(double[] center) {
        final double[] r = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            r[i] = center[i] + v[i];
        }
        return r;
    }

    /** Euclidean distance between two placements, used by the Distance Matrix D(x(t)). */
    public double distanceTo(AffineVector other) {
        double sum = 0.0;
        for (int i = 0; i < v.length; i++) {
            final double d = v[i] - other.v[i];
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        return Arrays.toString(v);
    }
}
