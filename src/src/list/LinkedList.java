package list;

/**
 * A List implementation using references
 * @author JSG
 */
public class LinkedList<E> implements List<E> {
    int size = 0;
    Node<E> head = new Node<E>(null,null,null);
    Node<E> tail = new Node<E>(null,null,head);
    private Node<E> ref;

    public LinkedList(){
        head.next = tail;
    }

    public E get(int ndx) {
        setRef(ndx); //ref refers to Node at given ndx
        return ref.value;
    }

    //set ref to given ndx
    private void setRef(int ndx){
        ref = head.next;
        for(int i=0; i<ndx; i++) {
            ref = ref.next;
        }
    }

    public E set(int ndx, E value) {
        setRef(ndx);
        E result = ref.value;
        ref.value = value;
        return result;
    }

    public void add(E value) {
        Node<E> temp = new Node<E>(value,tail,tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    public void add(int ndx, E value) {
        setRef(ndx);
        Node<E> temp = new Node<E>(value,ref,ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    public E remove(int ndx) {
        setRef(ndx);
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;
        size--;
        return ref.value;
    }
    public int indexOf(Object obj){
        for(int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        for(int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    /** Stub : UNDER CONSTRUCTION */
    public Iterator<E> iterator() {
        return null;
    }
}
