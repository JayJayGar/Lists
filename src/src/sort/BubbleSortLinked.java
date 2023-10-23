package sort;
import list.*;

/** Sort a LinkedList with BubbleSort in time O(n^2) */
public class BubbleSortLinked<E extends Comparable> implements Sorter{
    List<E> list; //Should be a LinkedList


    public void sort(List list) {
        this.list = list;
        E left,right;
        ListIterator<E> lit;
        for(int i=0;i<list.size()-1;i++) {
            lit = list.listIterator();
            right = lit.next();
            boolean completed = true;
            for(int j=0;j<list.size()-i-1;j++) {
                left = right;
                right = lit.next();
                if(left.compareTo(right)>0) {
                    completed = false;
                    lit.remove();
                    lit.previous();
                    lit.add(right);
                    right = lit.next();
                }
            }
            if (completed) { break; }
        }
    }
}
