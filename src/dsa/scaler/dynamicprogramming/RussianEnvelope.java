package dsa.scaler.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianEnvelope{

    public static void main(String[] args) {

    }

    public int solve(int[][] A) {
        Arrays.sort(A, Comparator.comparingInt(o -> o[1]));

        return 0;
    }
}
