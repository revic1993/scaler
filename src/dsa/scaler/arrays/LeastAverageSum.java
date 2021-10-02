package dsa.scaler.arrays;

import java.util.Arrays;

public class LeastAverageSum {
    public static void main(String[] args) {
        int testSet[][][] = new int[][][]{
//                {{1},{3, 7, 90, 20, 10, 50, 40}},
//                {{2},{3, 7, 5, 20, -10, 0, 12}},
                {{9},{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11}},
//                {{5},{98, 83, 98, 83, 98, 98, 59, 80, 16, 59, 59, 59 }}
        };
        LeastAverageSum las = new LeastAverageSum();
        for(int i=0;i<testSet.length;i++){
            int[][] testData = testSet[i];
            System.out.println(Arrays.toString(testData[1])+" has distinct num array "+las.solve(testData[1],testData[0][0]));
        }
    }

    public int solve(int[] A, int B) {

        if(B==1){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=0;i<A.length;i++){
                if(min > A[i]){
                   min = A[i];
                   minIndex = i;
                }
            }
            return minIndex;
        }

        int sum = 0;
        for(int i=0;i<B;i++){
            sum+=A[i];
        }
        int leastAvgSum = sum;
        int startIndex = 0;
        for(int i=1;i<(A.length-B+1);i++){
            sum-=A[i-1];
            sum+=A[i+B-1];
            if(leastAvgSum > sum){
                startIndex = i;
                leastAvgSum = sum;
            }
        }
        return startIndex;
    }
}
