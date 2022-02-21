package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MakeCircle {
    public static void main(String[] args) {
        MakeCircle mc = new MakeCircle();
        System.out.println(mc.solve(Utils.generateList( "zaz", "zbz", "zaz", "zdz")));
    }

    public int solve(ArrayList<String> A) {
        StrFreqMap sfm = new StrFreqMap();
        int[] map = new int[A.size()];
        for(int i=0;i<A.size();i++){
            sfm.addString(A.get(i),i);
        }

        for(int i=0;i<A.size();i++){
            int idx = sfm.getMatch(A.get(i),i,A.size()-1);
            if(idx == -1){
                return 0;
            }
            map[i] = idx;
        }

        int jumps = 0;
        int current = 0;
        while(jumps <= A.size()-1 && map[current] != 0){
            current = map[current];
            jumps++;
        }


        return jumps == A.size()-1 && map[current] == 0 ? 1 : 0;
    }


    static class StrFreqMap{
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        StrFreqMap(){
            for(int i='a';i<='z';i++){
                this.map.put((char)i,new HashSet<>());
            }
        }

        void addString(String s,int index){
           char startsWith = s.charAt(0);
           map.get(startsWith).add(index);
        }

        int getMatch(String current,int cInd,int lastIdx){
            char startsWith = current.charAt(current.length()-1);
            for (int next : this.map.get(startsWith)) {
                if(cInd == lastIdx && next != 0){
                    continue;
                }
                if (next != cInd ) {
                    this.map.get(startsWith).remove(next);
                    return next;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return map.toString();
        }
    }

}
