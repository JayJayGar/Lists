package sort;
import list.*;

/** Heap Sort algorithm List should be an ArrayList
 * @author JSG */
public class HeapSort <E extends Comparable> implements Sorter<E> {
    List<E> list;
    public void sort(List<E> list) {
        this.list=list;
        heapify(0); //O(n*log(n))
        int last = list.size()-1;
        while(last>0) {
            swap(0,last); //n times
            last--;
            percDown(0,last);
        }
    }

    public void heapify(int root) { // O(n * log(n))
        int max = list.size()-1;
        if (root>=max) return;
        heapify(2*root+1); //left
        heapify(2*root+2); //right
        percDown(root,max); // O(log(n))
    } // n calls to heapify

    private void percDown(int root, int max) { // O(log(n))
        int bc = biggerChild(root, max); //bc is pos of root's bigger child
        while (2*root+1 <= max && greater(bc,root)){
            swap(root,bc); //O(1)
            root = bc;
            bc = biggerChild(root, max); //O(1)
        }
    }

    private int biggerChild(int root, int max) {
        int left = 2*root+1, right = 2*root+2;
        if (right > max) return left;
        if (greater(left,right)) return left;
        return right;
    }

    private boolean greater(int x, int y) {
        return list.get(x).compareTo(list.get(y)) > 0;
    }

    private void swap(int x, int y) {
        E temp = list.get(x);
        list.set(x,list.get(y)); //Clobbery
        list.set(y,temp);
    }
}
