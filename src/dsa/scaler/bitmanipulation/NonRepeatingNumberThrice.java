package dsa.scaler.bitmanipulation;

import java.util.Arrays;
import java.util.function.ObjIntConsumer;

public class NonRepeatingNumberThrice {
    public static void main(String[] args) {
        int[][] testSet = {
                {1, 2, 4, 3, 3, 2, 2, 3, 1, 1}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " => "+singleNumber(testData));
        }
    }

    public static int singleNumber(final int[] A) {
        int result = 0;
        char[] bits = new char[32];
        int counter = 1;

        for(int i=0;i<32;i++){
            int count_one = 0;
            for(int j=0;j<A.length;j++){
                if((counter & A[j]) == counter){
                    count_one++;
                }
            }
            counter = counter << 1;
            bits[31-i] = ((count_one-1)%3==0) ? '1' : '0';
        }

        return Integer.parseInt(String.valueOf(bits),2);
    }
}
