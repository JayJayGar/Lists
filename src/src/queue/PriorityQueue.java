package queue;
import list.*;

/**
 * Write a description of class PriorityQueue here.
 *
 * @author (sdb & JSG)
 * @version (12/5/2023)
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E>
{
    List<E> heap = new ArrayList<E>();

    public E peek()
    {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    public void add(E value)
    {
        int added = heap.size();
        int parent = (added - 1) / 2;

        heap.add(value);
        while (added > 0 && greater(added, parent))
        {
            swap(added, parent);
            added = parent;
            parent = (added - 1) / 2;

        }
    }

    private void swap(int x, int y)
    {
        E temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    private boolean greater(int x, int y)
    {
        return heap.get(x).compareTo(heap.get(y)) > 0;
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    public E remove()
    {
        E result = heap.get(0);
        int last = heap.size() - 1;
        int avail = 0;
        int bc = biggerChild(avail);

        while ((2 * avail + 1) < last && greater(bc, last))
        {
            heap.set(avail, heap.get(bc));
            avail = bc;
            bc = biggerChild(avail);
        }
        heap.set(avail, heap.get(last));
        heap.remove(last);
        return result;
    }

    private int biggerChild(int root)
    {
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (right >= heap.size())
            return left;
        if (greater(left, right))
            return left;
        return right;
    }

    public void clear()
    {
        heap.clear();
    }

    public int size()
    {
        return heap.size();
    }

    public String toString()
    {
        return heap.toString();
    }
}