package map;

import hash.*;
import list.Iterator;
import set.HashSet;
import set.Set;
import set.TreeSet;

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
            return key + " = " + value;
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

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public void clear() {

    }

    public K getKey(V value) {

        return this.getKey(value);
    }

    public Set<K> keySet()
    {
        Set<K> keySet = new HashSet<>();
        Iterator<Entry<K,V>> it = table.iterator();
        while (it.hasNext()){
            keySet.add(it.next().key);
        }

        return keySet;
    }

    public String toString(){
        String result = "";
        Iterator<Entry<K,V>> it = table.iterator();
        while(it.hasNext()){
            Entry<K,V> ent = it.next();
            result += ent.toString();
            if(it.hasNext())
                result +=", ";
        }
        return "["+result+"]";
    }
    /** @return true iff the given object is a Map, and this Map is equal to the given object */
    public boolean equals(Object obj)
    {
        if(obj instanceof Map<?,?>) {
            K key;
            Set<K> keySet = keySet();
            Set<K> objKeySet = ((Map<K, V>) obj).keySet();
            if(objKeySet.equals(keySet)){
                Iterator<K> it = keySet.iterator();
                while (it.hasNext()) {
                    key = it.next();
                    if(!this.get(key).equals(((Map<K, V>) obj).get(key))){
                        return false;
                    }
                }
                return true;
            }return false;//if keysets are not equal
        }
        return false;//if not instance of map
    }
}