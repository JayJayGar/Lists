package queue;

import list.*;

/**
 * A QueueADT implemented with a LinkedList
 * @author JSG
 */
public class Queue<E> implements QueueADT<E> {
    List<E> list = new LinkedList<E>();
    //pos 0 is the front of the queue
    public void add(E value) {
        list.add(value);
    }

    public E peek() {
        if (list.isEmpty()) {
            return null;
        } return list.get(0);
    }

    public E remove() {
        return list.remove(0);
    }


}
