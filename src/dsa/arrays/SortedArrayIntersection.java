package dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArrayIntersection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(
                new int[]{1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101 },
                new int[]{ 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98})));
    }

    public static int[] intersect(final int[] A, final int[] B) {
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i < A.length && j<B.length){
            if(A[i] == B[j]){
                result.add(A[i]);
                i++;
                j++;
                continue;
            }
            if(A[i] > B[j]){
                j++;
            }else{
                i++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
