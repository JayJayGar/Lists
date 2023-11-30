package set;
import list.Iterator;
import hash.HashTable;

public class HashSet <E> implements Set<E>{
    HashTable<E> table = new HashTable<E>();

    public boolean add(E value){
        if(table.containsKey(value))
            return false;
        table.put(value);
        return true;
    }
    public boolean contains(Object obj){
        return table.containsKey(obj);
    }
    public boolean remove(Object obj){
        return table.remove(obj);
    }

    public int size() {
        return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public void clear() {
        table = new HashTable<E>();
    }

    public boolean equals(Object obj) {
        if(obj instanceof Set<?>) {
            if(this.size()!= ((Set<?>) obj).size())
                return false;
            Iterator it = ((Set<?>) obj).iterator();
            while (it.hasNext()) {
                if (!this.contains(it.next())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterator<E> iterator(){
        return table.iterator();

    }

    public String toString(){
        return table.toString();
    }

}