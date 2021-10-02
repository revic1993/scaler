package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSmallestElement {


    public static void main(String[] A){
        ArrayList<TestData> testSet = new ArrayList<>();
//        testSet.add(new TestData(3,new int[]{2,1,4,3,2}));
//        testSet.add(new TestData(2,new int[]{2,1}));
        testSet.add(new TestData(3,new int[]{2,1,4,3,2}));
//        testSet.add(new TestData(5,new int[]{2,1,4,3,2}));
//        testSet.add(new TestData(1,new int[]{2,1,4,3,2}));
//        testSet.add(new TestData(1,new int[]{1,1,1,1}));
//        testSet.add(new TestData(2,new int[]{1,2,1,1}));
//        testSet.add(new TestData(3,new int[]{1,1,1,1}));
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        for(TestData testData : testSet){
            System.out.println(testData.toString() +" has "+kthSmallestElement.solve(testData.getA(),testData.getB()));
        }
    }

    public int solve(final int[] A, int B){

        for(int i=0;i<B;i++){
            int minIndex = i;

            for(int j=i+1; j<A.length;j++){
                if(A[minIndex] > A[j]){
                    minIndex = j;
                }
            }

            if(i != minIndex){
                int temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }

        return A[B-1];
    }

    private static class TestData{
        private int B;
        private int[] A;

        TestData(int B, int[] A){
            this.B = B;
            this.A = A;
        }

        public int getB(){
            return this.B;
        }

        public int[] getA(){
            return this.A;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "B=" + B +
                    ", A=" + Arrays.toString(A) +
                    '}';
        }
    }
}
