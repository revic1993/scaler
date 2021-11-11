package dsa.scaler.math.modulo;

import java.util.Arrays;

/*
* src : https://www.scaler.com/academy/mentee-dashboard/classroom/maths-modular-arithmetic-3aaa36c4-75b1-448f-a00b-19d0c5d8c895/#homework
* */
public class ModSum {
    public static void main(String[] args) {
        int[][] testSet = {
//                {1,2,3,4,5},
                {17,100,25},
//                {686, 675, 758, 659, 377, 965, 430, 220, 599, 699}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " => " + solve(testData));
        }
    }

    public static int solve(int[] A) {
       Arrays.sort(A);
       int totalSum = 0;
       int MOD = 1000000007;
       int N = A.length;
       for(int i=0;i<N-1;i++){
            totalSum = (totalSum%MOD +  ((N-i-1)%MOD * A[i]%MOD)%MOD)%MOD;
       }
       for(int j=N-1;j>=1;j--){
           for(int i = j-1;i>=0;i--){
               totalSum = (totalSum%MOD + ((A[j]%A[i])%MOD))%MOD;
           }
       }
       return totalSum;
    }
}
