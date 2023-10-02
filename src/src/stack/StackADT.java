package stack;

/**
 * A LIFO list
 * @author JSG
 */
public interface StackADT<E> {
    /** Push given value on top of this StackADT */
    E push(E value);

    /** @return the top value from this StackADT
     * Pre: This StackADT is not empty */
    E peek();

    /** Remove top value from this StackADT
     * @return value removed
     * Pre: This StackADT not empty */
    E pop();
}
