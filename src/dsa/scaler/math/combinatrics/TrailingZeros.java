package dsa.scaler.math.combinatrics;

public class TrailingZeros {
    public static void main(String[] args) {
        int[] testSet = {5,6,28,42,25,128,125,1000};
        for(int testData : testSet){
            System.out.println(testData+" => "+trailingZeroes(testData));
        }
    }
    public static int trailingZeroes(int A) {
        // int[] pow = [
        //                 5,25,125,
        //                 625,3125,15625,
        //                 78125,390625,1953125,
        //                 9765625,48828125,244140625
        //             ];

        int counter = 0;
        while(A > 0){
            A = (int) Math.floor(A/5);
            counter+=A;
        }
        return counter;
    }
}
