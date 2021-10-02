package dsa.scaler.strings;

import java.util.HashSet;

public class SpecialCharacterSeq {

    public static void main(String[] args) {
        String[] testSet = new String[]{
                "ABEC",
                "IDDABBEC",
                "AEIOU",
                "BCDCD"
        };
        SpecialCharacterSeq scs = new SpecialCharacterSeq();
        for (String testData : testSet){
            System.out.println(testData + " has "+scs.solve(testData)+" sequence");
        }
    }

    public int solve(String A) {
        int MOD = 10003;

        HashSet<Character> spCharSet = new HashSet<>();
        spCharSet.add('A');
        spCharSet.add('E');
        spCharSet.add('I');
        spCharSet.add('O');
        spCharSet.add('U');

        spCharSet.add('a');
        spCharSet.add('e');
        spCharSet.add('i');
        spCharSet.add('o');
        spCharSet.add('u');

        int i = A.length()-1, nonSpecialChar = 0 , totalSeq=0,prevSeqSum = 0;
        while(i >= 0){
            if(!spCharSet.contains(A.charAt(i))){
                nonSpecialChar++;
            }else{
                prevSeqSum = (nonSpecialChar%MOD+1+prevSeqSum%MOD)%MOD;
                totalSeq = (totalSeq%MOD +  prevSeqSum % MOD) % MOD;
                nonSpecialChar = 0;
            }
            i--;
        }
        return totalSeq;
    }
}
