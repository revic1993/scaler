package dsa.scaler.math.gcd;

import java.util.*;

public class AllGCDPairs {
    public static void main(String[] args) {
        int[][] testSet = {
                {2, 2, 2, 2, 8, 2, 2, 2, 10},
                {1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " => "+Arrays.toString(solve(testData)));
        }
    }

    public static int[] solve(int[] A) {
        //obs 1 : the actual array size is log_2(N)
        int n = (int) Math.sqrt(A.length);
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        for(int a : A){
            if(!freqMap.containsKey(a)){
                freqMap.put(a,0);
            }
            int currentVal = freqMap.get(a);
            freqMap.put(a,++currentVal);
        }

        Set<Integer> keySet = freqMap.keySet();

        if(keySet.size() == n){
            result.addAll(keySet);
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        if(keySet.size() < n){
            for(Integer key : keySet){
                int val = (int) Math.sqrt(freqMap.get(key));
                for(int i=0;i<val;i++){
                    result.add(key);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        result.addAll(keySet);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
