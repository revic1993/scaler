package dsa.arrays;

import java.util.Arrays;
import java.util.Random;

public class SumOfMinMaxSeq {

    public static void main(String[] args) {
        int[][] testSet = {
                {4,1,9,7},
                {5,4,6,2},
                {1,2,3,4,5,6,7,8,9}
        };
        //863554634

//        System.out.println(Arrays.toString(bigTestSet)+" subsequence max and min sum is "+solve(bigTestSet));
        for (int[] testData: testSet) {
            System.out.println(Arrays.toString(testData)+" subsequence max and min sum is "+solve(testData));
        }
    }
    public static int solve(int[] A) {
        if(A.length == 1){
            return 0;
        }

//        863554634,23773375
        Arrays.sort(A);
        int[] powerArr = new int[A.length];
        powerArr[0] = 1;
        int MOD = 1000000007;

        for(int i=1;i<A.length;i++){
            powerArr[i] = (((powerArr[i-1] % MOD) * (2)) % MOD);
        }

        int maxSum = 0;
        int minSum = 0;
        int N = A.length-1;
        for(int i=0;i<A.length;i++){
            int maxPossibilities = ((A[i]%MOD)*((powerArr[i]%MOD - 1)%MOD)%MOD);
            int minPossibilities = ((A[i]%MOD)*((powerArr[N-i]%MOD - 1) % MOD)%MOD);
            maxSum = ((maxSum%MOD)+(maxPossibilities%MOD))%MOD;
            minSum = ((minSum%MOD)+(minPossibilities%MOD))%MOD;
        }

        int total = (maxSum%MOD - minSum%MOD) % MOD;
        return total < 0 ? MOD+total : total;
    }
}
