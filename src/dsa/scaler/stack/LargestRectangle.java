package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();
//        System.out.println(lr.largestRectangleArea(new ArrayList<>(List.of(2,1,5,6,2,3))));
        System.out.println(lr.largestRectangleArea(new ArrayList<>(List.of(47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27))));
    }
    public int largestRectangleArea(ArrayList<Integer> A) {
        ArrayList<Integer> minLeft = getMinLeft(A);
        ArrayList<Integer> minRight = getMinRight(A);
        int maxArea = Integer.MIN_VALUE;
        System.out.format("%10s%10s%10s%10s%10s%10s","i","A","mL","mR","Base","Area","Max");
        for(int i=0;i<A.size();i++){
            int base = minRight.get(i) - minLeft.get(i) - 1;
            System.out.println("");
            maxArea = Math.max(maxArea,base*A.get(i));
            System.out.format("%10d%10d%10d%10d%10d%10d%10d",i, A.get(i), minLeft.get(i),minRight.get(i),base,base*A.get(i),maxArea);
        }
        return maxArea;
    }

    public ArrayList<Integer> getMinLeft(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> minStack = new Stack<>();

        for(int i=0;i<A.size();i++){
            int a = A.get(i);
            while(!minStack.isEmpty() && A.get(minStack.peek()) >= a){
                minStack.pop();
            }
            result.add(minStack.isEmpty() ? -1 : minStack.peek());
            minStack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> getMinRight(ArrayList<Integer> A){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> minStack = new Stack<>();

        for(int i=A.size()-1;i>=0;i--){
            int a = A.get(i);
            while(!minStack.isEmpty() && A.get(minStack.peek()) >= a){
                minStack.pop();
            }
            result.add(minStack.isEmpty() ? A.size() : minStack.peek());
            minStack.push(i);
        }
        Collections.reverse(result);
        return result;
    }
}
