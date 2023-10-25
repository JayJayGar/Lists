package sort;
import list.*;

/** Search a sorted ArrayList for a given target.
 * @author JSG */
public class BinarySearch <E extends Comparable> {
    List<E> list; //should be a sorted ArrayList
    E target;

    public BinarySearch(List<E> list) { this.list = list; }

    /** @return postition of some occurerence of target in list,
     * or -1 if not found */
    public int search(E target) {
        this.target = target;
        return binSrch(0,list.size()-1);
    }

    private int binSrch(int start, int end) {
        if (start > end) return -1; //not found
        int mid = (start+end)/2;
        int cmp = target.compareTo(list.get(mid));
        if (cmp==0) return mid;
        if (cmp<0) return binSrch(start,mid-1);
        return binSrch(mid+1,end);
    }
}
