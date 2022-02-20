package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;

public class NumberOfIslands {
    public static void main(String[] args) {
       int[][] dataSet = {
               {1, 1, 1, 1, 1},
               {1, 0, 1, 0, 0},
               {1, 0, 1, 1, 0},
               {1, 0, 1, 0, 1},
               {1, 1, 1, 0, 0},
               {1, 0, 1, 1, 1},
               {1, 0, 1, 0, 1},
               {0, 1, 1, 0, 0}
       };
        NumberOfIslands noi = new NumberOfIslands();
        System.out.println(noi.solve(dataSet));
    }
    public int solve(int[][] A) {
        int ans = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    ans++;
                    dfs(A,visited,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] graph, boolean[][] visited,int i, int j) {
        visited[i][j] = true;
        if(i>0 && graph[i-1][j] == 1 && !visited[i-1][j]){
            dfs(graph,visited,i-1,j);
        }

        if(j>0 && graph[i][j-1] == 1 && !visited[i][j-1]){
            dfs(graph,visited,i,j-1);
        }

        if(i<graph.length-1 && graph[i+1][j] == 1 && !visited[i+1][j]){
            dfs(graph,visited,i+1,j);
        }

        if(j<graph[0].length-1 && graph[i][j+1] == 1 && !visited[i][j+1]){
            dfs(graph,visited,i,j+1);
        }

        if(i>0 && j>0 && graph[i-1][j-1] == 1 && !visited[i-1][j-1]){
            dfs(graph,visited,i-1,j-1);
        }

        if(i<graph.length-1 && j<graph[0].length-1 && graph[i+1][j+1] == 1 && !visited[i+1][j+1]){
            dfs(graph,visited,i+1,j+1);
        }

        if(i>0 && j<graph[0].length-1 && graph[i-1][j+1] == 1 && !visited[i-1][j+1]){
            dfs(graph,visited,i-1,j+1);
        }
        if(i<graph.length-1 && j>0 && graph[i+1][j-1] == 1 && !visited[i+1][j-1]){
            dfs(graph,visited,i+1,j-1);
        }
    }
}
