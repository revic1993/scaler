package dsa.scaler.dynamicprogramming.knapsack;

import java.util.Arrays;

public class UnboundedKnapsack {


    public static void main(String[] args) {
        UnboundedKnapsack ukn = new UnboundedKnapsack();
        System.out.println(ukn.solve(10,new int[]{6,7},new int[]{5,5}));
    }
    public int solve(int W, int[] values, int[] weights) {
//        getMax(W,values,weights,0);
        int[] dp = new int[W+1];
        dp[0] = 0;
        for(int j=1;j<=W;j++){
            dp[j] = 0;
            for(int i=0;i<weights.length;i++){
                if(j>=weights[i]){
                    dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
            }
        }
        return dp[W];
    }

//    public void getMax(int W,int[] values,int[] weights,int total){
//        max = Math.max(total,max);
//        if(W <= 0){
//            return;
//        }
//        for(int i=0;i<weights.length;i++){
//            if(W-weights[i]>=0){
//                getMax(W-weights[i],values,weights,total+values[i]);
//            }
//        }
//    }
}
