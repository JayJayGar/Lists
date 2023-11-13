package queue;
import list.*;

/**
 * A QueueADT implemented with an ArrayList
 * @author JSG
 */
public class ArrayQueue<E> implements QueueADT<E> {
    List<E> list = new ArrayList<E>();
    int size = 0; //size of Q
    int front = 0, back = 0;

    /**public void add(E value) {
        if (list.size() != size) { // clobber
            list.set(back, value);
            if (back == list.size()-1) {
                back = 0;
            } else back++;
        }
    } */

    public void add(E value) {
        if (list.size() != size) { //clobber
            list.set(back, value);
            back = (back+1)%list.size();
        } else { //insertion
            list.add(back, value);
            front = (front+1)%list.size();
            back = (back+1)%list.size();
        } size++;
    }

    public E peek() {
        if (size == 0) { return null; }
        return list.get(front);
    }

    public E remove() {
        E result = list.get(front);
        front = (front+1)%list.size();
        size--;
        return result;
    }

    public boolean isEmpty(){ return size == 0; }

    public int size() { return size; }
}
