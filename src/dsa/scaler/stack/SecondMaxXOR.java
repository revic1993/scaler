package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.Stack;

public class SecondMaxXOR {
    public static void main(String[] args) {
        SecondMaxXOR smx = new SecondMaxXOR();
        System.out.println(smx.solve(new int[]{7569780, 6509094, 9066928, 9978215, 9990289, 500953, 5829073, 2862108, 2983492, 8356802}));
    }
    public int solve(int[] A) {
        int[] maxLeftVal = maxLeft(A);
        int[] maxRightVal = maxRight(A);
        Utils.printIntArr(A,"A");
        Utils.printIntArr(maxLeftVal,"maxLeftVal");
        Utils.printIntArr(maxRightVal,"maxRightVal");
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(maxLeftVal[i] != -1){
                maxVal = Math.max(maxVal,A[i]^maxLeftVal[i]);
            }

            if(maxRightVal[i] != -1){
                maxVal = Math.max(maxVal,A[i]^maxRightVal[i]);
            }
        }
        return maxVal;
    }

    public int[] maxLeft(int[] A){
        Stack<Integer> maxStack = new Stack<>();
        int[] result = new int[A.length];
        for(int i=0;i<A.length;i++){
            while(!maxStack.isEmpty() && A[i] >= maxStack.peek()){
                maxStack.pop();
            }
            result[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(A[i]);
        }
        return result;
    }

    public int[] maxRight(int[] A){
        Stack<Integer> maxStack = new Stack<>();
        int[] result = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!maxStack.isEmpty() && A[i] >= maxStack.peek()){
                maxStack.pop();
            }
            result[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(A[i]);
        }

        return result;
    }
}
