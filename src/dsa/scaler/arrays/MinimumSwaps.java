package dsa.scaler.arrays;

import java.util.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[][][] testSet = {
                {{1, 12, 10, 3, 14, 10, 5},{8}},
                {{5, 17, 100, 11},{20}}
        };

        for(int[][] testData : testSet){
            System.out.println("A = "+Arrays.toString(testData[0])+" B = "+testData[1][0]+" => "+solve(testData[0],testData[1][0]));
        }
    }

    public static int solve(int[] A, int B) {
        return -1;
    }
}
