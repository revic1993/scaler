package dsa.scaler.stack;

import java.util.*;
import java.util.stream.Collectors;

public class CheckBracketExpression {
    public static void main(String[] args) {
        CheckBracketExpression cbe = new CheckBracketExpression();
        System.out.println(cbe.solve("-(-(-(-a+b)-d+c)-q)","a-b-d+c+q"));
        System.out.println(cbe.solve("-(a+b+c)","-a-b-c"));
        System.out.println(cbe.solve("a-b-(c-d)","a-b-c-d"));
        System.out.println(cbe.solve("-(a-(-z-(b-(c+t)-x)+l)-q)","-a+l-b-(z-(c+t)-x-q)"));
        System.out.println(cbe.solve("-(-z+a)","z-a"));
        System.out.println(cbe.solve("-(a+((b-c)-(d+e)))","-(a+b-c-d-e)"));

    }

    HashSet<Character> signs = new HashSet<>();
    HashSet<Character> braces = new HashSet<>();
    HashSet<Character> alphabets = new HashSet<>();
    public int solve(String A, String B) {
        signs.add('+');
        signs.add('-');

        braces.add('(');
        braces.add(')');

        for(int i='a';i<='z';i++){
            alphabets.add((char) i);
        }
        char[] aFlattened = flattenString(A);
        char[] bFlattened = flattenString(B);
//        System.out.println(aFlattened);
//        System.out.println(bFlattened);
        for(int i=0;i<26;i++){
            if(!signs.contains(aFlattened[i]) && !signs.contains(bFlattened[i])){
                continue;
            }

            if(aFlattened[i] != bFlattened[i]){
                return 0;
            }
        }
        return 1;
    }

    char[] flattenString(String data){
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
            if(datum != '('){
                if(alphabets.contains(datum) && !negStack.isEmpty()){
                    if(negStack.peek()){
                        char sign = !expStack.isEmpty() && expStack.peek()=='-' ? '+' : '-';
                        scAlpha[datum-'a'] = sign;
                    }
                }
                if(datum==')' && !  negStack.isEmpty()){
                    negStack.pop();
                }
                expStack.push(datum);
                continue;
            }

            if(!expStack.isEmpty() && expStack.peek() == '-'){
                if(negStack.isEmpty()){
                    negStack.push(true);
                }else{
                    negStack.push(!negStack.peek());
                }
            }else{
                if(negStack.isEmpty()){
                    negStack.push(false);
                }else{
                    negStack.push(negStack.peek());
                }
            }
            expStack.push(datum);
        }
        return scAlpha;
    }
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