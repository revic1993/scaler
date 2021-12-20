package dsa.scaler.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min;
    MinStack(){
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(stack.size() == 0){
            min = x;
        }

        if(stack.size() > 0 && min > x){
            int temp = x;
            x = 2*temp - min;
            min = temp;
        }

        stack.push(x);
    }

    public void pop() {
        if(stack.size() == 0){
            min = Integer.MAX_VALUE;
            return;
        }

        int peek = stack.peek();

        if(peek < min){
            min = 2*min - peek;
        }

        stack.pop();

        if(stack.size()==0){
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(stack.size()==0){
            return -1;
        }
        int peek = stack.peek();

        if(peek < min){
            peek = min;
        }

        return peek;
    }

    public int getMin() {
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
