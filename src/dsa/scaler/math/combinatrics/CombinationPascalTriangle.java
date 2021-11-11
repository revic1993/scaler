package dsa.scaler.math.combinatrics;

import java.util.Arrays;

public class CombinationPascalTriangle {

    public static void main(String[] args) {
        int[][] testSet = {
//                {5,2,13},
//                {6,2,13},
                {7821,4259,292343}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" -> "+solve(testData[0],testData[1],testData[2]));
        }
    }

    public static int solve(int A, int B, int C) {
        int[][] pTriangle = new int[2][B+1];

        pTriangle[0][0] = 1;
        pTriangle[0][1] = 1;

        for(int i=2;i<=A;i++){
            for(int j=0;j<=B;j++){
                if(j==0){
                    pTriangle[1][j] = 1;
                }else{
                    pTriangle[1][j] = (pTriangle[0][j-1]%C+pTriangle[0][j]%C)%C;
                }
            }
            pTriangle[0] = pTriangle[1].clone();
        }

        return pTriangle[1][B];
    }
}
