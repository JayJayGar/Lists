package tree;

/* An Expr may have left and right operands, each of which is an Expr.
* using ints.
* @author JSG */
public abstract class Expr {
    Expr left, right;

    /** @return the value of this Expr */
    public abstract int eval();

    /** @return true iff this Expr is the same as Obj */
    public abstract boolean equals(Object obj);

    /** @return a simplified version of this Expr */
    public abstract Expr simplify();
}
