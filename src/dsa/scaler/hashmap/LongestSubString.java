package dsa.scaler.hashmap;

import java.util.HashMap;

public class LongestSubString {

    public static void main(String[] args){
        String[] testSet = {"aabbcde"};
        LongestSubString lss = new LongestSubString();
        for(String testData : testSet){
            System.out.println(lss.lengthOfLongestSubstring(testData));
        }
    }

    public int lengthOfLongestSubstring(String A) {
        if(A.length() == 1){
            return 1;
        }
        int maxSubStr = Integer.MIN_VALUE;
        HashMap<Character,Integer> indexMap = new HashMap<>();
        int i=0;
        while(i < A.length()){
            char currentChar = A.charAt(i);
            if(!indexMap.containsKey(currentChar)){
                indexMap.put(currentChar,i);
                i++;
                continue;
            }
            maxSubStr  = Math.max(indexMap.size(),maxSubStr);
            i = indexMap.get(currentChar)+1;
            indexMap = new HashMap<>();
        }

        return Math.max(indexMap.size(),maxSubStr);
    }
}
