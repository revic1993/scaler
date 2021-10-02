package dsa.scaler.arrays.sort;

import java.util.Arrays;

public class StepWiseSelectionSort {

    public static void main(String[] args) {

        int[][] testSet = new int[][]{
                {6, 4, 3, 7, 2, 8},
                {5,4,3,2,1},
                {1,2},
                {2,1}
        };
        StepWiseSelectionSort sws = new StepWiseSelectionSort();
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+ " has result : " +Arrays.toString(sws.solve(testData)));
        }
    }

    public int[] solve(int[] A) {
        int[] result = new int[A.length-1];

        for(int i=0;i<A.length-1;i++){
            int min = i;
            for(int j=i+1;j<A.length;j++){
                if(A[min] > A[j]){
                    min = j;
                }
            }
            if(min != i){
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }

            result[i] = min;
        }
        return result;
    }
}
