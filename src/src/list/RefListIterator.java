package list;

/**
 * A ListIterator for LinkedLists
 * @author JSG
 */
class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>{
    //super.cursor is a ref to Node containing the last value obtained
    //by next() or previous()
    private boolean forward = true;

    RefListIterator(LinkedList<E> list) {
        super(list);
    }

    /** Pre: 0<=start<=size */
    RefListIterator(LinkedList<E> list, int start) {
        super(list);
        for (int i=0; i<start; i++) {
            cursor=cursor.next;
        }
    }

    public boolean hasNext() {
        if (list.isEmpty()) { return false; } //!forward, removed only value
        if (forward) {
            return cursor.next != list.tail;
        } return true;
    }

    public E next() {
        if (forward) {
            cursor = cursor.next;
        }
        forward = true;
        return cursor.value;
    }

    public boolean hasPrevious() {
        if (!forward) {
            return cursor.prev!=list.head;
        }
        //initial call to hasPrevious()
        return cursor!=list.head;
    }

    public E previous() {
        if (!forward) {
            cursor=cursor.prev;
        }
        forward = false;
        return cursor.value;
    }


    public void remove() {
        super.remove();
        if (forward) {
            cursor = cursor.prev;
        } cursor = cursor.next;
    }

}
