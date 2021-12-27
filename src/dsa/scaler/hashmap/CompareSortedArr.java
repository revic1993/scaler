package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareSortedArr {
    public static void main(String[] args) {
        CompareSortedArr csa = new CompareSortedArr();
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));
        for(int i=1;i<A.size();i++){
            prefixSum.add(A.get(i)+prefixSum.get(i-1));
        }

        for (ArrayList<Integer> queries : B) {
            int addStart = queries.get(0);
            int addEnd = queries.get(1);
            int removeStart = queries.get(2);
            int removeEnd = queries.get(3);

            int firstInterval = prefixSum.get(addEnd) - (addStart == 0 ? 0 : prefixSum.get(addStart-1));
            int secondInterval =  prefixSum.get(removeEnd) - (removeStart == 0 ? 0 : prefixSum.get(removeStart-1));
            if(firstInterval!=secondInterval){
                result.add(0);
                continue;
            }

            while (addStart <= addEnd) {
                addFreq(freqMap, A.get(addStart++));
            }
            while (removeStart <= removeEnd) {
                removeFreq(freqMap, A.get(removeStart++));
            }
            result.add(freqMap.size() == 0 ? 1 : 0);
            freqMap.clear();
        }
        return result;
    }

    void addFreq(HashMap<Integer,Integer> freqMap,int a){
        if(!freqMap.containsKey(a)){
            freqMap.put(a,1);
            return;
        }
        freqMap.put(a,freqMap.get(a)+1);
    }

    void removeFreq(HashMap<Integer,Integer> freqMap,int a){
        if(!freqMap.containsKey(a)){
            return;
        }
        if(freqMap.get(a) == 1){
            freqMap.remove(a);
            return;
        }
        freqMap.put(a,freqMap.get(a)-1);
    }

}
