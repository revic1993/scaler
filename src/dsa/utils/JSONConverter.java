package dsa.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JSONConverter {

   public static <T> void  print(ArrayList<ArrayList<T>> data){
       ArrayList<ArrayList<T>> clonedData = getTwoDimArrListCopy(data);
       for(ArrayList<T> datum : clonedData){
           System.out.println(" { ");
           System.out.println(datum);
           System.out.println(" } ");
       }
   }

    public static <T> ArrayList<ArrayList<T>> getTwoDimArrListCopy(ArrayList<ArrayList<T>> original){
        ArrayList<ArrayList<T>> copy = new ArrayList<>();

        for (ArrayList<T> arr: original){
            copy.add(new ArrayList<>(arr));
        }

        return copy;
    }

}
