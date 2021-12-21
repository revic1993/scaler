package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.*;

public class MaxFreqStack {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        data.add(new ArrayList<>(List.of(1,5)));
        data.add(new ArrayList<>(List.of(1,7)));
        data.add(new ArrayList<>(List.of(1,5)));
        data.add(new ArrayList<>(List.of(1,7)));
        data.add(new ArrayList<>(List.of(1,4)));
        data.add(new ArrayList<>(List.of(1,5)));
        data.add(new ArrayList<>(List.of(2,0)));
        data.add(new ArrayList<>(List.of(2,0)));
        data.add(new ArrayList<>(List.of(2,0)));
        data.add(new ArrayList<>(List.of(2,0)));
        MaxFreqStack maxFreqStack = new MaxFreqStack();
        Utils.printSingleArr(maxFreqStack.solve(data));
    }
    int highestFreq = Integer.MIN_VALUE;
    int currentHighest = Integer.MIN_VALUE;
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> reverseMap = new HashMap<>();
//        Stack<Integer> numStack = new Stack<>();
        for(ArrayList<Integer> data : A){
            if(data.get(0) == 1){
//                numStack.push(data.get(1));
                updateFreq(freqMap,reverseMap,data.get(1), true);
                result.add(-1);
            }else{
                result.add(currentHighest);
                updateFreq(freqMap,reverseMap,currentHighest,false);
            }
        }

        return result;
    }

    public void updateFreq(HashMap<Integer,Integer> freqMap,HashMap<Integer,HashSet<Integer>> reverseMap,int a,boolean push){
        if(!freqMap.containsKey(a)){
            freqMap.put(a,0);
        }

        int currentFreq = freqMap.get(a);
        int updatedFreq;
        if(push){
            updatedFreq = currentFreq+1;
        }else{
            updatedFreq = currentFreq-1;
        }
        freqMap.put(a,updatedFreq);
        updateReverseFreq(reverseMap,currentFreq,updatedFreq,a);
    }

    public void updateReverseFreq(HashMap<Integer,HashSet<Integer>> reverseFreqMap,int removeFreq, int addFreq,int a){
        if(reverseFreqMap.containsKey(removeFreq)){
            HashSet<Integer> numSet = reverseFreqMap.get(removeFreq);
            numSet.remove(a);
            if(numSet.isEmpty()){
                reverseFreqMap.remove(removeFreq);
            }else{
                reverseFreqMap.put(removeFreq,numSet);
            }
        }

        if(!reverseFreqMap.containsKey(addFreq)){
            HashSet<Integer> numSet = new HashSet<>();
            numSet.add(a);
            reverseFreqMap.put(addFreq,numSet);
        }else{
            HashSet<Integer> currentSet = reverseFreqMap.get(addFreq);
            currentSet.add(a);
            reverseFreqMap.put(addFreq,currentSet);
        }
        highestFreq = reverseFreqMap.keySet().stream().max(Integer::compare).get();
        currentHighest = reverseFreqMap.get(highestFreq).iterator().next();
    }
}
