package dsa.scaler.bitmanipulation;

import java.util.Arrays;

public class MinimumXor {

    public int solve(int[] A){
        Arrays.sort(A);
        int minXOR = Integer.MAX_VALUE;

        for(int i=0;i<A.length-1;i++){
            minXOR = Math.min(minXOR,A[i]^A[i+1]);
        }

        return minXOR;
    }
}
