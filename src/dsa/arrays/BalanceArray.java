package dsa.arrays;

import java.util.Arrays;

public class BalanceArray {

    public static void main(String[] args) {
        int[][] testSet = new int[][]{
//                {2,1,6,4},
                {5,5,2,5,8,0},
//                {0,1},
//                {0,0},
//                {1,0},
//                {1,1},
//                {1},
                //                {0},
                {1,2,3,4,5,6,7,8,9},
                {1,1,1}
        };

        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData)+" has "+solve(testData)+" special elements");
        }
    }

    public static int solve(int[] A){
        if(A.length == 1) return 1;
        if(A.length == 2) return (int) Arrays.stream(A).filter(val -> val==0).count();

        int[] contiguousSumArr = new int[A.length];
        contiguousSumArr[0] = A[0];
        contiguousSumArr[1] = A[1];

        for(int i=2;i<A.length;i++){
            contiguousSumArr[i] = A[i]+contiguousSumArr[i-2];
        }

        int maxOI = 0, maxEI = 0;
        if((contiguousSumArr.length & 1) == 0){
            maxOI = contiguousSumArr.length - 2;
            maxEI = contiguousSumArr.length - 1;
        }else{
            maxOI = contiguousSumArr.length - 1;
            maxEI = contiguousSumArr.length - 2;
        }

        int count=0;
        for(int i=0;i<A.length;i++){
            if(i == contiguousSumArr.length-1){
                if(contiguousSumArr[i-1] == contiguousSumArr[i-2]){
                    System.out.println("Special element found "+ A[i]);
                    count++;
                }
                continue;
            }
            if(i == contiguousSumArr.length-2){
                if(contiguousSumArr[i-1] == (contiguousSumArr[i+1] - contiguousSumArr[i-1])){
                    System.out.println("Special element found "+ A[i]);
                    count++;
                }
                continue;
            }

            int beforeTwo = i < 2 ? 0 : contiguousSumArr[i-2];
            int beforeOne = i < 1 ? 0 : contiguousSumArr[i-1];
            int oddDiff = 0, evenDiff = 0;

            if( (i & 1) == 0){
                oddDiff =  contiguousSumArr[i+1] - (beforeTwo+A[i+1]);
                evenDiff = contiguousSumArr[i+2] - (beforeOne+A[i+2]);
            }else{
                evenDiff =  contiguousSumArr[i+1] - (beforeTwo+A[i+1]);
                oddDiff = contiguousSumArr[i+2] - (beforeOne+A[i+2]);
            }

            int maxEven = contiguousSumArr[maxEI] - oddDiff;
            int maxOdd = contiguousSumArr[maxOI] - evenDiff;
            if(maxEven == maxOdd){
                System.out.println("Special element found "+ A[i] + " index: "+i);
                count++;
            }
        }

        return count;
    }
}
