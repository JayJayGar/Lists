package sort;
import list.*;

/** Heap Sort algorithm List should be an ArrayList
 * @author JSG */
public class HeapSort <E extends Comparable> implements Sorter<E> {
    List<E> list;
    public void sort(List<E> list) {
        this.list=list;
        heapify(0);
        int last = list.size()-1;
        while(last>0) {
            swap(0,last);
            last--;
            percDown(0,last);
        }
    }

    public void heapify(int root) {
        if (root>list.size()-1) return;
        heapify(2*root+1);
        heapify(2*root+2);
        percDown(root,list.size()-1);
    }

    private void percDown(int root, int max) {
        int bc = biggerChild(root, max); //bc is pos of root's bigger child
        while (greater(bc,root) && 2*root+1 <= max){
            swap(root,bc);
            root = bc;
            bc = biggerChild(root, max);
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
