package dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChar {
    public static void main(String[] args){
        LongestSubstrWithoutRepeatingChar lls = new LongestSubstrWithoutRepeatingChar();
        ArrayList<String> dataset = new ArrayList<>(Arrays.asList(" ","abcabcbb","bbbbbb","","pwwkew","  a"));//
        for (String data: dataset) {
            System.out.println("maxVal for "+data + " is : " + lls.lengthOfLongestSubstring(data));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> sequence = new HashSet<>();
        char[] characters = s.toCharArray();
        int maxSize = 0;
        for(char c : characters){
            if(sequence.contains(c)){
                maxSize = Math.max(maxSize, sequence.size());
                sequence = new HashSet<>();
                sequence.add(c);
                continue;
            }
            sequence.add(c);
        }
        return Math.max(maxSize,sequence.size());
    }
}
