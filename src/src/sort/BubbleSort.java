package sort;
import list.*;

/** BubbleSort algorithm
 * @author JSG */
public class BubbleSort<E extends Comparable> implements Sorter<E>{
    List<E> list; //Should be ArrayList
    public void sort(List<E> list) { //O(n^2)
        this.list = list;
        for (int i=0; i<list.size()-1; i++) {
            for (int j=0; j<list.size()-i-1;j++) {
                if (list.get(j).compareTo(list.get(j+1))>0) {
                    swap(j,j+1);
                }
            }
        }
    }

    private void swap(int x, int y) {
        E temp = list.get(x);
        list.set(x,list.get(y)); //Clobbery
        list.set(y,temp);
    }
}
