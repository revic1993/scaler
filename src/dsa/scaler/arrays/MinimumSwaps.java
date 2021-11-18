package dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwaps {
    public static void main(String[] args) {
        int[][][] testSet = {
                {{1, 12, 10, 3, 14, 10, 5},{8}},
                {{5, 17, 100, 11},{20}},
                {{1,3,3,3,1,1,3,3,3,3,3,3,1,1,1,3},{2}}
        };

        for(int[][] testData : testSet){
//            solve(testData[0],testData[1][0]);
            System.out.println("A = "+Arrays.toString(testData[0])+" B = "+testData[1][0]+" => "+solve(testData[0],testData[1][0]));
        }
    }

    public static int solve(int[] A, int B) {
        int totalOne = 0;

        for(int a : A){
            if(a > B){
                continue;
            }
            totalOne++;
        }

        if(totalOne <=1){
            return 0;
        }

        int left = 0;
        int right =0;
        int totalSwapsInterval = 0;
        while(right < A.length && right<totalOne){
            if(A[right] > B){
                totalSwapsInterval++;
            }
            right++;
        }
        int totalSwaps = totalSwapsInterval;
        left++;
        while(right < A.length){
            if(A[left-1] > B){
                totalSwapsInterval--;
            }
            if(A[right] > B){
                totalSwapsInterval++;
            }
            left++;
            right++;
            totalSwaps = Math.min(totalSwaps,totalSwapsInterval);
        }
        return totalSwaps;
    }
}
