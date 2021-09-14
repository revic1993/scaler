package dsa.hashmap;

import java.util.*;

public class SmallestRepeatingIndex {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> numIndexMap = new HashMap<>();
        int minIndex = -1;
        for(int i =0; i< A.size(); i++){
            if(!numIndexMap.containsKey(A.get(i))){
                numIndexMap.put(A.get(i),i);
                continue;
            }
            if(minIndex == -1 || minIndex > numIndexMap.get(A.get(i))){
                minIndex = numIndexMap.get(A.get(i));
            }
        }
        return minIndex == -1 ? -1 : A.get(minIndex);
    }
}
