package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FirstDepthFirstSearch {
    public static void main(String[] args) {
        FirstDepthFirstSearch fdfs = new FirstDepthFirstSearch();
        System.out.println(fdfs.solve(Utils.generateList(1,1,2),2,1));
    }
    public int solve(ArrayList<Integer> A, int B, int C) {
        boolean[] visited = new boolean[A.size()+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A.size();i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<A.size();i++){
            graph.get(A.get(i)).add(i+1);
        }

        dfs(graph,visited,C);
        return visited[B] ? 1 : 0;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited, int current){
        ArrayList<Integer> neighbors = graph.get(current);
        visited[current] = true;
        for(int neighbor : neighbors){
            if(!visited[neighbor])  dfs(graph,visited,neighbor);
        }
    }
}
