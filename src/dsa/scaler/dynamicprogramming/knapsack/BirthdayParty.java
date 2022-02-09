package dsa.scaler.dynamicprogramming.knapsack;

import dsa.utils.Utils;

import java.util.Collections;

public class BirthdayParty {
    public static void main(String[] args) {
        BirthdayParty bp = new BirthdayParty();
        System.out.println(bp.solve(new int[]{2,4,6},new int[]{2,1,3},new int[]{2,5,3}));
    }
    public int solve(final int[] A, final int[] B, final int[] C) {
        int max = Integer.MIN_VALUE;
        for(int a : A){
            max = Math.max(max,a);
        }
        int[] dp = solveForMaxCapacity(max,C,B);
        int total = 0;
        for(int a : A){
            total+=dp[a];
        }
        return total;
    }
    public int[] solveForMaxCapacity(int W, int[] values, int[] weights) {
        int[] dp = new int[W+1];
        dp[0] = 0;
        for(int j=1;j<=W;j++){
            dp[j] = Integer.MAX_VALUE;
            for(int i=0;i<weights.length;i++){
                if(j>=weights[i]){
                    dp[j] = Math.min(dp[j],dp[j-weights[i]]+values[i]);
                }
            }
        }
        return dp;
    }
}
