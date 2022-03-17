package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.*;
import java.util.function.Function;

public class MakeCircle {
    public static void main(String[] args) {
        MakeCircle mc = new MakeCircle();
        System.out.println(mc.solve(Utils.generateList( "aab", "bac", "aaa", "cda")));
    }

    public int solve(ArrayList<String> A) {
        HashMap<Integer,Integer> parentWeight = new HashMap<>();
        HashMap<Character,ArrayList<Integer>> sameCharMap = new HashMap<>();
        int[] parent = new int[A.size()];
        for(int i=0;i<A.size();i++){
            parent[i] = i;
            parentWeight.put(i,1);
            char key = A.get(i).charAt(0);
            if(!sameCharMap.containsKey(key)){
                sameCharMap.put(key,new ArrayList<>());
            }
            sameCharMap.get(key).add(i);
        }
        int[] nextNode = new int[A.size()];
        Arrays.fill(nextNode,-1);
        for(int i=0;i<A.size()-1;i++){
            nextNode[i] = findNextNode(i,A.get(i),sameCharMap,parent,parentWeight);
        }
        int xor = 0;
        for(int i=0;i<A.size();i++){
            xor^=i;
        }
        int totalNeg = 0;

        for(int i=0;i<nextNode.length-1;i++){
            xor^=nextNode[i];
        }

        String lastVal = A.get(A.size()-1);
        if(xor != nextNode.length-1 && A.get(xor).charAt(0) == lastVal.charAt(lastVal.length()-1)){
            return 1;
        }

        return 0;
    }

    public int findNextNode(int i,String val,HashMap<Character,ArrayList<Integer>> charMap,int[] parent,HashMap<Integer,Integer> parentWeight){
        char key = val.charAt(val.length()-1);
        if(!charMap.containsKey(key)){
            return -1;
        }
        for(int neighbor : charMap.get(key)){
            if(neighbor == i){
                continue;
            }
            if(union(i,neighbor,parent,parentWeight)){
                return neighbor;
            }
        }
        return -1;
    }

    public boolean union(int x, int y,int[] parent,HashMap<Integer,Integer> parentWeight){
        int px = findParent(x,parent);
        int py = findParent(y,parent);
        if(px == py){
            return false;
        }
        if(parentWeight.get(px) > parentWeight.get(py)){
            updateParent(y,px,parent,parentWeight);
        }else{
            updateParent(x,py,parent,parentWeight);
        }
        return true;
    }
    public void updateParent(int x, int newParent, int[] parent,HashMap<Integer,Integer> parentWeight){
        int weight = parentWeight.get(newParent);
        while(x != parent[x]){
            int temp = parent[x];
            parent[x] = newParent;
            x = temp;
            weight++;
        }
        parentWeight.put(newParent,++weight);
        parent[x] = newParent;
    }
    public int findParent(int x,int[] parent){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }

}