package dsa.scaler.arrays;

import java.util.Arrays;

public class AbsoluteMaximum {
    public static void main(String[] args) {
        int[][] testData = {
                {1, 2, 3, 4},
                {-1, 4, 5, 6},
                {-10, 5, 3, -8},
                {-1, -9, -6, -10}
        };
        System.out.println("absMax -> "+solve(testData[0],testData[1],testData[2],testData[3]));
    }

    public static int solve(int[] A, int[] B, int[] C, int[] D) {
        int absMax = Integer.MIN_VALUE;
        for(int i=0;i<16;i++){
            int max_i = Integer.MIN_VALUE;
            int min_i = Integer.MAX_VALUE;
            for(int j=0;j<A.length;j++){
                int currSum = A[j];
                for(int k=0;k<4;k++){
                    int temp;
                    if(k == 0){
                        temp = B[j];
                    }else if( k == 1){
                        temp = C[j];
                    }else if(k == 2){
                        temp = D[j];
                    }else{
                        temp = j;
                    }
                    if((i & (1 << k)) == (1 << k)){
                        currSum += temp;
                    }else{
                        currSum-=temp;
                    }
                }
                max_i = Math.max(max_i,currSum);
                min_i = Math.min(min_i,currSum);
            }
            absMax = Math.max(absMax,max_i - min_i);
        }
        return absMax;
    }
}