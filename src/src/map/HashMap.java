package map;

import hash.*;

/** A Map implemented with a HashTable
 * @author JSG */
public class HashMap<K, V> implements Map<K, V> {
    // inner class
    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "[" + key + "," + value + "]";
        }

        public boolean equals(Object obj) {
            Entry<K, V> other = (Entry<K, V>) obj;
            return key.equals(other.key);
        }

        public int hashCode() {
            return key.hashCode();
        }
    } //end inner class

    HashTable<Entry<K, V>> table = new HashTable<Entry<K, V>>();

    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        return table.containsKey(entry);
    }

    public V get(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = table.get(entry);
        if (entry == null) return null;
        return entry.value;
    }

    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        Entry<K, V> oldEntry = table.get(newEntry);
        if (oldEntry != null) {
            V oldValue = oldEntry.value;
            oldEntry.value = value;
            return oldValue;
        }
        table.put(newEntry);
        return null;
    }

    public V remove(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = table.get(entry);
        if (entry == null) return null;
        table.remove(entry);
        return entry.value;
    }
}
