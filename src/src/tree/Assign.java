package tree;

public class Assign extends Expr {
    Expr left;
    Expr right;
    public Assign(Expr x, Expr y) {
        this.left=x;
        this.right=y;
    }

    public int eval() {
        if (!(left instanceof Variable)) return -1; //left should be variable
        Variable var = (Variable)left; //left is variable
        if (!(right instanceof Variable)) {
            var.setValue(right.eval()); //set left to right value
            return left.eval(); //return left value
        }
        Variable var2 = (Variable)right; //right is variable
        var.setValue(var2.value); //left = right value
        return left.eval(); //return left
    }

    public boolean equals(Object obj) { return false; }

    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        return this;
    }

    public String toString() {
        return "(" + left + "=" + right + ")";
    }
}
