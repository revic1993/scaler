package dsa.scaler.hashmap;

public class PermutationsOfString {
    public int solve(String A, String B) {
        if(A.length() > B.length()){
            return 0;
        }

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(char c : A.toCharArray()){
            freqA[c-'a']++;
        }

        int windowSize = A.length();
        int totalPerm = 0;
        for(int i=0;i<windowSize;i++){
            freqB[B.charAt(i) - 'a']++;
        }

        if(compareFrequencies(freqA,freqB)){
            totalPerm++;
        }

        for(int i=windowSize;i<B.length();i++){
            int charToRemove = B.charAt(i-windowSize)-'a';
            int charToAdd = B.charAt(i)-'a';
            freqB[charToRemove]--;
            freqB[charToAdd]++;
            if(compareFrequencies(freqA,freqB)){
                totalPerm++;
            }
        }
        return totalPerm;
    }

    boolean compareFrequencies(int[] freqA,int[] freqB){
        for(int i=0;i<freqA.length;i++){
            if(freqA[i] != freqB[i]){
                return false;
            }
        }

        return true;
    }
}
