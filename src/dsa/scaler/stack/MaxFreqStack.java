package dsa.scaler.stack;

import dsa.utils.Utils;

import java.beans.PropertyEditorSupport;
import java.util.*;

public class MaxFreqStack {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        data.add(new ArrayList<>(List.of(1, 5)));
        data.add(new ArrayList<>(List.of(1, 7)));
        data.add(new ArrayList<>(List.of(1, 5)));
        data.add(new ArrayList<>(List.of(1, 7)));
        data.add(new ArrayList<>(List.of(1, 4)));
        data.add(new ArrayList<>(List.of(1, 5)));
        data.add(new ArrayList<>(List.of(2, 0)));
        data.add(new ArrayList<>(List.of(2, 0)));
        data.add(new ArrayList<>(List.of(2, 0)));
        data.add(new ArrayList<>(List.of(2, 0)));
        MaxFreqStack maxFreqStack = new MaxFreqStack();
        Utils.printSingleArr(maxFreqStack.solve(data));
    }

    int highestFreq = Integer.MIN_VALUE;

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Stack<Integer>> reverseMap = new HashMap<>();
        int i = 0;
        for (ArrayList<Integer> data : A) {
            boolean isPush = data.get(0) == 1;
            if (isPush) {
                result.add(push(data.get(1), freqMap, reverseMap));
            } else {
                result.add(pop(freqMap, reverseMap));
            }
        }

        return result;
    }

    private int pop(HashMap<Integer, Integer> freqMap, HashMap<Integer, Stack<Integer>> reverseMap) {
        Stack<Integer> freqNumStack = reverseMap.get(this.highestFreq);
        int currentHighestFreqNum = freqNumStack.pop();
        if(freqNumStack.isEmpty()){
            reverseMap.remove(this.highestFreq);
            this.highestFreq--;
        }else{
            reverseMap.put(this.highestFreq,freqNumStack);
        }
        int currHighestFreq = freqMap.get(currentHighestFreqNum);
        if(currHighestFreq-1 == 0){
            freqMap.remove(currentHighestFreqNum);
        }else{
            freqMap.put(currentHighestFreqNum,currHighestFreq-1);
        }
        return currentHighestFreqNum;
    }

    public int push(int a, HashMap<Integer, Integer> freqMap, HashMap<Integer, Stack<Integer>> reverseMap) {
        if (!freqMap.containsKey(a)) {
            freqMap.put(a, 0);
        }

        int currentFreq = freqMap.get(a);
        freqMap.put(a, ++currentFreq);
        Stack<Integer> freqNumStack = !reverseMap.containsKey(currentFreq) ? new Stack<>() : reverseMap.get(currentFreq);
        freqNumStack.push(a);
        reverseMap.put(currentFreq, freqNumStack);
        this.highestFreq = Math.max(this.highestFreq, currentFreq);
        return -1;
    }
}