package dsa.scaler.dynamicprogramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSum {
    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.solve(new int[]{1, 5, -3, 4, -2},2,1,-1));
    }
    public int solve(int[] A, int B, int C, int D) {

        int[] preMax1 = new int[A.length];
        preMax1[0] = B*A[0];
        for(int i=1;i<A.length;i++){
            preMax1[i] = Math.max(B*A[i],preMax1[i-1]);
        }
        int[] preMax2 = new int[A.length];
        preMax2[0] = C*A[0]+preMax1[0];
        for(int j=1;j<A.length;j++){
            preMax2[j] = Math.max(preMax1[j]+C*A[j],preMax2[j-1]);
        }
        preMax1 = preMax2;
        preMax2 = new int[A.length];
        preMax2[0] = D*A[0]+preMax1[0];
        for(int k=1;k<A.length;k++){
            preMax2[k] = Math.max(preMax1[k]+D*A[k],preMax2[k-1]);
        }
        return preMax2[A.length-1];

    }

}
//        int max = B*A[i]+C*A[j]+D*A[k];
//        for(;k<A.length;k++){
//            if(C >= 0 && A[j] <= A[k] || C < 0 && A[j] > A[k]){
//                j = k;
//                for(int p=i;p<=k;p++){
//                    if((B >= 0 && A[p] > A[i]) || (B < 0 && A[p] < A[i]) ){
//                        i = p;
//                    }
//                }
//            }else if((B >= 0 && A[k] > A[i]) || (B < 0 && A[k] < A[i]) ){
//                i=k;
//                j=k;
//            }
//            max = Math.max(B*A[i]+C*A[j]+D*A[k],max);
//        }
//        return max;