package tree;
import list.Iterator;
import queue.*;

/** An Iterator for Binary Trees
 * @author JSG */
class TreeIterator<E> implements Iterator<E> {
    BinaryTree<E> tree;
    QueueADT<E> q = new Queue<E>();

    E lastGotten; // last value attained by next()

    TreeIterator(BinaryTree<E> tree) {
        this.tree = tree;
        buildQ(tree);
    }

    private void buildQ(BinaryTree<E> tree) {
        //In Order Traversal
        if (tree.isEmpty()) return;
        buildQ(tree.getLeft());
        q.add(tree.getValue());
        buildQ(tree.getRight());
    }

    public boolean hasNext() { return !q.isEmpty(); }

    public E next() {
        lastGotten = q.remove();
        return lastGotten;
    }

    public void remove() {
        //remove lastGotten from the tree
        if (!tree.getValue().equals(lastGotten) ||
                tree.getLeft().isEmpty() == tree.getRight().isEmpty())
            tree = tree.remove(lastGotten);
        else {
            BinaryTree<E> child = tree.getLeft();
            if (child.isEmpty()) child = tree.getRight();
            tree.setValue(child.getValue());
            tree.setLeft(child.getLeft());
            tree.setRight(child.getRight());
        }
    }

    /** STUB: DONT USE */
    public boolean has2More() {
        return false;
    }
}
