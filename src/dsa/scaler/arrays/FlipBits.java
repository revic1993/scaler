package dsa.scaler.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* Source : https://www.scaler.com/academy/mentee-dashboard/classroom/multidimensional-arrays-c25633a4-d486-4265-bf0c-5e2d262589b0/#assignment%2F329
* */
public class FlipBits {
    public static void main(String[] args) {
        String[] testSet = {
//                "010",
//                "111",
//                "01",
//                "0011101",
//                "1101010001",
                "0111000100010"
        };
        for(String testData : testSet){
            System.out.println(testData +" => "+ Arrays.toString(flip(testData)));
        }
    }

    public static int[] flip(String A) {
        int p = 0;
        int[] pfSumArr = new int[A.length()];
        int count1 = 0;
        int[] result = {-1,-1};
        int i = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxInd = 0;

        for(char c : A.toCharArray()){
            if(c == '1'){
                count1++;
                p = Math.max(0,p-1);
            }else{
                p +=1;
            }
            pfSumArr[i] = p;

            if(maxSum < p){
                maxSum = p;
                maxInd = i;
            }

            i++;
        }



        if(count1 == A.length()){
            return new int[]{};
        }

        result[1] = maxInd;

        for(int j = 0;j<maxInd;j++){
            if(pfSumArr[j] > 0){
                result[0] = j;
                result[0]++;
                result[1]++;
                return result;
            }
        }

        result[0] = 1;
        result[1]++;
        return result;
    }
}
