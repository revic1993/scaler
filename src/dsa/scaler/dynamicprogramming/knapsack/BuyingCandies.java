package dsa.scaler.dynamicprogramming.knapsack;

public class BuyingCandies {
    public static void main(String[] args) {
        BuyingCandies bc = new BuyingCandies();
        System.out.println(bc.solve(new int[]{2},new int[]{5},new int[]{10},99));
    }
    public int solve(int[] A, int[] B, int[] C, int D) {
        int[] dp = new int[D+1];
        dp[0]=0;
        dp[1] = Integer.MIN_VALUE;
        for(int i=0;i<B.length;i++){
            B[i] = B[i]*A[i];
        }

        for(int j=1;j<=D;j++){
            dp[j] = 0;
            for(int i=0;i<C.length;i++){
                if(j>=C[i]){
                    dp[j] = Math.max(dp[j],dp[j-C[i]]+B[i]);
                }
            }
        }
        return dp[D];
    }
}
