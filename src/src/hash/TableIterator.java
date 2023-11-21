package hash;
import list.*;

/** An Iterator for HashTables
 * @author JSG */
public class TableIterator<K> implements Iterator<K> {
    HashTable<K> table;
    int ndx = 0; // pos of the current LinkedList
    Iterator<K> it; // for a LinkedList
    TableIterator(HashTable<K> table) {
        this.table = table;
        setIt(0);
    }

    /** Set the Iteratoe it, to the LinkedList at
     * given position in the ArrayList */
    private void setIt(int ndx) {
        List<K> list = table.lists.get(ndx);
        it = list.iterator();
    }

    public boolean hasNext() {
        if (it.hasNext()) return true;
        return nextList()<0;
    }

    /** Return pos of next non-Empty LL or -1 if not found. */
    private int nextList() {
        for (int i=ndx+1; i<table.lists.size(); i++) {
            List<K> list = table.lists.get(i);
            if (!list.isEmpty()) return i;
        } return -1;
    }

    public K next() {
        if (!it.hasNext()) {
            ndx = nextList();
            setIt(ndx);
        } return it.next();
    }

    public void remove() {
        it.remove();
        table.size--;
    }
}
