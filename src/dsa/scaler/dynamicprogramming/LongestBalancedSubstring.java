package dsa.scaler.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestBalancedSubstring {
    public static void main(String[] args) {
        LongestBalancedSubstring lbs = new LongestBalancedSubstring();
        System.out.println(lbs.LBSlength("((())())()((())((())))("));
    }

    public int LBSlength(final String A) {
        HashMap<Character,Character> bracketPairs = new HashMap<>();
        bracketPairs.put('}','{');
        bracketPairs.put(')','(');
        bracketPairs.put(']','[');

        int[] dp = new int[A.length()];
        dp[0] = -1;
        for(int i=1;i<A.length();i++){
            char c = A.charAt(i);
            if(bracketPairs.containsValue(c)){
                dp[i]=-1;
                continue;
            }
            char prev = A.charAt(i-1);
            if(bracketPairs.containsKey(c) && bracketPairs.get(c) == prev){
                if(i > 2 && dp[i-2] >= 0){
                    dp[i] = dp[i-2];
                }else{
                    dp[i] = i-1;
                }

            }else if(bracketPairs.containsKey(prev) && dp[i-1]!=-1){
                if(dp[i-1]-1 < 0){
                    dp[i]=-1;
                    continue;
                }
                int mIndex = dp[i-1]-1;
                dp[i] =  A.charAt(mIndex) == bracketPairs.get(c) ? mIndex : -1;
                if(dp[i] != -1 && dp[i]-1 > 0 && dp[dp[i]-1] > 0){
                    dp[i] = dp[dp[i]-1];
                }
            }else{
                dp[i] = -1;
            }
        }
        int max = 0;
        for(int i=1;i<dp.length;i++){
            if(dp[i] == -1){
                continue;
            }
            max = Math.max(i+1-dp[i],max);
        }
        return max;
    }
}
