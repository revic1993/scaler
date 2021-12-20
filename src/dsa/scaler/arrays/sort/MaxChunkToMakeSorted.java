package dsa.scaler.arrays.sort;

import java.util.HashSet;

public class MaxChunkToMakeSorted {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        // 0 2 4 3 1 6 5
        HashSet<Integer> numSet = new HashSet<>();
        int low = 0;
        int high = 0;
        int partition = 0;
        for(int i=0;i<A.length;i++){
            numSet.add(A[i]);
            if(numSet.contains(i) && numSet.contains(A[low])){
                partition+= i-low+1;
                low++;
            }
        }
        return -1;
    }
}
