package dsa.scaler.arrays;

import java.util.Arrays;

public class MaxAbsolute {

    public static void main(String[] args) {
        int[][] testSet = {
                {1, 3, -1},
                {1, 4, -2, 3, -1},
                {2}
        };
        for (int[] testData: testSet) {
            System.out.println("Max absolute difference for "+Arrays.toString(testData) +" is : "+solve(testData));
        }
    }
    public static int solve(int[] A){
        int xMax = Integer.MIN_VALUE; //A[i] + i
        int yMax = Integer.MIN_VALUE; // A[i] - i
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            int xVal = A[i] + i;
            int yVal = A[i] - i;
            if(xVal > xMax){
                xMax = xVal;
            }

            if(xVal < xMin){
                xMin = xVal;
            }

            if(yVal > yMax){
                yMax = yVal;
            }

            if(yVal < yMin){
                yMin = yVal;
            }
        }

        return Math.max(xMax-xMin,yMax-yMin);
    }

}
