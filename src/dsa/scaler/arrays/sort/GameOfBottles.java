package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfBottles {
    public static void main(String[] args) {
        GameOfBottles gob = new GameOfBottles();
        Integer[][] testSet = {{1,2,3},{3,3,2,1,3,1,1,2},{1,1,2,2,3,3},{1,2,2,3,3,3},{1,1,1,2,2,3,3,3}};
        for(Integer[] testData : testSet){
            System.out.println();
            System.out.println(gob.solve(new ArrayList<>(Arrays.stream(testData).collect(Collectors.toList()))));
        }
    }
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int i=0,j=1;
        while(j < A.size()){
            while(j < A.size() && A.get(i).intValue() == A.get(j)){
                j++;
            }

            while(j < A.size() && A.get(i) < A.get(j)){
                i++;
                j++;
            }
        }

        return j-i;
    }
}
