package dsa.scaler.backtracking;

import dsa.scaler.hashmap.PointsOnSameLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
//        System.out.println(rip.solve("))())()))(()((")); //())()))(()
        rip.solve("))");
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
//            returnVal.add(" ");
            return returnVal;
        }
        for(char c : sb.toString().toCharArray()){
            if(c == '('){
                left++;
            }else if(c==')'){
                right++;
            }
        }

        int maxBraces = Math.min(left,right);
//        System.out.format("%10s%10s%10s%10s%10s","string","left","right","index","maxBraces");
        System.out.println();
        while(maxBraces > 0 && result.isEmpty()){
            removeInvalid(sb,left,right,0,maxBraces);
            maxBraces--;
        }

        if(result.isEmpty()){
            String result = sb.toString().replaceAll("\\(", "")
                                    .replace(")", "");
            if(result.isEmpty()){
                result = " ";
            }
            returnVal.add(result);
            return returnVal;
        }

        returnVal.addAll(result);
        return returnVal;
    }

    public void removeInvalid(StringBuilder sb, int left, int right,int index,int maxBraces){
        if(left < maxBraces || right < maxBraces){
            return;
        }

//        System.out.format("%10s%10s%10s%10s%10s",sb.toString(),left,right,index,maxBraces);
        if(left == right && left == maxBraces){
            boolean isCurrentValid = isValidParentheses(sb);
            System.out.println(sb.toString()+" is "+(isCurrentValid ? "valid" : "invalid")+" for max braces "+maxBraces);
            if(isCurrentValid){
                result.add(sb.toString());
            }
            return;
        }

        for(int i = index;i<sb.length();i++){
            char currentChar = sb.charAt(i);
            if(currentChar != '(' && currentChar!=')'){
                continue;
            }
            int removeFromLeft = currentChar == '(' ? 1 : 0;
            int removeFromRight = currentChar == ')' ? 1 : 0;
            sb.deleteCharAt(i);
            removeInvalid(sb,left-removeFromLeft,right-removeFromRight,i,maxBraces);
            sb.insert(i,currentChar);
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
