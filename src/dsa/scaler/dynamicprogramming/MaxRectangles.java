package dsa.scaler.dynamicprogramming;

import java.util.ArrayList;

public class MaxRectangles {
    public static void main(String[] args) {
//        int[][] data = new int[][]{
//            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
//            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
//            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
//            {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
//            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
//            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
//        };
//        int[][] data = {
//                {1,1,1,1},
//                {1,1,1,1},
//                {1,1,1,1},
//                {1,1,0,1}
//        };
        int[][] data = {
                {0,1},
                {1,0}
        };
        MaxRectangles mr = new MaxRectangles();
        System.out.println(mr.maximalRectangle(data));
    }

    public int maximalRectangle(int[][] A) {
        int max = Integer.MIN_VALUE;
        int N = A.length-1;
        int M = A[0].length-1;


        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(A[i][j] == 0 ){
                    continue;
                }

                A[i][j] = A[i][j] + (j == 0 ? 0 : A[i][j-1]);
                max = Math.max(A[i][j],max);
                if(i == 0){
                    continue;
                }
                int k = i-1;
                int minWidth = A[i][j];
                while(k >= 0 && A[k][j]!=0){
                    minWidth = Math.min(minWidth,A[k][j]);
                    int height = i+1-k;
                    max = Math.max(max,height*minWidth);
                    k--;
                }
            }
        }

        return Math.max(max,0);
    }


}
