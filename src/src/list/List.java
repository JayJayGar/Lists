package list;

/** A list is an ordered Collection, Duplicates permitted
 * @author JSG
 * @param <E>
 */
public interface List<E> {
    /** @return the value given ndx
     * @param //0<=ndx<size */
    E get(int ndx);

    /** Change the value at given ndx to the given value
     * @param //0<=ndx<size
     * @return The old value */
    E set(int ndx, E value);

    /** Add the given value at the end of this List **/
    void add(E value);

    /** Insert the given value at the given ndx
     * @param //0<=ndx<=size */
    void add(int ndx, E value);

    /** Remove the value at the given ndx
     * @return the value removed
     * @param //0<=ndx<size */
    E remove(int ndx);

    int size();

    /** @return an Iterator for this List */
    Iterator<E> iterator();

    /** @return a ListIterator for this List */
    ListIterator<E> listIterator();

    /** @return a ListIterator for this List, beginning at the given ndx
     * use size to begin at end */
    ListIterator<E> listIterator(int ndx);

    boolean isEmpty();

    /** @return index of first occurrence of given value,
     * or -1 if not found */
    int indexOf(E value); // sequential search
}
