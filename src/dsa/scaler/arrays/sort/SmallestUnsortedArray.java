package dsa.scaler.arrays.sort;

import java.util.Arrays;

public class SmallestUnsortedArray {
    public static void main(String[] args) {

    }

    public static int[] subUnsort(int[] A) {
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        int start = 0;
        int end = A.length-1;

        while(start < A.length){
          if(sorted[start] == A[start]){
              start++;
          }else{
              break;
          }
        }

        while(end >= 0){
            if(sorted[end] == A[end]){
                end--;
            }else{
                break;
            }
        }

        if(end == -1 || start == A.length){
            return new int[]{-1};
        }

        return new int[]{start,end};
    }
}
