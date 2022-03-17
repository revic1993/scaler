package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.*;

public class CommutableIslandsKruskal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataset = new ArrayList<>();
        dataset.add(Utils.generateList(1, 2, 1));
        dataset.add(Utils.generateList(2, 3, 4));
        dataset.add(Utils.generateList(1, 4, 3));
        dataset.add(Utils.generateList(4, 3, 2));
        dataset.add(Utils.generateList(1, 3, 10));
        CommutableIslandsKruskal cik = new CommutableIslandsKruskal();
        System.out.println(cik.solve(4,dataset));
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<String,Integer> weights = new HashMap<>();
        int sum = 0;
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A;i++) {
            graph.add(new HashSet<>());
        }

        for(ArrayList<Integer> edge : B){
            if(edge.get(1).intValue() == edge.get(0)){
                continue;
            }
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            String key = v1 > v2 ? v2+"_"+v1 : v1+"_"+v2;
            if(weights.getOrDefault(key,Integer.MAX_VALUE) > edge.get(2)){
                weights.put(key,edge.get(2));
            }

            graph.get(v1).add(v2);
        }

        HashMap<Integer,ArrayList<String>> edgeMap = new HashMap<>();
        for(String key : weights.keySet()){
            if(!edgeMap.containsKey(weights.get(key))){
                edgeMap.put(weights.get(key),new ArrayList<>());
            }
            edgeMap.get(weights.get(key)).add(key);
        }

        int[] parent = new int[A+1];
        for(int i=1;i<=A;i++){
            parent[i] = i;
        }

        ArrayList<Integer> sortedEdges = new ArrayList<>(edgeMap.keySet());
        Collections.sort(sortedEdges);
        int totalEdges = 0;
        for(int edge : sortedEdges){
            for(String vertices : edgeMap.get(edge)){
                if(totalEdges == A-1){
                    return sum;
                }
                int[] v = Arrays.stream(vertices.split("_")).mapToInt(Integer::parseInt).toArray();
                if(union(v[0],v[1],parent)){
                    sum+=edge;
                }
            }
        }

        return sum;
    }

    public boolean union(int x, int y, int[] parent){
        int pX = findParent(x,parent);
        int pY = findParent(y,parent);
        if(pX == pY){
            return false;
        }
        updateParent(y,pX,parent);
        return true;
    }

    public void updateParent(int x, int newParent, int[] parent){
        while(x != parent[x]){
            int temp = parent[x];
            parent[x] = newParent;
            x = temp;
        }
        parent[x] = newParent;
    }
    public int findParent(int x, int[] parent){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }


}
