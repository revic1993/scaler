package dsa.scaler.dynamicprogramming.knapsack;

public class CuttingARod {
    public static void main(String[] args) {
        CuttingARod cr = new CuttingARod();
        System.out.println(cr.solve(new int[]{1,5,2,5,6}));
    }

    public int solve(int[] A) {
        int N = A.length;
        int[] dp = new int[A.length+1];
        dp[0] = 0;
        for(int currentMaxCap=1;currentMaxCap<=N;currentMaxCap++){
            dp[currentMaxCap] = Integer.MIN_VALUE;
            for(int currentCap=currentMaxCap;currentCap>=1;currentCap--){
                dp[currentMaxCap] = Math.max(dp[currentMaxCap],dp[currentMaxCap-currentCap]+A[currentCap-1]);
            }
        }
        return dp[N];
    }
}
