package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;

public class CycleInGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
        dataset.add(Utils.generateList(1, 2));
        dataset.add(Utils.generateList(1,3));
        dataset.add(Utils.generateList(2,3));
        dataset.add(Utils.generateList(1,4));
        dataset.add(Utils.generateList(4,3));
        dataset.add(Utils.generateList(4,5));
        dataset.add(Utils.generateList(3,5));


        CycleInGraph cig = new CycleInGraph();
        System.out.println(cig.solve(5,dataset));
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> node : B){
            graph.get(node.get(0)).add(node.get(1));
        }

        for(int i=1;i<=A;i++){
            if(dfs(graph,visited,path,i)){
                return 1;
            }
        }
        return 0;
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
