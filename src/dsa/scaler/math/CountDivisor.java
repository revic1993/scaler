package dsa.scaler.math;

import java.util.Arrays;
import java.util.HashMap;

public class CountDivisor {
    public static void main(String[] args) {
        int[][] testSet = {
//                {2, 3, 4, 5},
                {8, 9, 10}
        };
        for(int[] testData : testSet){
            System.out.println("Testdata : "+Arrays.toString(testData) + " has factors "+Arrays.toString(solve(testData)));
        }
    }

    public static int[] solve(int[] A){
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> divisorCount = new HashMap<>();

        for(int a : A){
            max = Math.max(max,a);
            divisorCount.put(a,1);
        }

        for(int i=2;i<=max;i++){
            for(int j=i;j<=max;j+=i){
                if(divisorCount.containsKey(j)){
                    divisorCount.put(j,divisorCount.get(j)+1);
                }
            }
        }

        /*
        * 2 -> 2,4,6,8,10
        * 3 -> 3,6,9
        * 4 -> 4,8
        * 5 -> 5,10,
        * 6 -> 6
        * 7 -> 7
        * 8 -> 8
        * 9 -> 9
        * 10 -> 10
        *
        * */

        for( int i=0;i< A.length;i++){
            A[i] = divisorCount.get(A[i]);
        }
        return A;
    }


}
