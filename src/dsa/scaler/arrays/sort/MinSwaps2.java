package dsa.scaler.arrays.sort;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwaps2 {
    public static void main(String[] args) {
        int[][] testSet = {
                {1,2,3,4,0},
                {2,0,1,3},
                {6, 50, 16, 30, 37, 12, 43, 52, 24, 2, 53, 28, 31, 36, 10, 32, 51, 60, 64, 38, 3, 46, 7, 4, 55, 72, 75, 66, 73, 68, 54, 22, 25, 65, 5, 49, 0, 8, 47, 78, 35, 57, 83, 90, 27, 9, 19, 26, 76, 41, 39, 40, 1, 11, 67, 61, 71, 56, 58, 108, 110, 102, 15, 70, 59, 14, 42, 23, 29, 20, 118, 13, 106, 17, 69, 18, 21, 34, 44, 62, 33, 80, 45, 87, 48, 63, 74, 131, 134, 111, 77, 79, 81, 139, 132, 124, 82, 84, 85, 86, 88, 89, 91, 92, 93, 130, 94, 98, 95, 96, 151, 97, 99, 100, 109, 101, 142, 103, 143, 104, 105, 146, 107, 112, 113, 138, 114, 115, 116, 117, 160, 119, 120, 148, 145, 121, 122, 123, 125, 126, 127, 135, 128, 153, 129, 133, 144, 136, 137, 140, 141, 147, 149, 150, 152, 154, 155, 156, 157, 158, 159}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" => " + solve(testData));
        }
    }

    public static int solve(int[] A) {
        int swaps = 0;
        int[] sortedArray = A.clone();

        Arrays.sort(sortedArray);
        HashMap<Integer,Integer> indexMap = new HashMap<>();

        for(int i=0;i<A.length;i++){
            indexMap.put(A[i],i);
        }
        for(int i=0;i<A.length;i++){
            if(A[i] != sortedArray[i]){
                int index = indexMap.get(sortedArray[i]);
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                indexMap.put(sortedArray[i],i);
                indexMap.put(temp,index);
                swaps++;

            }
        }
        return swaps;
    }
}
