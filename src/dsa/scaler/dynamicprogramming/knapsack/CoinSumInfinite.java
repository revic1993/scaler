package dsa.scaler.dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.HashMap;

public class CoinSumInfinite {
    public static void main(String[] args) {
        CoinSumInfinite csi = new CoinSumInfinite();
        System.out.println(csi.coinchange2(new int[]{1,2,3},4));
    }
    int mod = (1000*1000)+7;

    public int coinchange2(int[] A, int B) {
        int[] dp = new int[B+1];
        dp[0] = 1;
        for (int a : A) {
            for (int j = a; j <= B; j++) {
                dp[j] = (dp[j] % mod + dp[j - a] % mod) % mod;
            }
        }
        return dp[B];
    }


}
