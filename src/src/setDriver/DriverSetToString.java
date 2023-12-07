package setDriver;
import set.*;
import list.*;


/**
 * Test the toString method for Sets.
 * 
 * @author (sdb) 
 * @version (Mar 2016)
 */
public class DriverSetToString
{
    public static void main(String [] args)
    {   Set <Integer> values;
        values = new HashSet <Integer> ();
        System.out.println ("Testing HashSet");
        testSet(values);
        values = new TreeSet <Integer> ();
         System.out.println ("\nTesting TreeSet");
         testSet(values);
         System.out.println ("Testing complete");
    }
    
    private static void testSet(Set<Integer> values)
    {
        if (!values.isEmpty())
            System.err.println  ("Error in isEmpty ");
            
        values.add (3);
        values.add (5);
        values.add (3);
        
        // No news is good news
        
        if (values.size() != 2)
            System.err.println  ("Error in size ");
         if (values.isEmpty())
            System.err.println  ("Error in isEmpty ");
            
        for (int j=0; j<5; j++)
             values.add (j * 10);
         
        if (values.contains (15))
            System.err.println ("Error in contains ");
        if (!values.contains (20))
            System.err.println ("Error in contains ");  
            
        
        if (values.remove (2))
            System.err.println ("Error in remove ");  
        if (!values.remove (0))
            System.err.println ("Error in remove ");  
        if (values.size() != 6)
            System.err.println  ("Error in size or remove ");
        
        System.out.println ("The Set is: " + values);
        Iterator<Integer> itty = values.iterator();
        while (itty.hasNext())
            if (itty.next() % 2 == 1)
                itty.remove();              // remove odd numbers
           
        System.out.println ("After removing odd values, set is " + values);
        System.out.println ("size is " + values.size());
        if (values.size() != 4)
            System.err.println  ("Error in size or iterator ");
        
        values.clear();
        if (!values.isEmpty())
            System.err.println  ("Error in clear or isEmpty ");
            
        System.out.println("The Set is empty: " + values);
        
        values.add (17);
        System.out.println ("Set is " + values);
    }
        
        
        
}
