package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.Stack;

public class MinMaxSubArrayDiff {
    public static void main(String[] args) {
        MinMaxSubArrayDiff mmsad = new MinMaxSubArrayDiff();
        System.out.println(mmsad.solve(new int[]{4,7,3,8}));
        System.out.println(mmsad.solve(new int[]{1}));
    }


    public int solve(int[] A) {
        int MOD = 1000000007;
        int[] minLeftVal = minLeft(A);
        int[] minRightVal = minRight(A);
        int[] maxLeftVal = maxLeft(A);
        int[] maxRightVal = maxRight(A);
        long total = 0;
        for(int i=0;i<A.length;i++){
            long minContribution = (long) (i - minLeftVal[i]) *(minRightVal[i]-i);
            long maxContribution = (long) (i - maxLeftVal[i]) *(maxRightVal[i]-i);
            maxContribution = maxContribution%MOD;
            minContribution = minContribution%MOD;
            long currentContribution = (((maxContribution*A[i])%MOD - (minContribution*A[i])%MOD)+MOD)%MOD;
            total = (total%MOD + currentContribution%MOD)%MOD;
        }
        return (int) (total % MOD);
    }

    public int[] minLeft(int[] A){
        Stack<Integer> minStack = new Stack<>();
        int[] result = new int[A.length];

        for(int i=0;i<A.length;i++){
            while(!minStack.isEmpty() && A[minStack.peek()] > A[i]){
                minStack.pop();
            }
            result[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);
        }
        return result;
    }

    public int[] minRight(int[] A){
        Stack<Integer> minStack = new Stack<>();
        int[] result = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!minStack.isEmpty() && A[minStack.peek()] > A[i]){
                minStack.pop();
            }
            result[i] = minStack.isEmpty() ? A.length : minStack.peek();
            minStack.push(i);
        }
        return result;
    }

    public int[] maxLeft(int[] A){
        Stack<Integer> maxStack = new Stack<>();
        int[] result = new int[A.length];

        for(int i=0;i<A.length;i++){
            while(!maxStack.isEmpty() && A[maxStack.peek()] < A[i]){
                maxStack.pop();
            }
            result[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        return result;
    }

    public int[] maxRight(int[] A){
        Stack<Integer> maxStack = new Stack<>();
        int[] result = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!maxStack.isEmpty() && A[maxStack.peek()] < A[i]){
                maxStack.pop();
            }
            result[i] = maxStack.isEmpty() ? A.length : maxStack.peek();
            maxStack.push(i);
        }
        return result;
    }

}
