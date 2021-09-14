package dsa.strings;

import java.util.Arrays;
import java.util.HashMap;

public class ChangeCharacter {
    public static void main(String[] args) {
        String testData = "abcabbccd";
        ChangeCharacter cc = new ChangeCharacter();
        for(int i=0;i<9;i++){
            System.out.println("for i: "+i+" total unique characters are "+cc.solve(testData,i));
        }
    }
    public int solve(String A, int B) {
        //HINT : we can use new array of size 26 and store freq in A[A[i]-'a']
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(int i=0;i<A.length();i++){
            int currentCharFreq = freqMap.getOrDefault(A.charAt(i),0);
            freqMap.put(A.charAt(i),++currentCharFreq);
        }

        Integer[] freq = freqMap.values().toArray(new Integer[0]);
        if(B==0){
            return freq.length;
        }
        Arrays.sort(freq);
        int index = 0;

        while(B > 0 && index < freq.length){
            if(freq[index] <= B && freq[index] != 0){
                B-=freq[index];
                freq[index]=0;
                index++;
            }else{
                break;
            }
        }

        return freq.length - index == 0 ? 1 : freq.length - index;
    }
}
