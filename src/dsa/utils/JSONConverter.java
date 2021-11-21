package dsa.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JSONConverter {

   public static void print(ArrayList<ArrayList<Integer>> data){
       ArrayList<ArrayList<Integer>> clonedData = getTwoDimArrListCopy(data);
       for(ArrayList<Integer> datum : clonedData){
           System.out.println(" { ");
           System.out.println(datum);
           System.out.println(" } ");
       }
   }

    public static ArrayList<ArrayList<Integer>> getTwoDimArrListCopy(ArrayList<ArrayList<Integer>> original){
        ArrayList<ArrayList<Integer>> copy = new ArrayList<>();

        for (ArrayList<Integer> arr: original){
            copy.add(new ArrayList<Integer>(arr));
        }

        return copy;
    }

}
