package dsa.scaler.math;

import java.util.Arrays;

public class DivideIntegers {
    public static void main(String[] args) {
        int[][] testSet = {
                {-2147483648,-10000000}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) +" => "+divide(testData[0],testData[1]));
        }
    }

    public static int divide(int A,int B){
        if(B == 1){
            return A;
        }

        if(B == -1){
            return A == Integer.MIN_VALUE ? Integer.MAX_VALUE : -1*A;
        }

        boolean isNeg = false;
        if(A < 0 && B>0 || B<0 && A>0){
            isNeg = true;
        }

        A = A == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(A);
        B = Math.abs(B);

        while(A > B){
            A-=B;
        }

        if(isNeg){
            return A*-1;
        }
        return A;
    }
}
