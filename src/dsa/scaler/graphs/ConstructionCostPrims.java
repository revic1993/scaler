package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.*;

public class ConstructionCostPrims {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
          dataset.add(Utils.generateList(1, 2, 6));
          dataset.add(Utils.generateList(1, 3, 8));
          dataset.add(Utils.generateList(2, 4, 11));
          dataset.add(Utils.generateList(3, 5, 9));
          dataset.add(Utils.generateList(1, 6, 5));
          dataset.add(Utils.generateList(2, 7, 10));
          dataset.add(Utils.generateList(1, 8, 9));
          dataset.add(Utils.generateList(6, 9, 2));
          dataset.add(Utils.generateList(5, 10, 4));
          dataset.add(Utils.generateList(4, 8, 6));
          dataset.add(Utils.generateList(5, 4, 1));
          dataset.add(Utils.generateList(9, 1, 10));
          dataset.add(Utils.generateList(1, 7, 3));
          dataset.add(Utils.generateList(9, 2, 4));
        ConstructionCostPrims cik = new ConstructionCostPrims();
        System.out.println(cik.solve(11,dataset));
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        HashMap<String,Integer> weightMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        long sum = 0;

        int mod = 1000*1000*1000+7;
         for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());

        }
        for(ArrayList<Integer> node : B){
            if(node.get(0).intValue() == node.get(1)){
                continue;
            }
            int v1 = node.get(0);
            int v2 = node.get(1);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
            String key = getKey(v1,v2);
            if(weightMap.getOrDefault(key,Integer.MAX_VALUE) > node.get(2)){
                weightMap.put(key,node.get(2));
            }
        }
        PriorityQueue<WeightedPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for(int neighbor : graph.get(1)){
            String key = getKey(1,neighbor);
            minHeap.add(new WeightedPair(1,neighbor,weightMap.get(key)));
        }
        int totalEdges = 0;
        visited.add(1);
        while(!minHeap.isEmpty()){
            WeightedPair currentP = minHeap.remove();
            visited.add(currentP.v2);
            sum = (sum%mod + currentP.weight%mod )%mod;
            totalEdges++;
            if(totalEdges == A-1){
                return (int) sum;
            }
            for(int neighbor : graph.get(currentP.v2)){
                String key = getKey(currentP.v2,neighbor);
                if(visited.contains(neighbor)){
                    continue;
                }
                minHeap.add(new WeightedPair(currentP.v2,neighbor,weightMap.get(key)));

            }
        }
        return (int) sum;
    }

    static String getKey(int v1,int v2){
        return v1 > v2 ? v2+"_"+v1 : v1+"_"+v2 ;
    }

    static class WeightedPair{
        int v1;
        int v2;
        int weight;
        WeightedPair(int v1,int v2,int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WeightedPair that = (WeightedPair) o;
            return v1 == that.v1 && v2 == that.v2 && weight == that.weight ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2, weight);
        }

        @Override
        public String toString() {
            return "{" +
                    "v1:" + v1 +
                    ", v2:" + v2 +
                    ", weight:" + weight +
                    '}';
        }
    }
}
/*
*
*   WeightedPair cPair = minHeap.remove();
            visited.add(cPair.v2);
            sum = (sum%mod + cPair.weight%mod)%mod;
            totalEdges++;
            if(totalEdges == A-1){
                return (int) sum;
            }

            for(int neighbor : graph.get(cPair.v2)){
                if(visited.contains(neighbor)){
                    continue;
                }
                String key = neighbor < cPair.v2 ? neighbor+"_"+cPair.v2 : cPair.v2+"_"+neighbor;
                minHeap.add(new WeightedPair(cPair.v2,neighbor,weightMap.get(key)));
            }*/