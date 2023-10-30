package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct. 2019)
 */
public class HomeworkTestBTsizeNoRemove
{
    
    public static void main(String [] args )
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    if (kids.isEmpty ())
        System.out.println ("Not correct 1");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");
    kids = kids.add ("susie");

    if (kids.containsKey (new Integer(17)))
        System.err.println ("Not correct");
     if (!(kids.containsKey ("sue")))
        System.err.println ("Not correct");
     if (kids.containsKey ("jim"))
        System.err.println ("Not correct");
     if (!(kids.get (new String("susie")).equals ("susie")))
        System.err.println ("Not correct");
     if ((kids.get ("joseph") != null))
        System.err.println ("Not correct");
     if (kids.size() != 5)
        System.err.println ("Size not correct");
     System.out.println ("Testing completed");
      
    }
}
