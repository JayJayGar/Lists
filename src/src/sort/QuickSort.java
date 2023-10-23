package sort;
import list.*;

/** QuickSort Algorithm to sort an ArrayList ascending.
 * @author JSG */
public class QuickSort <E extends Comparable> implements Sorter<E>{
    List<E> list;

    public void sort(List<E> list) {
        this.list=list;
        qSort(0,list.size()-1);
    }

    private void qSort(int start, int end) {
        if (end-start<1) return;
        int p = partition(start, end);
        qSort(start, p-1); //left half
        qSort(p+1, end); //right half
    }

    /** Post: All values to the left of pivot are smaller than the Pivot
     * All values to the right of the Pivot are greater than or equal to Pivot
     * @return position of pivot */
    private int partition(int start, int end) {
        int p = start; //p Pivot position
        E pivot = list.get(p);
        for (int i=start+1; i<=end; i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                list.set(p, list.get(i));
                p++;
                list.set(i, list.get(p));
            }
        } list.set(p,pivot);
        return p;
    }
}
