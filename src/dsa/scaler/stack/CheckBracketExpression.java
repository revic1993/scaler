package dsa.scaler.stack;

import java.util.HashSet;
import java.util.Stack;

public class CheckBracketExpression {
    public static void main(String[] args) {
        CheckBracketExpression cbe = new CheckBracketExpression();
        System.out.println(cbe.solve("-(-(-(-a+b)-d+c)-q)","a-b-d+c+q"));
    }
    public int solve(String A, String B) {
        System.out.println( flattenString(A));
       return flattenString(A).equals(flattenString(B)) ? 1 : 0;
    }

    String flattenString(String data){
        Stack<Character> charStack = new Stack<>();
        HashSet<Character> signs = new HashSet<>();
        signs.add('+');
        signs.add('-');
        char lastSignInserted = 0;
        boolean isNeg = false;
        StringBuilder sb = new StringBuilder();
        for(char datum : data.toCharArray()){
            if(datum == '('){
                if(charStack.size() != 0 && lastSignInserted == '-'){
                    isNeg = true;
                }
                continue;
            }else if(datum == ')'){
                isNeg = false;
                continue;
            }

            if((datum == '+' || datum == '-') && isNeg){
                datum = datum == '+' ? '-' : '+';
            }

            if(datum == '+' || datum == '-' && !isNeg){
                lastSignInserted = datum;
            }
            if(signs.contains(datum) && charStack.size()!=0 && signs.contains(charStack.peek())){
                continue;
            }
            charStack.push(datum);
        }
        char[] charArr = new char[charStack.size()];
        int i = charStack.size()-1;
        while(charStack.size()!=0){
            charArr[i--] = charStack.pop();
        }
        return new String(charArr);
    }
}
