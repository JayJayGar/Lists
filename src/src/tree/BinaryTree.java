package tree;
import list.Iterator;

/** A binary tree has a value, and at most two children each of
 * which is a binary tree
 * @author JSG */
public interface BinaryTree<E> {
    /** @return the value of this binary tree, or null if it has no value */
    E getValue();

    /** Search the family of this binary tree for the given value
     * @return the value if found, or null if not found */
    E get(E value);

    /** @return true iff the family of this binary tree contains the given object */
    boolean containsKey(Object obj);

    /** Remove the given value from the family of this binary tree
     * @return the resulting binary tree */
    BinaryTree<E> remove(Object obj);

    /** Add the given value to the family of this Binary Tree */
    BinaryTree<E> add(E value);

    /** Change the left child of this binary tree */
    void setLeft(BinaryTree<E> left);

    /** Change the right child of this binary tree */
    void setRight(BinaryTree<E> right);

    /** @return the size of this BinaryTree's family */
    int size();

    /** @return true iff this BinaryTree is empty */
    boolean isEmpty();

    /** Set the value of this BinaryTree to the given value */
    void setValue(E value);

    /** @return the left child of this BinaryTree */
    BinaryTree<E> getLeft();

    /** @return the right child of this BinaryTree */
    BinaryTree<E> getRight();

    /** @return an Iterator for this Binary Tree */
    Iterator<E> iterator();

    /** @return this BinaryTree as a String, showing the values with an in-order traversal */
    String toString();
}
