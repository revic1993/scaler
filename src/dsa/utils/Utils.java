package dsa.utils;

import dsa.scaler.LinkedList.structs.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

   public static <T> void  print(ArrayList<ArrayList<T>> data){
       ArrayList<ArrayList<T>> clonedData = getTwoDimArrListCopy(data);
       for(ArrayList<T> datum : clonedData){
           System.out.println(" { ");
           System.out.println(datum);
           System.out.println(" } ");
       }
   }

    public static <T> void  printSingleArr(ArrayList<T> data){
       System.out.println(data);
    }

    public static <T> ArrayList<ArrayList<T>> getTwoDimArrListCopy(ArrayList<ArrayList<T>> original){
        ArrayList<ArrayList<T>> copy = new ArrayList<>();

        for (ArrayList<T> arr: original){
            copy.add(new ArrayList<>(arr));
        }

        return copy;
    }

    public static void printIntArr(int[] data){
        System.out.println(Arrays.toString(data));
    }

    public static void printIntArr(int[] data,String message){
       System.out.println(message +" "+Arrays.toString(data));
    }

    public static void printIntArr(int[][] data,String message){
       System.out.println(message);
       for(int[] datum : data){
        System.out.println(Arrays.toString(datum));
       }
    }

    public static void printLL(ListNode A){
       ListNode current = A;
       while(current != null){
           System.out.print(current.val+" => ");
           current = current.next;
       }
        System.out.println("null");
    }

}
