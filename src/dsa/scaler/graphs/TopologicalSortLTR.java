package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopologicalSortLTR {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataSet = new ArrayList<>();
        dataSet.add(Utils.generateList(1, 4));
        dataSet.add(Utils.generateList(1, 2));
        dataSet.add(Utils.generateList(4, 2));
        dataSet.add(Utils.generateList(4, 3));
        dataSet.add(Utils.generateList(3, 2));
        dataSet.add(Utils.generateList(5, 2));
        dataSet.add(Utils.generateList(3, 5));
        dataSet.add(Utils.generateList(8, 2));
        dataSet.add(Utils.generateList(8, 6));


        TopologicalSortLTR tsr = new TopologicalSortLTR();
        Utils.printSingleArr(tsr.solve(8,dataSet));
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[A+1];
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> edges : B){
            graph.get(edges.get(0)).add(edges.get(1));
            indegree[edges.get(1)]++;
        }

        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        for(int i=1;i<=A;i++){
            if(!visited[i] && dfs(graph,visited,path,i)){
                return result;
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=1;i<=A;i++){
            if(indegree[i] == 0){
                minHeap.add(i);
            }
        }

        while(!minHeap.isEmpty()){
            int current = minHeap.remove();
            result.add(current);
            for(int neighbor : graph.get(current)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    minHeap.add(neighbor);
                }
            }
        }



        return result;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,boolean[] path, int current){
        ArrayList<Integer> neighbors = graph.get(current);
        visited[current] = true;
        path[current] = true;
        for(int neighbor : neighbors){
            if(path[neighbor]){
                return true;
            }
            if(!visited[neighbor] && dfs(graph,visited,path,neighbor)){
                return true;
            }
        }
        path[current]=false;
        return false;
    }

}
