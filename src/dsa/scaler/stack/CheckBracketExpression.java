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