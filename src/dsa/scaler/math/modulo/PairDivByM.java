package dsa.scaler.math.modulo;

import java.util.Arrays;

public class PairDivByM {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        int[][] testSet = {
                {93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49},
                {37}
        };
        System.out.println("Total pairs found for "+ Arrays.toString(testSet[0]) + " is "+solve(testSet[0],testSet[1][0]));
    }

    public static int solve(int[] A, int B) {
        int[] bucketFreq = new int[B];

        for (int a : A){
            bucketFreq[a%B]++;
        }
        int sum = combinations(bucketFreq[0])%MOD;
        int limit = (B & 1) == 0 ? (B/2) : (B/2)+1;
        for (int i=1;i<limit;i++){
            if(bucketFreq[i]==0 || bucketFreq[B-i]==0){
                continue;
            }
            sum = (sum % MOD + ((bucketFreq[i]%MOD) *(bucketFreq[B-i]%MOD) % MOD))%MOD;
        }
        int comb = (B & 1) == 0 ? combinations(bucketFreq[B/2])%MOD : 0;
        sum = (sum%MOD + comb%MOD)%MOD;
        return (sum % MOD);
    }

    public static int combinations(int n){
        if(n % 2 == 0){
            return ((n/2)%MOD * (n-1) % MOD)%MOD;
        }
        return (((n-1)/2)%MOD * (n) % MOD)%MOD;
    }
}
