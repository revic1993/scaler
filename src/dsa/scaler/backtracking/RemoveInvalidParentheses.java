package dsa.scaler.backtracking;

import dsa.scaler.hashmap.PointsOnSameLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        System.out.println(rip.solve("))())()))(()((")); //())()))(()
    }
    HashSet<String> result = new HashSet<>();
    public ArrayList<String> solve(String A) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder(A);
        ArrayList<String> returnVal = new ArrayList<>();

        int i=0;
        int j = sb.length()-1;
        while(i < A.length() && A.charAt(i) == ')'){
            sb.deleteCharAt(i);
            sb.insert(i,' ');
            i++;
        }
        while(j >= 0 && A.charAt(j) == '('){
            sb.deleteCharAt(j);
            sb.insert(j,' ');
            j--;
        }
        sb = new StringBuilder(sb.toString().trim());
        if(sb.length() == 0){
            returnVal.add(" ");
            return new ArrayList<>();
        }
        for(char c : sb.toString().toCharArray()){
            if(c == '('){
                left++;
            }else if(c==')'){
                right++;
            }
        }

        int maxBraces = Math.min(left,right);
        System.out.format("%10s%10s%10s%10s%10s","string","left","right","index","maxBraces");
        System.out.println();
        while(maxBraces > 0 && result.isEmpty()){
            removeInvalid(sb,left,right,0,maxBraces-1);
            maxBraces--;
        }

        if(result.isEmpty()){
            returnVal.add(sb.toString().replaceAll("\\(", "")
                                    .replace(")", ""));
            return returnVal;
        }

        returnVal.addAll(result);
        return returnVal;
    }

    public void removeInvalid(StringBuilder sb, int left, int right,int index,int maxBraces){
        System.out.format("%10s%10s%10s%10s%10s",sb.toString(),left,right,index,maxBraces);
        System.out.println();
        if(sb.charAt(0) == ')' || sb.charAt(sb.length()-1)=='('){
            return;
        }
        if(left == right && left == maxBraces){
            boolean isCurrentValid = isValidParentheses(sb);
            System.out.println(sb.toString()+" is "+(isCurrentValid ? "valid" : "invalid")+" for max braces "+maxBraces);
            if(isCurrentValid){

                result.add(sb.toString());
            }
            return;
        }
        char charToRemove;
        int removeFromLeft;
        int removeFromRight;
        if(left > maxBraces || right < left){
            removeFromRight = 0;
            removeFromLeft = 1;
            charToRemove = '(';
        }else {
            removeFromRight = 1;
            removeFromLeft = 0;
            charToRemove = ')';
        }
        for(int i = index;i<sb.length();i++){
            if(sb.charAt(i) != charToRemove){
                continue;
            }
            sb.deleteCharAt(i);
            removeInvalid(sb,left-removeFromLeft,right-removeFromRight,i,maxBraces);
            sb.insert(i,charToRemove);
        }
    }

    public boolean isValidParentheses(StringBuilder data){
        Stack<Character> expStack = new Stack<>();
        for(int i=0;i<data.length();i++){
            if(data.charAt(i) != ')'){
                expStack.push(data.charAt(i));
                continue;
            }
            while(!expStack.isEmpty() && expStack.peek()!='('){
                expStack.pop();
            }

            if(expStack.isEmpty()){
                return false;
            }

            expStack.pop();
        }

        return true;
    }

}
