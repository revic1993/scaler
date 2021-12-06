package dsa.scaler.arrays.twopointers;

import java.util.*;

public class FindPairs {

    public static void main(String[] args) {
        FindPairs fp = new FindPairs();
        System.out.println(fp.solve(new ArrayList<>(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3)),3));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int totalPairs = 0;
        if(B == 0){
            HashMap<Integer,Integer> numFreq = new HashMap<>();
            for(int a : A){
                if(!numFreq.containsKey(a)){
                    numFreq.put(a,0);
                }
                numFreq.put(a,numFreq.get(a)+1);
            }
            Set<Integer> keySet = numFreq.keySet();
            for(int a : keySet){
                if(numFreq.get(a) > 1){
                    totalPairs++;
                }
            }
            return totalPairs;
        }
        HashSet<Integer> nums = new HashSet<>(A);


        for(int a : nums){
            int searchNum = a - B;
            if(nums.contains(searchNum)){
                totalPairs++;
            }
        }

        return totalPairs;
    }
}
