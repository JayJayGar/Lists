package treeDriver;

import tree.*;
import list.*;
import java.util.Random;

/**
 * Test the binary search tree iterator and toString.
 * 
 * @author (sdb) 
 * @version (Mar 2022)
 */
public class DriverIteratorToString 
{
    static BinaryTree <String> kids;
    public static void main(String [] args )
    {
        BinaryTree<Integer> numbers = new EmptyBinarySearchTree<Integer> ();
        System.out.println ("Empty tree: " + numbers);
        
        
        Random rand = new Random(1);
        
        for (int i=0; i<20; i++)
               numbers = numbers.add(rand.nextInt(100)-30);
        
        System.out.println ("The numbers in the tree are " + numbers);
     
        removeNegs(numbers);
        System.out.println ("Negative numbers have been removed: " + numbers);
        
    }
    
    /** Remove all negative numbers from the given BinaryTree
     * @author JSG
     */
    private static void removeNegs(BinaryTree<Integer> nums)
    {  
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) it.remove();
        }

        
    }
}
