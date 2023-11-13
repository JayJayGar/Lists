package tree;

public class Difference extends Expr {
    public Difference(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    public int eval() { return left.eval() - right.eval(); }

    public boolean equals(Object obj) {
        if (!(obj instanceof Difference)) return false;
        Difference other = (Difference)obj;
        return (left.equals(other.left) && right.equals(other.right));
    }

    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (right instanceof Constant && right.eval() == 0) return left; // x - 0 = x
        if (left.equals(right)) return new Constant(0);
        return this;
    }

    public String toString() {
        return "(" + left + "-" + right + ")";
    }
}
