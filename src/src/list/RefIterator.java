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
        return cursor != list.tail;
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


}
