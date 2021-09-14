package dsa.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PairExistForSum {

    public static void main(String[] args){
        int[][] dataset = new int[][]{
                {1,2,3,4},
                {1,2,15},
                {2,15,22},
                {2,3,5,8,13},
                {2,8,5,3,13}
        };
        PairExistForSum pairExistForSum = new PairExistForSum();
        for(int[] currentSet : dataset){
            System.out.println("Total pairs for "+ Arrays.toString(currentSet)+" are "+pairExistForSum.solve(currentSet));
        }
    }

    public int solve(int[] A) {
        HashSet<Integer> availableNumbers = new HashSet<>();

        for(int a : A){
            availableNumbers.add(a);
        }

        int sum = 0;
        for(int i=0;i<A.length;i++){
            for(int j = i+1; j<A.length; j++){
                if(!availableNumbers.contains(A[i]+A[j])){
                    continue;
                }
                sum++;
            }
        }
        return sum;
    }
}
