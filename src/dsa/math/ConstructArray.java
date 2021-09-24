package dsa.math;

import java.util.Arrays;

public class ConstructArray {
    public static void main(String[] args) {
        int[][] testSet = {
                {3,20,30},
                {4,20,30},
                {5,20,30},
                {6,20,30},
                {7,20,30},
                {15,20,30},
                {16,20,30},
                {3,7,13},
                {4,7,13},
                {5,7,13},
                {6,7,13},
                {7,7,13},
                {8,7,13},
                {10,7,13},
                {3,10,39}
        };
        for(int[] testData : testSet){
            System.out.println("constructed array for "+Arrays.toString(testData)+" is "+ Arrays.toString(solve(testData[0],testData[1],testData[2])));
        }
    }

    public static int[] solve(final int A, final int B, final int C) {
        if(A == 2){
            return new int[]{B,C};
        }
        int[] result = new int[A];
        int gap = C-B;
        int currentFactor = gap;

        while((C-(currentFactor*(A-1)))<=0 && currentFactor>1){
            currentFactor--;
            while(gap % currentFactor!=0){
                currentFactor--;
            }
        }

        result[0] = C-(currentFactor * (A-1));
        if(currentFactor == 1 && result[0]  > B){
            result[0] = B;
            currentFactor = gap;
        }

        for(int i=1;i<result.length;i++){
            result[i] = result[i-1]+currentFactor;
        }
        return result;
    }
}
