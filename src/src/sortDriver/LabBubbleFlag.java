package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the BubbleSort algorithm.
 * 
 * @author (sdb)  
 * @version (2020)
 */
public class LabBubbleFlag
{
    static List <Integer> grades;
    static Sorter <Integer> sorter = new BubbleSortLinked <Integer> ();
    
    
    public static void main (String [] args)
    {
     testSort(12);               //  Sort a short list
     testSort(10000000);           //  Sort a longer list
     System.out.println ("\nTesting complete, using a LinkedList");
     
    }
    
    /** @return true if the list is sorted */
    private static boolean check()
    {   if (grades.size() < 2)
            return true;
        Iterator<Integer> it = grades.iterator();
        int left, right;
        right = it.next();
        while (it.hasNext())
            {   left = right;
                right = it.next();
                if (left > right)
                    return false;   // Not sorted correctly
            }
        return true;
    }
        
    // Test the BubbleSort with a list of the given size
    private static void testSort (int size)
    {   init(size);
     System.out.println ("\nTest Bubble Sort: size is " + size);
     sorter = new BubbleSortLinked <Integer>  ( ); 
     init(size);
     showList();
     sorter.sort(grades);
     showList();
     if (! check())           // Check the result
           System.err.println ("List was not sorted correctly");
    
    }
    
    // Display the list if it's size is less than 20
    private static void showList()
    {   if (grades.size() < 20)
            System.out.println (grades);
        }
        
   // Initialize the list of grades using the given size.
   // Pre: size is at least 10
    private static void init(int size)
    { grades = new LinkedList<Integer> ();
      for (int i=0; i<size; i++)
          grades.add (i);
      // change a few values
      grades.set(size-5,size-2);
      grades.set(size-7,size-3);
      grades.set(size-8,size-4);
    }
}