package list;

/**
 * An Iterator for Lists
 * @author JSG
 */
public interface ListIterator<E> extends Iterator<E> {
    /** @return true iff there is a previous value */
    boolean hasPrevious();

    /** @return previous value
     * Pre: hasPrevious() is true */
    E previous();

    /** Remove the last value obtained by next() or prev()
     * Pre: next() or prev() has been called since last remove */
    void remove();

}
