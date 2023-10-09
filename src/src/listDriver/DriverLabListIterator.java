package listDriver;

import list.*;
//import java.util.*;
  
/**
 * Test Iterators and ListIterators.
 * 
 * @author (sdb) 
 * @version (Sep 2020) 
 */
public class DriverLabListIterator
{
    public static void main(String [] args)
    {   
    List <String> names;
    System.out.println ("\n\nTesting Iterators for ArrayLists");
    testIterators (new ArrayList<String>());
    System.out.println ("Testing Iterators for LinkedLists");
    testIterators (new LinkedList<String>());
    System.out.println();
    

     System.out.println ("Testing ListIterators for ArrayLists");
     testListIterators (new ArrayList<String> ());
    System.out.println ("\nTesting ListIterators for LinkedLists");
    testListIterators (new LinkedList<String> ());

    System.out.println ("Testing complete");
}

    private static void testIterators (List <String> names)
    {   names.add ("jim");
        names.add ("mary");
        names.add ("joe");
        names.add ("sue");
        Iterator <String> itty = names.iterator();
        while (itty.hasNext())
            if (itty.next().length() > 3)
                itty.remove();
        System.out.println (names);     // should be [jim, joe, sue]
    }
    
   private static void testListIterators (List<String> names)
   {
       
   names.add ("james");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");    System.out.println (names);
    ListIterator <String> itty = names.listIterator();
   System.out.println ("Test the add method:");       
    System.out.print(itty.next()+ " ");      
    System.out.print(itty.next() + " ");     
    itty.add ("harry");
    System.out.println (itty.next());       // james mary joe
    System.out.println (names);             // [james, mary, harry, joe, sue]
    System.out.print(itty.next() + " ");     
    itty.add ("bill");
    System.out.print (itty.previous() + " ");    
    itty.add ("james");
    System.out.println (itty.next());       // sue bill bill
    System.out.println (names);             // [james, mary, harry, joe, sue, james, bill]
    if (names.size() != 7)
        System.err.println ("Error in ListIterator"); 
    itty = names.listIterator(names.size());    // start at tail
    System.out.println("Names in reverse order: ");
    while (itty.hasPrevious())
        System.out.print(itty.previous()+" ");  // bill james sue joe harry mary james
    System.out.println();
    
        
}

    }   