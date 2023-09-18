package list;

/**
 * A Node has a value and refs to 2 Nodes
 * @author JSG
 * @param <E>
 */
public class Node <E> {
    E value;
    Node <E> next, prev;
    Node(E v, Node<E> n, Node<E> p) {
        value = v;
        next = n;
        prev = p;
    }

}
