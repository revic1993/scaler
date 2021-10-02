package dsa.scaler.arrays;

import java.util.Arrays;

public class NonDecreasingSubarray {
    public static void main(String[] args) {
        int[][] testSetA = {
                {7, 7, 1, 6, 9 },
                {1,7,3,4,9}
        };
        int[][][] testSetB = {
                {
                    {1, 3},
                    {4, 5},
                    {1, 2},
                    {3, 4},
                    {1, 5},
                },
                {
                        {1, 2},
                        {2, 4},

                }
        };
        for (int i = 0; i < testSetA.length; i++) {
            System.out.println("A: "+Arrays.toString(testSetA[i])+" result: "+Arrays.toString(solve(testSetA[i],testSetB[i])));
        }
    }

    public static int[] solve(int[] A, int[][] B) {
        int[] prefixSum = new int[A.length];
        for(int i=1;i<A.length;i++){
            prefixSum[i] = A[i] < A[i-1] ? 1 : 0;
            prefixSum[i] += prefixSum[i-1];
        }
        int[] result = new int[B.length];

        for(int j=0;j<result.length;j++){
            result[j] = prefixSum[B[j][1]-1]-prefixSum[B[j][0]-1] == 0 ? 1 : 0;
        }
        return result;
    }
}
