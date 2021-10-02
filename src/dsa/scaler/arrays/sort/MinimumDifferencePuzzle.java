package dsa.scaler.arrays.sort;


import java.util.Arrays;

public class MinimumDifferencePuzzle {
    public static void main(String[] args) {
        TestData[] testSet = new TestData[]{
                new TestData(new int[]{10, 12, 10, 7, 5, 22},4),
                new TestData(new int[]{1,2,3,4,5,6,7},3),
                new TestData(new int[]{5,4,3,2,1},2),
                new TestData(new int[]{5,1,3,5,3,2},3),
                new TestData(new int[]{1,1,1,1},1)
        };
        MinimumDifferencePuzzle mdp = new MinimumDifferencePuzzle();

        for (TestData testData: testSet) {
            System.out.println(testData.toString() +" has minimum difference of "+mdp.solve(testData.A,testData.B));
        }
    }

    public int solve(int[] A, int B) {
        if(B == 1){
            return 0;
        }

        Arrays.sort(A);//10, 12, 10, 7, 5, 22 => 5,7,10,10,12,22 , B = 4, N=5
        int min = Integer.MAX_VALUE;

        for(int i=0;i<A.length-B+1;i++){
            if(A[i+B-1] - A[i] < min){
                min = A[i+B-1] - A[i];
            }
        }
        return min;
    }



    protected static class TestData{
        private int[] A;
        private int B;

        public TestData(int[] A,int B){
            this.A = A;
            this.B = B;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "A=" + Arrays.toString(A) +
                    ", B=" + B +
                    '}';
        }
    }
}
