package dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[][] testSet = {
                {1,2,3},
                {9,9,9},
                {1,2,4,9},
                {1,9,1,9},
                {0,0,0,0},
                {0,1,2,3}
        };
        for(int[] testData : testSet){
            System.out.println("Adding one to "+ Arrays.toString(testData) +" results in "+Arrays.toString(plusOne(testData)));
        }
    }

    public static int[] plusOne(int[] A) {
      int carry = 1;
      for(int i=A.length-1;i>=0;i--){
          if(carry==0){
              break;
          }
          int currentSum = A[i]+carry;
          A[i] = currentSum%10;
          carry = (int) Math.floor(currentSum/10);
      }

      if(carry == 0){
          int j=0;
          while(A[j] == 0){
              j++;
          }
          ArrayList<Integer> res = new ArrayList<>();
          while(j < A.length){
              res.add(A[j]);
              j++;
          }
          return res.stream().mapToInt(Integer::intValue).toArray();
      }
      int[] result = new int[A.length+1];
      result[0] = carry;
      for(int i=1;i<result.length;i++){
          result[i] = A[i-1];
      }
      return result;
    }
}
