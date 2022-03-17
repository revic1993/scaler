package dsa.scaler.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

public class FlipArray {
    public static void main(String[] args) {
        FlipArray fa = new FlipArray();
//        System.out.println(fa.solve(new int[]{ 11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3}));
        System.out.println(fa.solve(new int[]{15,10,6,5,2}));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public int solve(final int[] A) {

      int capacity = (Arrays.stream(A).sum() >> 1);
      Pair[][] dp = new Pair[2][capacity+1];

      for(int i=0;i<=A.length;i++){
          for(int j=0;j<=capacity;j++){
              if(i == 0 || j == 0){
                  dp[1][j] = new Pair();
                  continue;
              }

              if(A[i-1] > j){
                  dp[1][j] = dp[0][j];
                  continue;
              }
              Pair newPair = new Pair();
              newPair.sum = dp[0][j-A[i-1]].sum+A[i-1];
              newPair.totalInverted = dp[0][j-A[i-1]].totalInverted+1;
              dp[1][j] = comparePair(dp[0][j],newPair);
          }
          dp[0] = dp[1];
          dp[1] =  new Pair[capacity+1];
      }
      return dp[0][capacity].totalInverted;
    }

    static Pair comparePair(Pair p1, Pair p2){
        if(p1.sum != p2.sum){
            return p1.sum > p2.sum ? p1 : p2;
        }
        return p1.totalInverted > p2.totalInverted ? p2 : p1;
    }

    static class Pair{
        int sum;
        int totalInverted;

        Pair(){
            this.sum = 0;
            this.totalInverted = 0;
        }

        @Override
        public String toString() {
            return "{" +
                    "sum :" + sum +
                    ", totalInverted :" + totalInverted +
                    '}';
        }
    }

}
