package dsa.arrays.sort;

import java.util.Arrays;

public class ArithmeticProgression {

    public static void main(String[] A){
        int[][] testSet = new int[][]{
                {1,5,3,7},
                {1,2,3,4},
                {1,7,9,3,5},
                {-1, -5, 3, 7},
                { -1, 2 ,0},
                {1,2,4,5},
                {1,1,1,1},
                {0,0,0,0}
        };
        ArithmeticProgression ap = new ArithmeticProgression();
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" is arithmetic progress "+ap.solve(testData));
        }
    }

    public int solve(int[] A){
        Arrays.sort(A);
        int currentDiff = A[1] - A[0];
        for(int i = 2; i<A.length;i++){
            if(A[i]-A[i-1] != currentDiff){
                return 0;
            }
        }
        return 1;
    }
}
