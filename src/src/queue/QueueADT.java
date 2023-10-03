package queue;

/**
 * A FIFO List
 * @author JSG
 */
public interface QueueADT<E> {
    /** Add the given value at the back of this QueueADT */
    void add(E value);

    /** @return the value at the front of this QueueADT,
     * or null if this QueueADT is empty*/
    E peek();

    /** Remove the value at front of this QueueADT
     * @return the value removed
     * Pre: This QueueADT is not empty */
    E remove();
}
