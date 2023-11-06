package tree;
import list.*;

/** A BinaryTree in which value is smaller than all vales in the right
 * child's fammily, larger than all the values in the left child's family.
 * Both Children are empty or BinarySearchTrees
 * @author JSG */
public class BinarySearchTree <E extends Comparable> implements BinaryTree<E> {
    E value;
    BinaryTree<E> left = new EmptyBinarySearchTree<>();
    BinaryTree<E> right = new EmptyBinarySearchTree<>();
    int size = 1; //size of family of this BinarySearchTree
    public static boolean added, removed;

    public BinarySearchTree(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public E get(E value) {
        int cmp = this.value.compareTo(value);
        if (cmp == 0) return this.value;
        if (cmp < 0) return right.get(value);
        return left.get(value);
    }

    public boolean containsKey(Object obj) {
        try {
            E key = (E)obj;
            int cmp = this.value.compareTo(key);
            if (cmp == 0) return true;
            if (cmp < 0) return right.containsKey(key);
            return left.containsKey(key);
        } catch (ClassCastException cce) { return false; }
    }

    public BinaryTree<E> remove(Object obj) {
        removed = false;
        try {
            E key = (E)obj;
            return removeHelper(key);
        } catch (ClassCastException cce) { return this; }
    }

    private BinaryTree<E> removeHelper(E key) {
        int cmp = value.compareTo(key);
        if (cmp ==0 ) { //found
            removed = true;
            List<BinaryTree<E>> kids = children();
            //Empty
            if(kids.isEmpty()) return new EmptyBinarySearchTree<>();
            //Child
            if(kids.size()==1) return kids.get(0);
            //2 children
            E successor = getSuccessor();
            removeHelper(successor);
            value = successor;
            return this;
        }
        if (cmp < 0) right = right.remove(key);
        if (cmp > 0) left = left.remove(key);
        if (removed) size--;
        return this;
    }

    private List<BinaryTree<E>> children() {
        List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
        if (!left.isEmpty()) result.add(left);
        if (!right.isEmpty()) result.add(right);
        return result;
    }

    private E getSuccessor() {
        BinaryTree<E> result = right;
        while (!result.getLeft().isEmpty()) { result = result.getLeft(); }
        return result.getValue();
    }

    public BinaryTree<E> add(E value) {
        added = false;
        return addHelper(value);
    }

    private BinaryTree<E> addHelper(E value) {
        int cmp = this.value.compareTo(value);
        if (cmp > 0 ) left = left.add(value);
        if (cmp < 0 ) right = right.add(value);
        if (added) size++;
        return this;
    }

    public void setLeft(BinaryTree<E> left) {
        left = this.left;
        size = left.size() + right.size() + 1;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
        size = left.size() + right.size() + 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public Iterator<E> iterator() { return new TreeIterator<E>(this); }


}
