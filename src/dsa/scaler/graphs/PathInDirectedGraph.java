package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;

public class PathInDirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
        dataset.add(Utils.generateList(1, 2));
        dataset.add(Utils.generateList(2, 3));
        dataset.add(Utils.generateList(3, 4));
        dataset.add(Utils.generateList(4, 5));

        PathInDirectedGraph pathInDirectedGraph = new PathInDirectedGraph();
        System.out.println(pathInDirectedGraph.solve(5,dataset));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] visited = new boolean[A+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> node : B){
            graph.get(node.get(0)).add(node.get(1));
        }
        dfs(graph,A,visited,1);
        return visited[A] ? 1 : 0;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph,int A,boolean[] visited, int current){
        ArrayList<Integer> neighbors = graph.get(current);
        visited[current] = true;
        for(int neighbor : neighbors){
          if(!visited[neighbor])  dfs(graph,A,visited,neighbor);
        }
    }
}
