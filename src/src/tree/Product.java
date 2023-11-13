package tree;

/** A product represents multiplication */
public class Product extends Expr {
    public Product(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    public int eval() { return left.eval() * right.eval(); }

    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) return false;
        Product other = (Product)obj;
        return (this.left.equals(other.left) && this.right.equals(other.right) || // x*y=x*y
                this.left.equals(other.right) && this.right.equals(other.left)); // x*y=y*x
    }

    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.eval() == 0 ||
                right instanceof Constant && right.eval() == 0)
            return new Constant(0); // 0 * x & x * 0 = 0
        if (left instanceof Constant && left.eval() == 1) return right; //x*1=x
        if (right instanceof Constant && right.eval() == 1) return left; //1*x=x
        return this;
    }

    public String toString() {
        return "(" + left + "*" + right + ")";
    }
}
