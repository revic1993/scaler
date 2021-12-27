package dsa.scaler.arrays.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueSubArrays {
    public static void main(String[] args) {

    }
    public int solve(ArrayList<Integer> A) {
        int i=0,j=1;
        HashMap<Integer,Integer> numMap = new HashMap<>();
        numMap.put(A.get(i),0);
        int count = 0;
        while(j < A.size()){
            while(!numMap.containsKey(A.get(j))){
                numMap.put(A.get(j),j);
                j++;
            }

        }
        return count;
    }
}
