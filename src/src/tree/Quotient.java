package tree;

public class Quotient extends Expr {
    public Quotient(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    public int eval() { return left.eval() / right.eval(); }

    public boolean equals(Object obj) {
        if (!(obj instanceof Quotient)) return false;
        Quotient other = (Quotient)obj;
        return (left.equals(other.left) && right.equals(other.right));
    }

    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.eval() == 0) return right; // 0 / x = 0
        if (left.equals(right))
            return new Constant(1);
        return this;
    }

    public String toString() {
        return "(" + left + "/" + right + ")";
    }
}
