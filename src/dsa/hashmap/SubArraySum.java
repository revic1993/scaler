package dsa.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArraySum {

    public static void main(String[] A){
        int[][] testSet = new int[][]{
                /*{1,2,3,4},
                {0,1,2,3},
                {1,3,0,2},
                {1,2,-3,0},
                {3,2,-1,-4},
                {3,2,-20,-22,50,-13},*/
                { 96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62 }
        };
        SubArraySum sas = new SubArraySum();
        for (int[] testCase: testSet) {
            System.out.println(Arrays.toString(testCase) +" has subarray with sum 0 "+ (sas.solve(testCase) == 1 ? " : true" : " : false"));
        }
    }

    public int solve(int[] A) {
        HashSet<Integer> existingSum = new HashSet<>();
        for(int i=1;i<A.length;i++){
            if(A[i] == 0 || A[i-1] == 0){
                return 1;
            }

            A[i] += A[i-1];

            if(A[i] == 0 || existingSum.contains(A[i])){
                return 1;
            }

            existingSum.add(A[i]);
        }
        return -1;
    }
}
