package tree;

/** An EmptyBinarySearchTree has no value, nor children */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E> {
    public E getValue() {
        return null;
    }

    public E get(E value) {
        return null;
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public BinaryTree<E> remove(Object obj) {
        return this;
    }

    public BinaryTree<E> add(E value) {
        BinarySearchTree.added = true;
        return new BinarySearchTree(value);
    }

    public void setLeft(BinaryTree<E> left) {
        //Should not be called
    }
    public void setRight(BinaryTree<E> right) {
        //Should not be called
    }

    public int size() { return 0; }

    public boolean isEmpty() {
        return true;
    }

    public void setValue(E value) {
    }

    public BinaryTree<E> getLeft() {
        return null;
    }

    public BinaryTree<E> getRight() {
        return null;
    }
}
