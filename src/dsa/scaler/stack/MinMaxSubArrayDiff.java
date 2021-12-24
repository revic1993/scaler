package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.Stack;

public class MinMaxSubArrayDiff {
    public static void main(String[] args) {
        MinMaxSubArrayDiff mmsad = new MinMaxSubArrayDiff();
        System.out.println(mmsad.solve(new int[]{4,7,3,8}));
    }


    public int solve(int[] A) {
        int MOD = 1000000007;
        int[] minLeftVal = minLeft(A);
        int[] minRightVal = minRight(A);
        int[] maxLeftVal = maxLeft(A);
        int[] maxRightVal = maxRight(A);
        Utils.printIntArr(minLeftVal,"minLeft:");
        Utils.printIntArr(minRightVal,"minRight:");
        Utils.printIntArr(maxLeftVal,"maxLeft:");
        Utils.printIntArr(maxRightVal,"maxRight:");
        long total = 0;
//        for(int i=0;i<A.length;i++){
//            int minLeft = minLeftVal[i] == -1 ? 1 : i-minLeftVal[i]+1;
//            int minRight = minRightVal[i] == -1 ? 1 : minRightVal[i]-i;
//            int maxLeft = maxLeftVal[i] == -1 ? 1 : i-maxLeftVal[i]+1;
//            int maxRight = maxRightVal[i] == -1 ? 1 : maxRightVal[i]-i;
//            long minContribution = (long) minLeft * minRight;
//            long maxContribution = (long) maxRight * maxLeft;
//            total = (total%MOD + ((maxContribution %MOD * A[i]%MOD)%MOD - (minContribution %MOD*A[i]%MOD)%MOD)%MOD)%MOD;
//        }
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
            result[i] = minStack.isEmpty() ? -1 : minStack.peek();
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
            result[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        return result;
    }

}
