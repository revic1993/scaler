package dsa.scaler.stack;

import java.util.HashSet;
import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        RedundantBraces rb = new RedundantBraces();
        System.out.println("((a)) : "+rb.braces("((a))"));
        System.out.println("(a) : "+rb.braces("(a)"));
    }
    public int braces(String A) {
        Stack<Character> expStack = new Stack<>();
        expStack.push('#');
        HashSet<Character> signs = new HashSet<>();
        signs.add('+');
        signs.add('-');
        signs.add('*');
        signs.add('/');

        HashSet<Character> alphabets = new HashSet<>();
        for(int i='a';i<='z';i++){
            alphabets.add((char)i);
        }

        int redundantBraces = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i) !=')'){
                expStack.push(A.charAt(i));
                continue;
            }

            int signCounter = 0;
            int alphabetCounter = 0;
            while(!expStack.isEmpty() && expStack.peek() != '('){
                if(signs.contains(expStack.peek())){
                    signCounter++;
                }else if(alphabets.contains(expStack.peek())){
                    alphabetCounter++;
                }
                expStack.pop();
            }
            if(!expStack.isEmpty()){
                expStack.pop();
            }
            if(signCounter == 0 ){
                redundantBraces++;
            }
        }
        return redundantBraces == 0 ? 0 : 1;
    }
}
