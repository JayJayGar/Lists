package set;

import list.Iterator;

public interface Set<E> {
    boolean add(E value);

    boolean contains(Object obj);

    boolean remove(Object obj);

    /**
     * @return the size of this Set
     */
    int size();

    /**
     * @return true iff this Set is empty
     */
    boolean isEmpty();

    /** Clear this Set */
    void clear();

    /**
     * @return true iff the given object is a Set and it contains exactly the same values as this Set
     */
    boolean equals(Object obj);

    Iterator<E> iterator();
}