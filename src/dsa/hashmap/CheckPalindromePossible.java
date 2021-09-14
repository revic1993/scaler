package dsa.hashmap;

import java.util.HashSet;

public class CheckPalindromePossible {
    public static void main(String[] args){
        System.out.println(solve("abcde"));
        System.out.println(solve("abcba"));
        System.out.println(solve("aaaaa"));
        System.out.println(solve("a"));
    }

    public static int solve(String A){
        char[] charArr = A.toCharArray();
        HashSet<Character> charSet = new HashSet<>();
        for(char c : charArr){
            if(charSet.contains(c)){
                charSet.remove(c);
                continue;
            }
            charSet.add(c);
        }
        int isOdd = A.length() & 1;
        return isOdd == charSet.size() ? 1 : 0;
    }
}
