package dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DuplicateRowsBinary {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[][]{
                {1,1,0,0},
                {0,0,0,1},
                {1,1,0,0},
                {0,0,0,1}
        })));
    }
    public static int[] solve(int[][] A) {
        HashSet<Integer> numberSet = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<A.length;i++){
            int sum = 0;
            for(int j=A[0].length-1;j>=0;j--){
                int multiplier = 1 << (A[0].length-1-j);
                sum+=A[i][j]*multiplier;
            }
            if(numberSet.contains(sum)){
                result.add(i+1);
            }
            numberSet.add(sum);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
