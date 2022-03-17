package dsa.scaler.graphs;

import java.util.ArrayList;

public class PossibilityOfFinishing {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];
        boolean isCyclePresent = false;
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<B.size();i++){
            graph.get(B.get(i)).add(C.get(i));
        }
        for(int i=1;i<=A;i++){
            if(dfs(graph,visited,path,i)){
                return 0;
            }
        }

        return 1;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path, int a) {
        path[a] = true;
        visited[a] = true;
        for(int n : graph.get(a)){
            if(path[n]){
                return true;
            }
            if(!visited[n] && dfs(graph,visited,path,n)){
                return true;
            }
        }
        path[a] = false;
        return false;
    }


}
