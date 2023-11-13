package tree;

public class Variable extends Expr {
    char name;
    Integer value;
    public Variable(char name) { this.name = name; }

    public int eval() throws IllegalArgumentException{
        if (value == null)
            throw new IllegalArgumentException();
        return value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) return false;
        Variable other = (Variable) obj;
        return name == other.name;
    }

    public Expr simplify() { return this; }

    public String toString() { return name + ""; }

    public void setValue(int value) { this.value = value; }
}
