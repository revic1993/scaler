package dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class DistinctElementsInWindow {


    public static void main(String[] args) {
        int testSet[][][] = new int[][][]{
                {{3},{1,2,1,3,4,3}},
                {{1},{1,1,1,2}},
                {{3},{4,1,3,1,2,5,6,7}},
                {{5},{98, 83, 98, 83, 98, 98, 59, 80, 16, 59, 59, 59 }}
        };
        DistinctElementsInWindow deiw = new DistinctElementsInWindow();
        for(int i=0;i<testSet.length;i++){
            int[][] testData = testSet[i];
            System.out.println(Arrays.toString(testData[1])+" has distinct num array "+Arrays.toString(deiw.dNums(testData[1],testData[0][0])));
        }
    }

    public int[] dNums(int[] A, int B) {
        int[] distinctNums = new int[A.length-B+1];

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<B;i++){
            int currentFreq = freqMap.getOrDefault(A[i],0);
            freqMap.put(A[i],++currentFreq);
        }
        if(B == 1){
            for(int i=0;i<distinctNums.length;i++){
                distinctNums[i] = 1;
            }
            return distinctNums;
        }

        distinctNums[0] = freqMap.size();

        for(int i=1;i<distinctNums.length;i++ ){
            distinctNums[i] = distinctNums[i-1];
            int removedFreq = freqMap.get(A[i-1])-1;
            freqMap.put(A[i-1],removedFreq);

            if(removedFreq == 0){
                distinctNums[i]--;
            }

            int addedFreq = freqMap.getOrDefault(A[i+B-1],0)+1;
            freqMap.put(A[i+B-1],addedFreq);

            if(addedFreq == 1){
                distinctNums[i]++;
            }
        }
        return distinctNums;
    }

}
