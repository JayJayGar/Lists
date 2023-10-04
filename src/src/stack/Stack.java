package stack;
import list.*;

/**
 * A StackADT implemented with a List
 * @author JSG
 */
public class Stack<E> implements StackADT<E> {
    List<E> list = new LinkedList<E>();
    //position 0 in the list is bottom of the stack
    public E push(E value) {
        list.add(value);
        return value;
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public boolean isEmpty() { return list.size() == 0; }

}
