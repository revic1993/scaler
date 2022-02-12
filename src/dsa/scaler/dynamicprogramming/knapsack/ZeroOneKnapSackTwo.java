package dsa.scaler.dynamicprogramming.knapsack;

import java.util.Arrays;

public class ZeroOneKnapSackTwo {
    public static void main(String[] args) {
        ZeroOneKnapSackTwo zokst = new ZeroOneKnapSackTwo();
        System.out.println(zokst.solve(new int[]{6, 10, 12},new int[]{10, 20, 30},50));
    }
    public int solve(int[] values, int[] weights, int capacity) {
        int maxHappiness = Arrays.stream(values).sum();
        int[][] dp = new int[2][maxHappiness+1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0] = 0;
        int result = Integer.MIN_VALUE;
        for(int j=1;j<=values.length;j++){
            for(int i=1;i<=maxHappiness;i++){
                if(values[j-1] <= i){

                    int currentVal = dp[0][i-values[j-1]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[0][i-values[j-1]]+weights[j-1];
                    dp[1][i] = Math.min(dp[0][i],currentVal);
                }else{
                    dp[1][i] = dp[0][i];
                }
                if(dp[1][i] <= capacity){
                    result = Math.max(result,i);
                }
            }
            dp[0] = dp[1];
            dp[0][0] = 0;
            dp[1] = new int[maxHappiness+1];
        }
        return Math.max(result,0);
    }
}
