package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Djiktras {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
          dataset.add(Utils.generateList(0, 2, 4));
          dataset.add(Utils.generateList(1, 2, 10));
          dataset.add(Utils.generateList(5, 7, 4));
          dataset.add(Utils.generateList(2, 3, 6));
          dataset.add(Utils.generateList(3, 7, 2));
          dataset.add(Utils.generateList(0, 5, 2));

        Utils.printSingleArr(new Djiktras().solve(8,dataset,7));
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        HashMap<String,Integer> weights = new HashMap<>();
        for(int i=0;i<A;i++){
            graph.add(new ArrayList<>());
            distance.add(i == C ? 0 : -1);
            parent.add(i == C ? 0 : -1);
        }

        for(ArrayList<Integer> edge : B){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
            weights.put(key(edge.get(0),edge.get(1)),edge.get(2));
        }
        PriorityQueue<WeightedEdge> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for(int neighbor : graph.get(C)){
            minHeap.add(new WeightedEdge(C,neighbor,weights.get(key(C,neighbor))));
        }
        int totalEdges = 0;
        while(!minHeap.isEmpty() && totalEdges <= A-1){
            WeightedEdge cEdge = minHeap.remove();
            int nextNode = distance.get(cEdge.v2) == -1 ? cEdge.v2 : cEdge.v1;
            int parentNode = distance.get(cEdge.v2) == -1 ? cEdge.v1 : cEdge.v2;
            if(distance.get(nextNode)!=-1){
                continue;
            }
            parent.set(nextNode, parentNode);
            distance.set(nextNode,cEdge.weight);
            totalEdges++;
            for(int nextNeighbor : graph.get(nextNode)){
                if(distance.get(nextNeighbor) != -1){
                    continue;
                }
                minHeap.add(new WeightedEdge(nextNeighbor,nextNode,weights.get(key(nextNeighbor,nextNode))+distance.get(nextNode)));
            }
        }
        return distance;
    }

    static String key(int v1,int v2){
        return v1 > v2 ? v2+"_"+v1 : v1+"_"+v2;
    }

    static class WeightedEdge{
        int v1;
        int v2;
        int weight;
        public WeightedEdge(int v1, int v2, int weight){
            this.v1 = Math.min(v1,v2);
            this.v2 = Math.max(v1,v2);
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" +
                    "v1 : " + v1 +
                    ", v2 : " + v2 +
                    ", weight : " + weight +
                    "}\n";
        }
    }
}
