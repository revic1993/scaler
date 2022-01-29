package dsa.scaler.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SpecialMedian {
    public static void main(String[] args) {
        SpecialMedian sm = new SpecialMedian();
        System.out.println(sm.solve(new ArrayList<>(List.of(1,2,3,2,1))));
    }
    public int solve(ArrayList<Integer> A) {
        ArrayList<Double> leftRunningMedian = runningMedian(A,false);
        ArrayList<Double> rightRunningMedian = runningMedian(A,true);
        for(int i=0;i<A.size();i++){
            if( (i > 0 && leftRunningMedian.get(i) == (double) A.get(i)) || (i < A.size()-1 && rightRunningMedian.get(i) == (double) A.get(i))){
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<Double> runningMedian(ArrayList<Integer> A,boolean reverse) {
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(!reverse){
            result.add(-1.0);
        }
        int i = reverse ? A.size()-1 : 0;
        int k = 1;
        while(k < A.size()) {
            int a = A.get(i);
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
            boolean isEven = ((maxHeap.size() + minHeap.size()) & 1) == 0;
            double median = 0;
            if(isEven){
                median = ((maxHeap.peek()+minHeap.peek())/ 2.0);
            }else{
                median = maxHeap.peek();
            }
            i += reverse ? -1 : 1;
            k++;
            result.add(median);
        }
        if(reverse){
            Collections.reverse(result);
            result.add(-1.0);
        }
        return result;
    }
}
