package dsa.scaler.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
* Source : https://www.scaler.com/academy/mentee-dashboard/classroom/multidimensional-arrays-c25633a4-d486-4265-bf0c-5e2d262589b0/#assignment%2F329
* */
public class FlipBits {
    public static void main(String[] args) {
        String[] testSet = {
//                "010",
                "111",
                "01",
                "0011101",
                "1101010001",
                "0111000100010"
        };
        FlipBits fb = new FlipBits();
        for(String testData : testSet){
            System.out.println(testData +" => "+ fb.flip(testData));
        }
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        int prefix = 0;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> prefixArr = new ArrayList<>();
        int leastMaxPosition = -1;
        for(int i=0;i<A.length();i++){
            char a = A.charAt(i);
            if(a == '0'){
                if(prefix < 0){
                    prefix = 0;
                }
                prefixArr.add(++prefix);
                if(max < prefix){
                    leastMaxPosition = i;
                    max = prefix;
                }
            }else{
                prefix--;
                prefixArr.add(prefix);
            }
        }
        result.set(1,leastMaxPosition+1);

        if(max == Integer.MIN_VALUE){
            return new ArrayList<>();
        }
        int i=leastMaxPosition;
        while(i > 0 && prefixArr.get(i)>=0){
            i--;
        }
        if(prefixArr.get(i) < 0){
            i++;
        }
        result.set(0,i+1);
        return result;
    }
}
