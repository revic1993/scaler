package dsa.scaler.arrays;

import java.util.Arrays;

public class BalanceArray {

    public static void main(String[] args) {
        int[][] testSet = new int[][]{
//                {2,1,6,4},
                {5,5,2,5,8,0},
//                {0,1},
//                {0,0},
//                {1,0},
//                {1,1},
//                {1},
                //                {0},
                {1,2,3,4,5,6,7,8,9},
                {1,1,1}
        };

        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" has "+solve(testData)+" special elements");
        }
    }

    public static int solve(int[] A){
        int leftOdd = 0, leftEven = 0, rightOdd = 0, rightEven = 0;

        for(int i=0;i<A.length;i++){
            if((i & 1) == 0){
                rightEven+=A[i];
                continue;
            }
            rightOdd +=A[i];
        }

        int count = 0;
        for(int i=0;i<A.length;i++){
            if((i & 1) == 0){
                rightEven-=A[i];
            }else{
                rightOdd-=A[i];
            }
            if(leftOdd+rightEven == leftEven+rightOdd){
                count++;
            }

            if((i & 1) == 0){
                leftEven+=A[i];
            }else{
                leftOdd+=A[i];
            }
        }
        return count;
    }
}
