package dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
* SRC : https://www.scaler.com/academy/mentee-dashboard/classroom/multidimensional-arrays-c25633a4-d486-4265-bf0c-5e2d262589b0/#assignment%2F329
* */
public class RotateMatrix {

    public static void main(String[] args) {
        ArrayList<TestData> testSet =  new ArrayList<>();
//        testSet.add(new TestData(1));
//        testSet.add(new TestData(2));
        testSet.add(new TestData(3));
        testSet.add(new TestData(4));

        for(TestData testData : testSet){
            System.out.println(" Matrix \n ========= \n"+ testData);
            solve(testData.A);
            System.out.println("Rotated is \n ========= \n"+testData);
        }
    }

    public static void solve(int[][] A) {
        if(A.length <=1){
            return;
        }

        int     rowStart = 0,
                colStart = 0,
                rowEnd = A.length-1,
                colEnd = A.length -1;

        while(rowStart < rowEnd && colStart < colEnd){
            int length = colEnd - colStart;
            for(int i=0;i<length;i++){
                int temp = A[rowStart+i][colEnd];
                A[rowStart+i][colEnd] = A[rowStart][colStart+i];
                A[rowStart][colStart+i] = temp;

                temp = A[rowEnd][colEnd-i];
                A[rowEnd][colEnd-i] = A[rowStart][colStart+i];
                A[rowStart][colStart+i] = temp;

                temp = A[rowEnd-i][colStart];
                A[rowEnd-i][colStart] = A[rowStart][colStart+i];
                A[rowStart][colStart+i] = temp;
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
    }

    static class TestData{
        int[][] A;
        TestData(int N){
            int k = 1;
            this.A = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j = 0;j<N;j++){
                    this.A[i][j] = k;
                    k++;
                }
            }
        }

        @Override
        public String toString() {
            return Arrays.deepToString(A);
        }
    }
}
