package dsa.scaler.math.prime;

public class OddFibonacci {
    public static void main(String[] args) {
        int[][] testSet = {
//                {2,6},
                {11, 15},
//                {6,20},
//                {30,36},
//                {11,15}
        };
        for (int[] testData : testSet){
            System.out.println("Total odd fib numbers between "+testData[0] + " and "+testData[1] +" are "+solve(testData[0],testData[1]));
        }
    }

    public static int solve(int A, int B) {
        int oddTillA = A - (int)Math.floor(A/3);
        int oddTillB = B - (int)Math.floor(B/3);
        return oddTillB - oddTillA + A % 3 != 0 ? 1: 0;
    }
}
