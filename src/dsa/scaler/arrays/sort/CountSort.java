package dsa.scaler.arrays.sort;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[][] testSet = new int[][]{
            {1,0,0,0},
            {0,0,0,1},
            {1,2,2,2},
            {2,2,2,2},
            {1,2,0,0,1},
            {1,2,0}
        };

        CountSort cs = new CountSort();

        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) +" sorted : "+Arrays.toString(cs.sortColors(testData)));
        }
    }

    public int[] sortColors(int[] A) {
        int count0=0;
        int count1=0;

        for(int a : A){
            if(a == 0){
                count0++;
            }else if(a == 1){
                count1++;
            }
        }

        for(int i=0;i<A.length;i++){
            if(count0 != 0){
                A[i] = 0;
                count0--;
            }else if(count1 != 0){
                A[i] = 1;
                count1--;
            }else{
                A[i] = 2;
            }
        }
        return A;
    }
}
