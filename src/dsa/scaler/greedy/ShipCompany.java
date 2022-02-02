package dsa.scaler.greedy;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShipCompany {
    public static void main(String[] args) {
        ShipCompany sc = new ShipCompany();
        Utils.printSingleArr(sc.solve(4,3, Utils.generateList(2, 2, 2)));
    }

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.addAll(C);
        maxHeap.addAll(C);
        int maxCost = 0;
        int minCost = 0;
        for(int i=0;i<A;i++){
            int minNum = minHeap.remove();
            minCost+=minNum;
            if(minNum>1){
                minHeap.add(minNum-1);
            }
            int maxNum = maxHeap.remove();
            maxCost+=maxNum;
            if(maxNum>1){
                maxHeap.add(maxNum-1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxCost);
        result.add(minCost);
        return result;
    }
}
