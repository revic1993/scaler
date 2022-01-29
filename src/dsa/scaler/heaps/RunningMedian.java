package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        Utils.printSingleArr(rm.solve(new ArrayList<>(List.of(5, 17, 100, 11))));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer a : A) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= a) {
                maxHeap.add(a);
                if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.remove());
                }
            } else {
                minHeap.add(a);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.remove());
                }
            }
            result.add(maxHeap.peek());
        }
        return result;
    }
}
