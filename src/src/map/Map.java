package map;

import set.Set;

/** A collection of entries, each of which has a key and value
 * Access is fast by key.
 * @author JSG */
public interface Map<K,V> {
    /** @return true iff given key is in this Map */
    boolean containsKey(K key);

    /** @return the value for a givne key, or null if not found */
    V get(K key);

    /** Put an entry into this Map
     * @return the old value, or null if not found */
    V put(K key, V value);

    /** Remove entry with given key.
     * @return its value, or null if not found */
    V remove(K key);

    /** @return the size of this Map */
    int size();

    /** @return true iff this Map is empty */
    boolean isEmpty();

    /** Clear this Map */
    void clear();

    /** @return a key for the given value, or null if not found */
    K getKey(V value);
    /** @return a Set of all the keys in this Map. */
    Set<K> keySet();
    /** @return true iff the given object is a Map, and this Map is equal to the given object */
    boolean equals(Object obj);
}