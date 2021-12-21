package dsa.scaler.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

public class CheckBracketExpression {
    public static void main(String[] args) {
        CheckBracketExpression cbe = new CheckBracketExpression();
//        System.out.println(cbe.solve("-(-(-(-a+b)-d+c)-q)","a-b-d+c+q"));
//        System.out.println(cbe.solve("-(a+b+c)","-a-b-c"));
//        System.out.println(cbe.solve("a-b-(c-d)","a-b-c-d"));
        System.out.println(cbe.solve("-(a-(-z-(b-(c+t)-x)+l)-q)","-a+l-b-(z-(c+t)-x-q)"));
        //A : c+l+q+t+x+z-a-b
        //B : c+l+q+t+x-a-b-z
        //
//        System.out.println(cbe.solve("-(-z+a)","z-a"));

    }
    public int solve(String A, String B) {
        System.out.println("A : "+ flattenString(A));
        System.out.println("B : "+flattenString(B));
       return flattenString(A).equals(flattenString(B)) ? 1 : 0;
    }

    String flattenString(String data){
        HashSet<Character> signs = new HashSet<>();
        signs.add('+');
        signs.add('-');
        HashSet<Character> braces = new HashSet<>();
        braces.add('(');
        braces.add(')');
        //        Stack<Character> expStack = new Stack<>();
        char[] scAlpha = new char[26];
        for(int i=0;i<data.length();i++){
            if(signs.contains(data.charAt(i)) || braces.contains(data.charAt(i))){
                continue;
            }
            char sign = '+';
            if(i!=0 && data.charAt(i-1)=='-'){
                sign='-';
            }
            scAlpha[data.charAt(i)-'a'] = sign;
        }

        Stack<Boolean> negStack = new Stack<>();
        Stack<Character> expStack = new Stack<>();
        for(char datum : data.toCharArray()){
            
        }

//        if(datum == ')' && !negStack.isEmpty()){
//            negStack.pop();
//            continue;
//        }
//
//        if(datum == '('){
//            if(!expStack.isEmpty() && expStack.peek() == '-'){
//                if(negStack.isEmpty())
//                    negStack.push(true);
//                else
//                    negStack.push(!negStack.peek());
//            }else if(expStack.isEmpty() || expStack.peek() != '-'){
//                negStack.push(false);
//            }
//            continue;
//        }
//        expStack.push(datum);
//
//
//        char[] charArr = new char[expStack.size()];
//        int i = expStack.size()-1;
//        while(expStack.size()!=0){
//            charArr[i--] = expStack.pop();
//        }
//
//        return new String(charArr);
        return "";
    }

       /* Stack<Character> charStack = new Stack<>();
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
        return new String(charArr);*/
        /*
        HashSet<Character> signs = new HashSet<>();
        signs.add('+');
        signs.add('-');
        Stack<Character> expStack = new Stack<>();
        Stack<Boolean> negStack = new Stack<>();
        for(char datum : data.toCharArray()){
            if(datum == ')' && !negStack.isEmpty()){
                negStack.pop();
                continue;
            }

            if(datum == '('){
                if(!expStack.isEmpty() && expStack.peek() == '-'){
                    if(negStack.isEmpty())
                        negStack.push(true);
                    else
                        negStack.push(!negStack.peek());
                }else if(expStack.isEmpty() || expStack.peek() != '-'){
                    negStack.push(false);
                }
                continue;
            }

            expStack.push(datum);
        }

        char[] charArr = new char[expStack.size()];
        int i = expStack.size()-1;
        while(expStack.size()!=0){
            charArr[i--] = expStack.pop();
        }

        return new String(charArr);*/
}
