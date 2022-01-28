package dsa.scaler.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSumAfterBNegotiation {

    public static void main(String[] args) {
        MaxSumAfterBNegotiation msn =new MaxSumAfterBNegotiation();
        System.out.println(msn.solve(new ArrayList<>(List.of(57, 3, -14, -87, 42, 38, 31, -7, -28, -61)),10));
    }
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(A);
        int sum = 0;
        for(int i=0;i<B;i++){
            int min = minHeap.remove();
            minHeap.add(min*-1);
        }
        while(!minHeap.isEmpty()){
            sum+= minHeap.remove();
        }
        return sum;
    }
}
