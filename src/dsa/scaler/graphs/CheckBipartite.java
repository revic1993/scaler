package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartite {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
        dataset.add(Utils.generateList(7,8));
        dataset.add(Utils.generateList(1,2));
        dataset.add(Utils.generateList(0, 9 ));
        dataset.add(Utils.generateList(1, 3));
        dataset.add(Utils.generateList(6, 7));
        dataset.add(Utils.generateList(0, 3));
        dataset.add(Utils.generateList(2, 5));
        dataset.add(Utils.generateList(3, 8));
        dataset.add(Utils.generateList(4, 8));
        CheckBipartite cb = new CheckBipartite();
        System.out.println(cb.solve(10,dataset));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] color = new int[A];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<A;i++){
            graph.add(new ArrayList<>());
        }

        for(ArrayList<Integer> node : B){
            graph.get(node.get(0)).add(node.get(1));
            graph.get(node.get(1)).add(node.get(0));
        }



        Utils.printSingleArr(graph);
        Arrays.fill(color,-1);
        boolean isBipartite = true;
        for(int i=0;i<A;i++){
            if(color[i] == -1){
                color[i] = 0;
                isBipartite = isBipartite && dfs(graph,color,i);
            }
        }
        return isBipartite ? 1 : 0;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph,int[] color, int i) {
        ArrayList<Integer> neighbors = graph.get(i);
        for(int neighbor : neighbors){
            if(color[neighbor] == -1){
                color[neighbor] = 1 ^ color[i];
                if(!dfs(graph,color,neighbor)){
                    return false;
                }
            }else if(color[neighbor] == color[i]){
                return false;
            }
        }
        return true;
    }


}
