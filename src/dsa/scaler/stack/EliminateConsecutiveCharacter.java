package dsa.scaler.stack;

import java.util.Stack;

public class EliminateConsecutiveCharacter {

    public String solve(String A) {
        Stack<Character> charStack = new Stack<>();

        for(char c : A.toCharArray()){
            if(charStack.isEmpty() || charStack.peek() != c){
                charStack.push(c);
                continue;
            }

            charStack.pop();
        }
        if(charStack.isEmpty()){
            return "";
        }

        char[] charArr = new char[charStack.size()];
        int i = charStack.size()-1;
        while(!charStack.isEmpty()){
            charArr[i--] = charStack.pop();
        }
        return new String(charArr);
    }
}
