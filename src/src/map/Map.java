package map;

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
}
