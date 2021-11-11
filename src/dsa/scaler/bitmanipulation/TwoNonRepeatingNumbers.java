package dsa.scaler.bitmanipulation;

import java.util.Arrays;

public class TwoNonRepeatingNumbers {
    public static void main(String[] args) {
        int[][] testSet = {
//                {1, 2, 3, 1, 2, 4},
                {408, 478, 74, 624, 74, 204, 705, 624, 337, 408, 478, 204 }
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) +" => "+Arrays.toString(solve(testData)));
        }
    }

    public static int[] solve(int[] A) {
        int x = A[0];
        for(int i=1;i<A.length;i++){
            x = x ^ A[i];
        }

        int i = 1;
        int counter = 1;

        while( (i & x) != i){
            i = i << 1;
            counter++;
        }

        int first = -1;
        int second = -1;
        for(int j=0;j<A.length;j++){
            if((i & A[j]) == i){
                if(first == -1){
                    first = A[j];
                    continue;
                }
                first = first ^ A[j];
                continue;
            }

            if(second == -1){
                second = A[j];
                continue;
            }

            second = second ^ A[j];
        }
        return new int[]{first,second};
    }
}
