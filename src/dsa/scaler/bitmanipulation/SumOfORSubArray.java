package dsa.scaler.bitmanipulation;

import java.util.Arrays;

public class SumOfORSubArray {

    public static void main(String[] args) {
        int[][] testSet = new int[][]{
                {1, 2, 3, 4, 5},
                {7, 8, 9, 10},
                {5,14,9}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" has subarray or sum \t : "+solve(testData));
        }
    }

    public static int solve(int[] A){
        long sum = 0;
        int MOD = 1000000007;
        int[] bitArr = new int[A.length];
        long totalSubArr = (long)(((long) A.length * (A.length+1))/2);
        for(int i=0;i<32;i++){
            long currentSubArr = totalSubArr;
            for(int j=0;j<A.length;j++){
                bitArr[j] = 1 & A[j] >> i;
            }
            for(int j=0;j<A.length;j++){
                if(bitArr[j] == 1){
                    continue;
                }
                int currentInd = j;
                while(j < A.length && bitArr[j] == 0){
                    j++;
                }
                int arrLen = j-currentInd;
                currentSubArr-=(((long) arrLen * (arrLen+1))/2);
            }
            sum = ((sum % MOD)+(currentSubArr*(1 << i) % MOD))%MOD;
        }

        return (int)sum%MOD;
    }
}
