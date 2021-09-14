package dsa.strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[][] testSet = new String[][]{
                {"abcdefgh", "aefghijk", "abcefgh"},
                {"abab", "ab", "abcd"},
                {"ab","cd","de","ba"}
        };
        for (String[] testData: testSet) {
            String result = lcp.longestCommonPrefix(testData);
            System.out.println("longest common prefix for "+ Arrays.toString(testData) +" is :"+result);
        }
    }

    public String longestCommonPrefix(String[] A) {
        int smallest = A[0].length();
        for(int i=0;i<A.length;i++){
            if(smallest > A[i].length()){
                smallest = A[i].length();
            }
        }
        int i=0;
        StringBuilder sb = new StringBuilder();

        while(i<smallest){
            char current = A[0].charAt(i);
            boolean isMatched = true;
            for(int j=1;j<A.length;j++){
                if(isMatched && A[j].charAt(i)==current ){
                    continue;
                }else{
                    isMatched = false;
                    break;
                }
            }
            if(isMatched){
                sb.append(current);
                i++;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
