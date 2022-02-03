package dsa.leetcode.heaps;

import dsa.utils.Utils;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements tpk = new TopKFrequentElements();
        Utils.printIntArr(tpk.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            if(!freqMap.containsKey(num)){
                freqMap.put(num,1);
                continue;
            }
            freqMap.put(num,freqMap.get(num)+1);
        }
        int[] result = new int[k];
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((node1,node2)->node2.freq-node1.freq);
        for(int key : freqMap.keySet()){
            maxHeap.add(new HeapNode(key,freqMap.get(key)));
        }
        for(int i=0;i<result.length;i++){
            result[i] = maxHeap.remove().num;
        }
        return result;
    }

    static class HeapNode{
        int num;
        int freq;

        HeapNode(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }
}
