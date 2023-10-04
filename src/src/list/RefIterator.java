package list;

/**
 * An Iterator for ArrayLists
 * @author JSG
 */
class RefIterator<E> implements Iterator<E>{
    LinkedList<E> list;
    Node<E> cursor; //Node storing last obtained by next()

    RefIterator(LinkedList<E> list) {
        this.list = list;
        cursor = list.head;
    }

    public boolean hasNext() {
        return cursor.next != list.tail;
    }
    public E next() {
        cursor = cursor.next;
        return cursor.value;
    }

    public void remove() {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }

    public void add(E value){
        Node<E> temp = new Node(value,cursor.next,cursor.prev);
        cursor.next.prev = temp;
        cursor.next = temp;
        list.size++;
    }


}
