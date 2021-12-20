package dsa.scaler.arrays.sort;

import java.util.Arrays;

public class Wave {
    public static void main(String[] args) {
        Wave wave = new Wave();
        System.out.println(Arrays.toString(wave.wave(new int[]{5, 1, 3, 2, 4})));
    }
    public int[] wave(int[] A) {
        int[] result = new int[A.length];
        Arrays.sort(A);
        //1,2,3,4,5
        for(int i=0;i<A.length;i++){
            if((i & 1) == 0){
                continue;
            }
            int temp = A[i];
            A[i]=A[i-1];
            A[i-1] = temp;

        }
        return A;
    }
}
