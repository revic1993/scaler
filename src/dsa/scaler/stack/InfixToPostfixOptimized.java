package dsa.scaler.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class InfixToPostfixOptimized {
    public static void main(String[] args) {
        InfixToPostfixOptimized itpo = new InfixToPostfixOptimized();
        System.out.println(itpo.solve("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public String solve(String A) {
        StringBuilder result = new StringBuilder();
        HashMap<Character,Integer> operatorPrecedence = new HashMap<>();
        operatorPrecedence.put('+',0);
        operatorPrecedence.put('-',0);
        operatorPrecedence.put('*',1);
        operatorPrecedence.put('/',1);
        operatorPrecedence.put('^',2);

        HashSet<Character> braces = new HashSet<>();
        braces.add('(');
        braces.add(')');
        Stack<Character> operatorStack = new Stack<>();
        for(char c : A.toCharArray()){
            if(!operatorPrecedence.containsKey(c) && !braces.contains(c)){
                result.append(c);
                continue;
            }

            if(operatorPrecedence.containsKey(c)){
                int currentPrecedence = operatorPrecedence.get(c);
                while(!operatorStack.isEmpty() && operatorPrecedence.containsKey(operatorStack.peek()) && currentPrecedence <= operatorPrecedence.get(operatorStack.peek())){
                    result.append(operatorStack.pop());
                }
                operatorStack.push(c);
                continue;
            }

            if(c == '('){
                operatorStack.push(c);
                continue;
            }

            while(!operatorStack.isEmpty() && operatorStack.peek()!='('){
                result.append(operatorStack.pop());
            }
            operatorStack.pop();
        }
        while(!operatorStack.isEmpty()){
            result.append(operatorStack.pop());
        }
        return result.toString();
    }
}
