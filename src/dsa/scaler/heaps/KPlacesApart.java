package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPlacesApart {
    public static void main(String[] args) {
        KPlacesApart kpa = new KPlacesApart();
        Utils.printSingleArr(kpa.solve(new ArrayList<>(List.of(2, 1, 17, 10, 21, 95)),1));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<=B;i++){
            minHeap.add(A.get(i));
        }
        for(int i=0;i<A.size();i++){
            A.set(i,minHeap.remove());
            if(B+i+1 < A.size()){
                minHeap.add(A.get(B+i+1));
            }
        }
        return A;
    }
}
