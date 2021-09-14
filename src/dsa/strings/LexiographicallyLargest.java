package dsa.strings;

import java.util.Arrays;
import java.util.Collections;

public class LexiographicallyLargest {

    public static void main(String[] args) {
        String testSet[] = {
            "abb_c",
            "acc_dc",
            "abb_cc",
            "abb_ccc"
        };
        LexiographicallyLargest ll = new LexiographicallyLargest();
        for(String testData : testSet){
            System.out.println("String "+testData+" can be converted to "+ll.getLargest(testData));
        }
    }

    public String getLargest(String A) {
        String[] data = A.split("_");
        char[] charArr = data[1].toCharArray();
        char[] originalArr = data[0].toCharArray();
        Arrays.sort(charArr);

        int j = charArr.length-1;
        for(int i=0;i<originalArr.length;i++){
            if(j < 0){
                break;
            }
            if(originalArr[i] < charArr[j]){
                originalArr[i] = charArr[j];
                j--;
            }
        }
        return String.valueOf(originalArr);
    }
}
