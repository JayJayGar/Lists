package list;

/** An Iterator for ArrayList
 * @author JSG */
class ArrayIterator<E> implements Iterator<E> {
    int ndx; //position of last value returned by next()
    List<E> list;

    ArrayIterator(List<E> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return ndx<list.size()-1;
    }

    public E next() {
        ndx++;
        return list.get(ndx);
    }

    public void remove() {
        list.remove(ndx);
        ndx--;
    }
}


