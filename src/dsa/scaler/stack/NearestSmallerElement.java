package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        NearestSmallerElement nse = new NearestSmallerElement();
        Utils.printIntArr(nse.prevSmaller(new int[]{ 39, 27, 11, 4, 24, 32, 32, 1}));
    }

    public int[] prevSmaller(int[] A) {
        int[] result = new int[A.length];
        Stack<Integer> minStack = new Stack<>();
        int i = 0;
        for(int a : A){
            while(!minStack.isEmpty() && minStack.peek() >= a){
                minStack.pop();
            }
            if(minStack.isEmpty()){
                result[i++] = -1;
            }else{
                result[i++] = minStack.peek();
            }
            minStack.push(a);
        }
        return result;
    }
}
