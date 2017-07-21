package mr.analytics;
import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
class PrintnonRepeating
{
    void printRepeating(int arr[]) 
    {
//        int count[] = new int[size];
//        int i;
        Set<Integer> set = new HashSet<Integer>();
        System.out.println("Repeated elements are : ");
        for (int val:arr) 
        {
         if(set.add(val)== false){	 
          set.remove(val); 
         }
         else{
        	 set.add(val);
         }
        }   
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(" Iterating over HashSet in Java current object: " + itr.next().intValue());
        }
    }
        public static void main(String[] args)
        {
            PrintnonRepeating repeat = new PrintnonRepeating();
            int arr[] = {4, 2, 4, 5, 2, 3, 1};
//            int arr_size = arr.length;
            repeat.printRepeating(arr);
        }
    }
    
 
    