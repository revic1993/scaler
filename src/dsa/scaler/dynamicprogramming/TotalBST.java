package dsa.scaler.dynamicprogramming;

public class TotalBST {
    public static void main(String[] args) {
        TotalBST tbst = new TotalBST();
        System.out.println(tbst.numTrees(18));
    }
    public int numTrees(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=A;i++){
            for(int j=1;j<=i;j++){
                int left = j-1;
                int right = i-j;

                dp[i] += (dp[left]*dp[right]);
            }
        }
        return dp[A];
    }
}
