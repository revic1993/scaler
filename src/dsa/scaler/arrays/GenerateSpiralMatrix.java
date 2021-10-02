package dsa.scaler.arrays;

import java.util.Arrays;

public class GenerateSpiralMatrix {

    public static void main(String[] args) {
        int[][] spiralMatrix = generateMatrix(4);
        for (int[] a: spiralMatrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] generateMatrix(int A){
        int[][] spiralMatrix = new int[A][A];
        int counter = 1;
        int rowStart = 0, rowEnd = A-1, colStart = 0,colEnd = A-1;
        while(colStart < colEnd && rowStart < rowEnd){
            for(int i=colStart;i<=colEnd;i++){
                spiralMatrix[rowStart][i] = counter++;
            }
            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++){
                spiralMatrix[i][colEnd] = counter++;
            }
            colEnd--;

            for(int i=colEnd;i>=colStart;i--){
                spiralMatrix[rowEnd][i] = counter++;
            }
            rowEnd--;

            for(int i=rowEnd;i>=rowStart;i--){
                spiralMatrix[i][colStart] = counter++;
            }
            colStart++;
        }

        spiralMatrix[colStart][colStart] = ((A & 1) == 0) ? counter-2 : counter;
        return spiralMatrix;
    }
}
