package dsa.arrays.sort;

import java.util.Arrays;
import java.util.Collections;

public class MinCostOfRemoval {

    public static void main(String[] args) {
        int[][] testSet = new int[][]{
                {4,2,1,3},
                {1,1,1,1},
                {4,3,4,2},
                {0},{}
        };

        MinCostOfRemoval mcr = new MinCostOfRemoval();

        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " has cost of removal "+mcr.solve(testData));
        }
    }

    public int solve(int[] A) {
        if(A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int minCost = 0;
        int multiplier = A.length;
        for(int i=0;i<A.length;i++,multiplier--){
            minCost+= (multiplier)*A[i];
        }
        return minCost;
    }
}
