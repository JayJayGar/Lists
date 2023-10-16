package sort;
import list.*;

/** A sorting algorithm
 * @author JSG
 */
public interface Sorter <E extends Comparable>{
    /** Arrange the values of the given list in increasing (or decreasing) order */
    void sort(List<E> list);
}
