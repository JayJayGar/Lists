package tree;

public class Mod extends Expr {
    public Mod(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    public int eval() { return left.eval() % right.eval(); }

    public boolean equals(Object obj) {
        if (!(obj instanceof Mod)) return false;
        Mod other = (Mod)obj;
        return (this.left.equals(other.left) && this.right.equals(other.right)); // x%y = x%y
    }

    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.eval() == 0)
            return new Constant(0); // 0 % x = 0
        if (right instanceof Constant && right.eval() == 1) return left; //x%1=x
        return this;
    }

    public String toString() {
        return "(" + left + "%" + right + ")";
    }
}
