package dsa.scaler.heaps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ArrayList<Integer> current : A){
            minHeap.addAll(current);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<B;i++){
            min = minHeap.remove();
        }
        return min;
    }
}
