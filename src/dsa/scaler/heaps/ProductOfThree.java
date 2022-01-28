package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ProductOfThree {

        public static void main(String[] args) {
                ProductOfThree pot = new ProductOfThree();
                Utils.printSingleArr(pot.solve(new ArrayList<>(List.of(10,2,13,23,7,19))));
        }

        public ArrayList<Integer> solve(ArrayList<Integer> A) {
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                ArrayList<Integer> result = new ArrayList<>();
                for(int i=0;i<A.size();i++){
                        if(i < 2){
                                result.add(-1);
                                maxHeap.add(A.get(i));
                                continue;
                        }
                        maxHeap.add(A.get(i));
                        int firstMax = maxHeap.remove();
                        int secondMax = maxHeap.remove();
                        int thirdMax = maxHeap.remove();
                        result.add(firstMax*secondMax*thirdMax);
                        maxHeap.add(firstMax);
                        maxHeap.add(secondMax);
                        maxHeap.add(thirdMax);
                }
                return result;
        }

}
