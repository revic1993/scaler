package dsa.scaler.dynamicprogramming.knapsack;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        ZeroOneKnapsack zok = new ZeroOneKnapsack();
        System.out.println(zok.solve(new int[]{6,10,20},new int[]{1,2,3},5));
    }

    public int solve(int[] A, int[] B, int C) {
        int[][] dp = new int[2][C+1];
        for(int i=0;i<=A.length;i++){
            for(int j=0;j<=C;j++){
                if(i == 0 || j == 0){
                    dp[1][j] = 0;
                    continue;
                }
                if(j-B[i-1] >= 0){
                    dp[1][j] = Math.max(dp[0][j],dp[0][j-B[i-1]]+A[i-1]);
                }else{
                    dp[1][j] = dp[0][j];
                }
            }
            dp[0] = dp[1];
            dp[1] = new int[C+1];
        }
        return dp[0][C];
    }
}
