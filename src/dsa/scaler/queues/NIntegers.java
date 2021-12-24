package dsa.scaler.queues;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class NIntegers {
    public static void main(String[] args) {
        NIntegers ni = new NIntegers();
        Utils.printSingleArr(ni.solve(10));
    }
    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A <=3){
            for(int i=0;i<A;i++){
                result.add(i+1);
            }
            return result;
        }
        int total = 0;
        Deque<Integer> numQueue = new LinkedList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        numQueue.addFirst(3);
        numQueue.addFirst(2);
        numQueue.addFirst(1);
        for(int i=3;i<A;i+=3){
            int top = numQueue.removeFirst();
            numQueue.addLast(top*10+1);
            numQueue.addLast(top*10+2);
            numQueue.addLast(top*10+3);
            result.add(top*10+1);
            result.add(top*10+2);
            result.add(top*10+3);
        }

        return (ArrayList<Integer>) result.stream().limit(A).collect(Collectors.toList());
    }
}
