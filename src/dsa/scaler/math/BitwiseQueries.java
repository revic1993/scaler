package dsa.scaler.math;

import java.util.Arrays;

public class BitwiseQueries {
    public static void main(String[] args) {
        int[][] result = solve(new int[]{1,0,0,0,1},new int[][]{
                {2,4},
                {1,5},
                {3,5}
        });
        for (int[] resultVal : result){
            System.out.println(Arrays.toString(resultVal));
        }
    }

    public static int[][] solve(int[] A, int[][] B) {
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for(int i=1;i<A.length;i++){
            prefixSum[i] = A[i]+prefixSum[i-1];
        }

        int[][] result = new int[B.length][2];
        for(int i=0;i<B.length;i++){
            int l = B[i][0] == 1 ? 0 : prefixSum[B[i][0]-2];
            int r = prefixSum[B[i][1]-1];
            int rangeSum = r - l;
            int rangeDiff = B[i][1] - B[i][0] + 1;
            int zeros = rangeDiff - rangeSum;
            result[i][0] = rangeSum % 2 == 0 ? 0 : 1;
            result[i][1] = zeros;
        }
        return result;
    }
}
