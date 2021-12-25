package dsa.scaler.queues;

import dsa.utils.Utils;

import java.util.*;

public class SlidingWindowMax {

    public static void main(String[] args) {
        SlidingWindowMax slm = new SlidingWindowMax();
        Utils.printSingleArr(slm.slidingMaximum(new ArrayList<>(List.of(1, 3, -1, -3, 5, 3, 6, 7)),3));
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        if(A.size() == 1){
            return new ArrayList<>(A);
        }
        ArrayList<Integer> result = new ArrayList<>(A);
        if(B > A.size()){
            int max = Collections.max(A);
            Collections.fill(result,max);
            return result;
        }

        Deque<Integer> maxQueue = new LinkedList<>();
        result = new ArrayList<>();
        for(int i=0;i<A.size() && i<B ;i++){
            addToQueue(maxQueue,A.get(i));
        }
        result.add(maxQueue.getFirst());
        for(int i=B;i<A.size();i++){
            removeFromQueue(maxQueue,A.get(i-B));
            addToQueue(maxQueue,A.get(i));
            result.add(maxQueue.getFirst());
        }
        return result;
    }

    public void addToQueue(Deque<Integer> maxQueue,int a){
        while(!maxQueue.isEmpty() && maxQueue.getLast() < a){
            maxQueue.removeLast();
        }
        maxQueue.addLast(a);
    }

    public void removeFromQueue(Deque<Integer> maxQueue,int a){
        if(!maxQueue.isEmpty() && maxQueue.getFirst()==a){
            maxQueue.removeFirst();
        }
    }
}
