package list;

/** Permit the client to visit every value in a Collection
 * @author JSG
 */

public interface Iterator<E> {
    /** @return true iff there are more values to be visited */
    boolean hasNext();

    /** @return the next value to be visited
     * Pre: hasNext() is true */
    E next();

    /** Remove the last value entered by next()
     * Pre: next() has been called at least once since last call to remove() */
    void remove();
}
