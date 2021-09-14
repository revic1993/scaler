package dsa.arrays.sort;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        int[][] testSet = new int[][]{
                {1,3,3,2},
                {1,1,1},
                {1},
                {2,1},
                {2,0,3,3,4,5},
                {-4, -2, 0, -1, -6 }
        };
        NobleInteger nobleInteger = new NobleInteger();
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) +" has noble integer : "+nobleInteger.solve(testData));
        }
    }

    public int solve(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i++){
            if(A[i] == A.length - (i+1) && (i==0 || A[i+1]!=A[i])){
                return 1;
            }
        }
        return A[A.length-1] == 0 ? 1 : -1;
    }
}
