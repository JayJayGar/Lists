package list;

/** A List implementation using an array
 * @author JSG
 */
public class ArrayList <E> implements List<E> {
    int size = 0;
    E[] values;
    //Constructors
    public ArrayList(int cap) {
        values = (E[]) new Object [cap];
    }

    public ArrayList() {
        this(10);
    }

    public E get(int ndx) {
        return values[ndx];
    }

    public E set(int ndx, E value) {
        E result = values[ndx];
        values[ndx] = value;
        return result;
    }

    public void add(int ndx, E value) {
        if(size == values.length){
            alloc(); //no room
        }
        for (int i=size; i>ndx; i--) {
            values[i] = values[i-1];
        }
        values[ndx] = value;
        size++;
    }
    private void alloc(){
        E[] temp = (E[]) new Object[values.length*2];
        for(int i =0; i<size;i++){
            temp[i] = values[i];
        }
        values = temp;
    }

    public void add(E value){
        add(size,value);
    }
    public E remove(int ndx) {
        E result = values[ndx];
        for (int i = ndx; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return result;
    }

    public boolean remove(Object obj) {
        for (int i=0; i < size-1; i++) {
            if (get(i).equals(obj)) return true;
        } return false;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        for(int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String temp = "[";
        for (int i = 0; i < size; i++) {
            temp += get(i).toString();
            if(i!=(size-1)) {
                temp+=",";
            }
        }
        temp += "]";
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addAll(List<E> other) {
        for(int i=0;i<other.size(); i++) {
            add(other.get(i));
        }
    }

    public int size() {
        return size;
    }

    public void clear() { values = (E[]) new Object [10]; size = 0;}

    public Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }

    public ListIterator<E> listIterator() { return new ArrayListIterator<E>(this); }

    public ListIterator<E> listIterator(int ndx) {
        return new ArrayListIterator<E>(this,ndx);
    }
}
