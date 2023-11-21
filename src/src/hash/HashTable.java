package hash;
import list.*;

/** A HashTable provides quick access to keys.
 * Client should implement a hashCode() which returns an int
 * If key1 equals key2, then hashCode must return the same int.
 * If not equal, the table is efficient if hashCode() returns different ints.
 * @author JSG */
public class HashTable <K> {
    List<List<K>> lists;
    int size=0; //Number of Keys
    public HashTable(int cap) { //cap is size of the ArrayList
        lists = new ArrayList<List<K>>(cap);
        for (int i=0; i<cap; i++) {
            lists.add(new LinkedList<K>());
        }
    }

    public HashTable() { this(10); }

    /**@return true iff the given obj is a key in this HashTable */
    public boolean containsKey(Object obj) {
        List<K> list = getList(obj);
        return list.contains(obj);
    }

    private List<K> getList(Object obj) { //O(1)
        int code = obj.hashCode();
        code = Math.abs(code);
        code = code % lists.size();
        return lists.get(code);
    }

    /** Add the given key to this HashTable */
    public void put(K key) {
        List<K> list = getList(key);
        list.add(key);
        size++;
    }

    /** @return a key from the HashTable which equals the given key,
     * or null if not found */
    public K get(K key) {
        List<K> list = getList(key);
        K tableKey;
        Iterator<K> it = list.iterator();
        while (it.hasNext()) {
            tableKey = it.next();
            if (key.equals(tableKey)) return tableKey;
        } return null; //not found
    }

    /** Remove the given object from this HashTable
     * @return true iff it was removed */
    public boolean remove(Object obj) {
        List<K> list = getList(obj);
        boolean result = list.remove(obj);
        if (result) size--;
        return result;
    }

    /** @return the size of this HashTable */
    public int size() { return size; }

    /** @return true iff this HashTable is empty */
    public boolean isEmpty() { return size == 0; }

    /** Clear this HashTable */
    public void clear() {
        lists = new ArrayList<List<K>>(size);
        for (int i=0; i<size; i++) {
            lists.add(new LinkedList<K>());
        }
    }

    public Iterator<K> iterator() { return new TableIterator<K>(this); }
}
