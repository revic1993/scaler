package dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Print a Pattern According to The Given Value of A.
 *
 * Example: For A = 3 pattern looks like:
 *
 * 1 0 0
 *
 * 1 2 0
 *
 * 1 2 3
 */

public class PatternPrinting {

    public static void main(String args[]){
        System.out.println(solve(4));
    }

    public static ArrayList<ArrayList<Integer>> solve(int A){
        HashMap<String,String> map;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(A);
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(new Integer[A]));
        Collections.fill(row,0);
        row.set(0,1);
        matrix.add(0,row);
        for(int i=1;i<A;i++){
            ArrayList<Integer> nextRow = (ArrayList<Integer>) matrix.get(i-1).clone();
            nextRow.set(i,nextRow.get(i-1)+1);
            matrix.add(i,nextRow);
        }
        return matrix;
    }
    /*
    * 1. Keep map of frequencies
    * 2. Iterate over map keys and add elements to result array whose frequency > 1
    * 3. Return the result array
    * TC : O(n)
    * SC: O(n)
    * */

}
