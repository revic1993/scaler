package dsa.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        ArrayList<TestData> testSet = new ArrayList<>();
        testSet.add(new TestData(3,new int[]{2, 6, 3, 9, 8}));
        testSet.add(new TestData(1,new int[]{4, 6, 3, 1, 4}));
        testSet.add(new TestData(2,new int[]{1,2}));
        testSet.add(new TestData(9,new int[]{ 2, 8, 3, 7, 8, 7, 9 }));
        MinimumDifference md = new MinimumDifference();
        for(TestData testData : testSet){
            System.out.println(testData.toString() +" has "+md.solve(testData.getA(),testData.getB()));
        }
    }

    public int solve(int[] A,int B){
        int min = A[0];
        int max = A[0];

        for(int a : A){
            if(min > a){
                min = a;
            }
            if(max < a){
                max = a;
            }
        }

        int[] numFreq = new int[max + 1]; // [1,1,2,3,3,5] [0,2,1,2,1,0]
        Arrays.fill(numFreq, 0);

        for (int i = 0; i < A.length; i++) {
            numFreq[A[i]]++;
        }
        int k = B;
        while(min < max){
            int minFreq = numFreq[min];
            int maxFreq = numFreq[max];

            if(minFreq < maxFreq){
                if(minFreq <= k){
                    numFreq[min+1] = numFreq[min+1] + numFreq[min];
                    k-=minFreq;
                    min++;
                }else{
                    break;
                }
            }else{
                if(maxFreq <= k){
                    numFreq[max-1] = numFreq[max-1] + numFreq[max];
                    k-=maxFreq;
                    max--;
                }else{
                    break;
                }
            }
        }
        return Math.abs(max - min);
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
