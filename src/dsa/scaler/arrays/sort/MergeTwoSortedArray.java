package dsa.scaler.arrays.sort;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[][][] testSet = {
//                {{4,7,9},{2,11,19}},
                {{4,5,6},{4,5,6}},
                {{1,1,1},{1,1,1}},
        };
        /*for (int[][]testData: testSet) {
            System.out.println("Array 1 "+ Arrays.toString(testData[0])+" Array 2 "+Arrays.toString(testData[1])+" merged "+Arrays.toString(solve(testData[0],testData[1])));
        }*/
        MergeTwoSortedArray mtwa = new MergeTwoSortedArray();
        System.out.println("Array 1 "+ Arrays.toString(new int[]{1,2,3})+" Array 2 "+Arrays.toString(new int[]{4,5,6})+" merged "+Arrays.toString(mtwa.solve(new int[]{4,5,6},new int[]{4,5,6})));
    }
    public int[] solve(final int[] A, final int[] B) {
        int[] result = new int[A.length+B.length];
        int i=0,j=0;
        for(int r=0;r<result.length;r++){
            if(j < B.length && i < A.length){
                if(A[i] < B[j]){
                    result[r] = A[i];
                    i++;
                }else if(A[i] > B[j]){
                    result[r] = B[j];
                    j++;
                }
                continue;
            }

            if( j < B.length){
                while(j < B.length){
                    result[r] = B[j];
                    j++;
                    r++;
                }
                continue;
            }

            while(i < A.length){
                result[r] = A[i];
                i++;
                r++;
            }

        }

        return result;
    }
}
