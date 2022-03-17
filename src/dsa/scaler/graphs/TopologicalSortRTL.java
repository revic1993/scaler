package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortRTL {
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

//        dataSet.add(Utils.generateList(1,2));
//        dataSet.add(Utils.generateList(2,3));
//        dataSet.add(Utils.generateList(2,4));
//        dataSet.add(Utils.generateList(3,4));
//        dataSet.add(Utils.generateList(4,1));
        TopologicalSortRTL tsr = new TopologicalSortRTL();
        Utils.printSingleArr(tsr.solve(8,dataSet));
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        Stack<Integer> sortedVertex = new Stack<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A;i++){
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> edges : B){
            graph.get(edges.get(0)).add(edges.get(1));
        }
        boolean[] visited = new boolean[A+1];

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=A;i>=1;i--){
            if(!visited[i] ){
                dfs(i,graph,sortedVertex,visited);
            }
        }
        while(!sortedVertex.isEmpty()){
            result.add(sortedVertex.pop());
        }
        return result;
    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> graph, Stack<Integer> sortedVertex,boolean[] visited) {
        visited[i] = true;
        for(int neighbor : graph.get(i)){

            if(!visited[neighbor]){
                dfs(neighbor,graph,sortedVertex,visited);
            }
        }

        sortedVertex.push(i);
    }


}
