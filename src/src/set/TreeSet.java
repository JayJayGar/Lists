package set;

import list.Iterator;
import tree.*;

public class TreeSet <E extends Comparable> implements Set<E>{
    BinaryTree<E> tree = new EmptyBinarySearchTree<E>();

    public boolean add(E value) {
        if(contains(value))
            return false;
        tree = tree.add(value);
        return true;
    }

    public boolean contains(Object obj) {
        return tree.containsKey(obj);
    }

    public boolean remove(Object obj) {
        if(!contains(obj))
            return false;
        tree = tree.remove(obj);
        return true;
    }

    public int size() {
        return tree.size();
    }

    public boolean isEmpty() {
        return tree.size() == 0;
    }

    public void clear() {
        tree = new EmptyBinarySearchTree<>();
    }

    public boolean equals(Object obj) {
        if(obj instanceof Set<?>){
            if(this.size()!= ((Set<?>) obj).size())
                return false;
            Iterator it = ((Set<E>) obj).iterator();
            while(it.hasNext()){
                if(!this.contains(it.next())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() {
        return tree.iterator();
    }


    public String toString(){
        return tree.toString();
    }


}