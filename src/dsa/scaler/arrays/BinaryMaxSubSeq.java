package dsa.scaler.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryMaxSubSeq {
    public static void main(String[] args) {
        int[][] testSet = {
//                {1,0,1,0,1},
//                {1,1,1,1,1},
//                {0,0,0,0,0},
//                {1},
//                {0},
                {0,1,1,0,0,1,1},
                {1,0,1,1,0,1,1,1}
        };

        for (int[] testData: testSet) {
            System.out.println("Max length of subsequence for "+ Arrays.toString(testData)+" is "+solve(testData));
        }
    }

    public static int solve(int[] A) {
        if(A.length == 1){
            return 0;
        }
        HashMap<Integer,Integer> firstIndexMap = new HashMap<>();
        int sumTill = 0;
        int maxSubSeq = 0;
        for(int i=0;i<A.length;i++){
            sumTill+= A[i] == 0 ? -1 : 1;
            if(!firstIndexMap.containsKey(sumTill)){
                firstIndexMap.put(sumTill,i);
            }
            maxSubSeq = Math.max(maxSubSeq,sumTill == 0 ? i+1 : i-firstIndexMap.get(sumTill));
        }
        return maxSubSeq;
    }
}
