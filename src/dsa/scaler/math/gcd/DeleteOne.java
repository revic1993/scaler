package dsa.scaler.math.gcd;

import java.util.Arrays;

/**
 * src : https://www.scaler.com/academy/mentee-dashboard/class/12420/assignment/problems/9103
 */
public class DeleteOne {
    public static void main(String[] args) {
        int[][] testSet = {
                {3, 9, 6, 8, 3}
        };
        for (int testData[] : testSet){
            System.out.println("Max GCD after deleting a number for "+ Arrays.toString(testData) + " is "+solve(testData));
        }
    }

    public static int solve(int[] A){
        int[] prefixGCD = new int[A.length];
        prefixGCD[0] = A[0];
        int[] suffixGCD = new int[A.length];
        suffixGCD[A.length-1] = A[A.length-1];

        for(int i = 1, j = A.length-2; i<A.length && j>=0;i++,j--){
            prefixGCD[i] = findGCD(prefixGCD[i-1],A[i]);
            suffixGCD[j] = findGCD(suffixGCD[j+1],A[j]);
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(i == 0){
                result = Math.max(result,suffixGCD[i+1]);
            }else if(i==A.length-1){
                result = Math.max(result,prefixGCD[i-1]);
            }else{
                result = Math.max(result,findGCD(prefixGCD[i-1],suffixGCD[i+1]));
            }
        }
        return result;
    }

    static int findGCD(int A, int B){
        if(A==0 || B==0){
            return A == 0 ? B : A;
        }

        if(A==1 || B==1){
            return 1;
        }

        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }

        while(A > 0){
            int t = B%A;
            B = A;
            A = t;
        }

        return A == 0 ? B : A;
    }
}
