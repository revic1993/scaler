package dsa.scaler.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CandiesBox {
    public static void main(String[] args) {
        CandiesBox cb = new CandiesBox();
        System.out.println(cb.solve(new ArrayList<>(List.of(1,2,1)),2));
    }
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(A);
        int totalCandies = 0;
        while(!minHeap.isEmpty()  && minHeap.peek() <= B){
            int min1 = minHeap.remove();
            int candiesToEat = min1 >> 1;
            totalCandies = totalCandies+candiesToEat;
            if(minHeap.isEmpty()){
                return totalCandies;
            }
            int min2 = minHeap.remove();
            int min2Candies = min2+(min1-candiesToEat);
            minHeap.add(min2Candies);
        }
        return totalCandies;
    }
}
