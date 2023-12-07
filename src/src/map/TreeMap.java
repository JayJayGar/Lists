package map;
import tree.*;
import list.Iterator;
import set.*;
/**
 * Write a description of class TreeMap here.
 *
 * @author (sdb & JSG)
 * @version (a version number or a date)
 */
public class TreeMap<K extends Comparable, V> implements Map<K, V>
{   //inner class
    class Entry<K extends Comparable, V> implements Comparable<Entry<K, V>>
    {
        K key;
        V value;
        Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Entry<K, V> other)
        {
            return this.key.compareTo(other.key);
        }

        public String toString()
        {
            return key.toString() + " = " + value.toString();
        }

    } //end of inner class

    BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree<Entry<K, V>>();

    public boolean containsKey(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        return tree.containsKey(entry);
    }

    public V get(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);
        if (entry == null)
            return null;
        return entry.value;
    }

    public V put(K key, V value)
    {
        Entry<K, V> newEntry = new Entry<K, V>(key, value),
                oldEntry = tree.get(newEntry);
        if (oldEntry == null)
        {
            tree = tree.add(newEntry);
            return null;
        }
        oldEntry.value = value;
        V oldValue = oldEntry.value;
        return oldValue;
    }

    public V remove(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);
        if (entry == null)
            return null;
        tree = tree.remove(entry);
        return entry.value;
    }

    public int size()
    {
        return tree.size();
    }

    public boolean isEmpty()
    {
        return tree.isEmpty();
    }

    public void clear()
    {
        tree = new EmptyBinarySearchTree<Entry<K, V>>();
    }

    public K getKey(V value)
    {
        Entry<K, V> entry = new Entry<K, V>(null, value);
        entry = tree.get(entry);
        if (entry == null)
            return null;
        return entry.key;
    }

    public Set<K> keySet()
    {
        Set<K> keySet = new TreeSet<K>();
        Iterator<Entry<K, V>> it = tree.iterator();
        while (it.hasNext()){
            keySet.add(it.next().key);
        }

        return keySet;
    }


    public String toString(){
        String result = "";
        Iterator<Entry<K,V>> it = tree.iterator();
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
