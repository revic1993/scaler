package dsa.scaler.dynamicprogramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSum {
    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.solve(new int[]{1,5,-3,4,-2},2,1,-1));
    }
    public int solve(int[] A, int B, int C, int D) {
        int max = Integer.MIN_VALUE;
        for(int k=0;k<A.length;k++){
            for(int j=0;j<=k;j++){
                for(int i=0;i<=j;i++){
                    max = Math.max(max,D*A[k]+A[j]*C+A[i]*B);
                }
            }
        }
        return max;
    }


    static class HeapNode{
        int val;
        int index;
        HeapNode(int val, int index){
            this.val = val;
            this.index = index;
        }

    }
}
