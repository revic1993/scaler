package dsa.scaler.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(3)));
    }
    public static String[] generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        solve(new StringBuilder(""),A,0,0,result);
        String[] resultArr = new String[result.size()];
        int i = 0;
        for(String p : result){
            resultArr[i++] = p;
        }
        return resultArr;
    }

    public static void solve(StringBuilder sb, int A,int cStart,int cEnd,ArrayList<String> permutations){
        if(cEnd > cStart){
            return;
        }

        if(sb.length() == 2*A && cStart == cEnd){
            permutations.add(sb.toString());
            return;
        }

        if(cStart < A){
            solve(sb.append("("),A,cStart+1,cEnd,permutations);
            sb.delete(sb.length()-1,sb.length());
        }

        if(cEnd < cStart){
            solve(sb.append(")"),A,cStart,cEnd+1,permutations);
            sb.delete(sb.length()-1,sb.length());
        }

    }
}
