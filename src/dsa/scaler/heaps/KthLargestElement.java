package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kle = new KthLargestElement();
        Utils.printSingleArr(kle.solve(2,new ArrayList<>(List.of(15, 20, 99, 1))));
    }
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<A;i++){
            minHeap.add(B.get(i));
            if(i < A-1){
                result.add(-1);
            }
        }

        for(int i=A;i<B.size();i++){
            int min = minHeap.peek();
            if(min < B.get(i)){
                minHeap.remove();
                minHeap.add(B.get(i));
            }
            result.add(min);
        }
        result.add(minHeap.remove());
        return result;
    }
}
