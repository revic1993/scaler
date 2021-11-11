package dsa.scaler.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneCombinations {

    public static void main(String[] args) {
        String[] testSet = {
                "23","102","123"
        };
        for(String testData : testSet){
            System.out.println(testData +" => "+ Arrays.toString(letterCombinations(testData)));
        }
    }

    public static String[] letterCombinations(String A) {
        String[] digitsMap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = addCombinations(A,digitsMap,0);
        return result.toArray(new String[result.size()]);
    }

    public static ArrayList<String> addCombinations(String A, String[] digitsMap, int index){
        ArrayList<String> result;
        String charSet = digitsMap[Integer.parseInt(String.valueOf(A.charAt(index)))];

        if(index == A.length()-1){
            result = new ArrayList<>();
            for(char c : charSet.toCharArray()){
                result.add(c+"");
            }
            return result;
        }
        result = addCombinations(A,digitsMap,index+1);
        ArrayList<String> newResult = new ArrayList<>();
        for(char c : charSet.toCharArray()){
            for(String res : result){
                newResult.add(c+res);
            }
        }
        return newResult;
    }
}
