package dsa.scaler.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumLargestElement {
    public static void main(String[] args) {
        MinimumLargestElement mle = new MinimumLargestElement();
        System.out.println(mle.solve(new ArrayList<>(List.of(5,1,4,2)),5));
    }

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(Comparator.comparing(HeapNode::getCurrentVal));
        int maxVal = Integer.MIN_VALUE;
        for(int a : A){
            minHeap.add(new HeapNode(a));
            maxVal = Math.max(a,maxVal);
        }
        for(int i=0;i<B;i++){
            HeapNode currentNode = minHeap.remove();
            maxVal = Math.max(currentNode.updateData(),maxVal);
            minHeap.add(currentNode);
        }
        return maxVal;
    }

    static class HeapNode{
        int data;
        int incrementBy;
        public HeapNode(int val){
            this.data = val;
            this.incrementBy = val;
        }
        public int updateData(){
            this.data += this.incrementBy;
            return this.data;
        }
        public int getCurrentVal(){
            return this.data+this.incrementBy;
        }
    }
}
