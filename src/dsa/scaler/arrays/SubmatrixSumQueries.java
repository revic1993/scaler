package dsa.scaler.arrays;

import dsa.utils.Utils;

public class SubmatrixSumQueries {
    public static void main(String[] args) {
        SubmatrixSumQueries ssq = new SubmatrixSumQueries();
        Utils.printIntArr(ssq.solve(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }, new int[]{1,2},new int[]{1,2},new int[]{2,3},new int[]{2,3}));

        Utils.printIntArr(ssq.solve(new int[][]{
                {5, 17, 100, 11},
                {0, 0,  2,   8},
        }, new int[]{1,1},new int[]{1,4},new int[]{2,2},new int[]{2,4}));
    }

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int[] result = new int[B.length];
        int MOD = ((int)Math.pow(10,9))+7;

        for(int i=0; i<A.length;i++){
            for(int j = 0; j<= A[0].length;j++){
                if(j == 0){
                    continue;
                }

                A[i][j] = A[i][j]+A[i][j-1];
            }
        }

        for(int k=0;k<B.length;k++){

            int startR = B[k]-1;
            int startC = C[k]-1;

            int endR = D[k]-1;
            int endC = E[k]-1;
            int contribution = 0;
            for(int i=startR; i<=endR;i++){
                for(int j = startC; j<= endC;j++){
                    contribution = (contribution%MOD + A[i][j]%MOD)%MOD;
                }
            }
            result[k] = contribution;
        }
        return result;
    }
}
