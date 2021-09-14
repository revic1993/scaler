package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinMod {
    public static void main(String args[]){
        ArrayList<Integer> testData = new ArrayList<>(Arrays.asList(1,2,4));
        System.out.println(minMod(testData));
    }

    public static int minMod(ArrayList<Integer> A){
        if(A.size() == 1) return 0;
        int max = A.get(0);
        int secondMax = A.get(1);
        for(int num : A){
            if(max < num){
                secondMax = max;
                max = num;
            }else if(secondMax < num && num < max){
                secondMax = num;
            }
        }
        return secondMax % max;
    }
}
