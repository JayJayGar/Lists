package list;

/**
 * A ListIterator for ArrayLists
 * @author JSG
 */
class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {
    // Implicit cursor is between positions
    // ndx and ndx+1
    boolean forward;

    //constructors
    ArrayListIterator(List<E> list) { super(list); }

    ArrayListIterator(List<E> list, int ndx) {
        // ndx is the starting position
        super(list);
        super.ndx = ndx-1;
    }

    public boolean hasPrevious() { return ndx >=0; }

    public E previous() {
        forward = false;
        ndx--;
        return list.get(ndx+1);
    }

//    public void remove() {
//        if (forward) {
//            list.remove(ndx);
//            ndx--;
//        } else {
//            list.remove(ndx);
//        }
//    }

    public void remove() {
        if (forward) { ndx--; }
        list.remove(ndx+1);
    }

    public E next() {
        forward = true;
        return super.next();
    }

    public void add(E value){
        if(!forward){
            list.add(list.size(),list.get(list.size()-1));
            for(int i =0;i<list.size();i++){
                list.set(list.size()-i,list.get(list.size()-i-1));
            }
            list.set(1,value);
        }

        if(forward){
            list.add(list.size(),value);
        }
    }

}
