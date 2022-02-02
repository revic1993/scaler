package dsa.scaler.search;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class FoodPacketDistribution {
    public static void main(String[] args) {
        FoodPacketDistribution fpd = new FoodPacketDistribution();
        System.out.println(fpd.solve(Utils.generateList(10000,20000,30000),9));
    }

    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((node1, node2)->node2.getDist()-node1.getDist());
        int pending = B-A.size();
        for (Integer integer : A) {
            maxHeap.add(new HeapNode(integer));
        }
        while(pending > 1){
            HeapNode current = maxHeap.remove();
            current.updateOffices();
            maxHeap.add(current);
            pending--;
        }
        int maxPopulation = Integer.MAX_VALUE;
        while(!maxHeap.isEmpty()){
            HeapNode currentNode = maxHeap.remove();
            int currentMax = currentNode.population/currentNode.offices;
            maxPopulation = Math.min(currentMax,maxPopulation);
        }
        return maxPopulation;
    }

    public int requiredOffices(ArrayList<Integer> A,int maxPopulation){
        int required = 0;
        for(int a : A){
            required+=(a/maxPopulation);
        }
        return required;
    }

    static class HeapNode{
        int population;
        int offices;

        HeapNode(int population){
            this.population = population;
            this.offices = 1;
        }

        void updateOffices(){
            this.offices++;
        }

        int getDist(){
            return population/(offices+1);
        }

        @Override
        public String toString() {
            return "{" +
                    "population:" + population +
                    ", offices:" + offices +
                    '}';
        }
    }
}
