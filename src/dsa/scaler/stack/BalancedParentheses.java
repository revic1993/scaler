package dsa.scaler.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        BalancedParentheses bp = new BalancedParentheses();
        System.out.println(bp.solve("{([])}"));
        System.out.println(bp.solve("(){"));
        System.out.println(bp.solve("()[] "));
    }

    public int solve(String A) {
        Stack<Character> charStack = new Stack<>();
        HashMap<Character,Character> opening = new HashMap<>();
        opening.put('}','{');
        opening.put(')','(');
        opening.put(']','[');

        for(char c : A.trim().toCharArray()){
            if(opening.containsValue(c)){
                charStack.push(c);
            }
            else if(charStack.size()!=0 && charStack.peek() == opening.get(c)){
                charStack.pop();
            }
           else{
                return 0;
            }
        }
        return charStack.size() == 0 ? 1 : 0;
    }
}
