package dsa.scaler.strings;

import java.util.HashSet;

public class OpsGame {

    public static void main(String[] args) {
        String[] testSet = new String[]{
                "AbcaZeoB",
                "AsdfAcdsBesfeio",//sdfcds#sf###sdfcds#sf### sdfcds#sf###sdfcds#sf###
                "aeiou",
                "AEIOU"
        };
        OpsGame opsGame = new OpsGame();
        for(String testData : testSet){
            String result = opsGame.solve(testData);
            System.out.println(testData +" post operation :"+result);
        }
    }

    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for(int i=0;i<A.length();i++){
            if(A.charAt(i) >= 'A' && A.charAt(i) <= 'Z'){
                continue;
            }
            sb.append(set.contains(A.charAt(i)) ? '#' : A.charAt(i));
        }
        sb.append(sb);
        return sb.toString();
    }
}
