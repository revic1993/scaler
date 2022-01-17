package dsa.scaler.math;

public class FindRank {
    public static void main(String[] args) {

    }

    public int findRank(String A) {
        int[] charMap = new int[26];
        for(char a : A.toCharArray()){
            charMap[a-'a']++;
        }
        return -1;
    }

}
