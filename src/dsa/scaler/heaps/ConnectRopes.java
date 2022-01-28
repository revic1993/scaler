package dsa.scaler.heaps;

import dsa.scaler.heaps.structs.Heap;

import java.util.ArrayList;
import java.util.List;

public class ConnectRopes {
    public static void main(String[] args) {
        ConnectRopes cr = new ConnectRopes();
        System.out.println(cr.solve(new ArrayList<>(List.of(5, 17, 100, 11))));
    }
    public int solve(ArrayList<Integer> A) {
        Heap.buildHeap(A);
        long sum = 0;
        while(A.size()>=2){
            int min1 = Heap.getMin(A);
            int min2 = Heap.getMin(A);
            sum += min1+min2;
            Heap.addToHeap(A,min1+min2);
        }
        return (int) sum;
    }

}
