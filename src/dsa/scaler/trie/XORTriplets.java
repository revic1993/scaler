package dsa.scaler.trie;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class XORTriplets {

    public static void main(String[] args) {
        XORTriplets xot = new XORTriplets();
        System.out.println(xot.solve(new ArrayList<>(List.of(5,2,7))));
    }
    public int solve(ArrayList<Integer> A) {
        int totalTriplets = 0;
        int mod = (int)(Math.pow(10,9)+7);
        HashMap<Integer,ArrayList<Integer>> prefixIndexMap = new HashMap<>();
        int p = 0;
        prefixIndexMap.put(0,new ArrayList<>());
        prefixIndexMap.get(0).add(0);
        for(int i=0;i<A.size();i++){
            p = p^A.get(i);
            if(!prefixIndexMap.containsKey(p)){
                prefixIndexMap.put(p,new ArrayList<>());
            }
            prefixIndexMap.get(p).add(i+1);
        }
        for(int key : prefixIndexMap.keySet()){
            if(prefixIndexMap.get(key).size() < 2){
                continue;
            }
            ArrayList<Integer> positions = prefixIndexMap.get(key);
            for(int i=0;i<positions.size();i++){
                for(int k=i+1;k<positions.size();k++){
                    int currentTotal = positions.get(k)-positions.get(i)-1;
                    totalTriplets = (totalTriplets%mod + currentTotal%mod)%mod;
                }
            }
        }
        return totalTriplets;
    }
}
