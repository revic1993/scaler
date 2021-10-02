package dsa.scaler.arrays;

/*
*   Print a Pattern According to The Given Value of A. Example: For A = 3 pattern looks like:
    1
  2 1
3 2 1
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PatternPrintingReverse {
    public static void main(String args[]){
        System.out.println(solve(4));
    }

    public static ArrayList<ArrayList<Integer>> solve(int A){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(A);
        ArrayList<Integer> row = new ArrayList<>(Arrays.asList(new Integer[A]));
        Collections.fill(row,0);
        row.set(A-1,1);
        matrix.add(0,row);
        for(int i=A-2,j=1;i>=0;i--,j++){
            ArrayList<Integer> nextRow = (ArrayList<Integer>) matrix.get(j-1).clone();
            nextRow.set(i,nextRow.get(i+1)+1);
            matrix.add(nextRow);
        }
        return matrix;
    }
}
