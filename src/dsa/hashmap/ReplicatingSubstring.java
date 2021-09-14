package dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ReplicatingSubstring {

    public static void main(String[] args){
        ReplicatingSubstring rss = new ReplicatingSubstring();

        HashMap<Integer,String> dataset = new HashMap<>();
        dataset.put(2,"abbbab");
        //dataset.put(1,"bc");
        //dataset.put(1,"bcbcbc");
       // dataset.put(2,"bcbcbc");
       // dataset.put(3,"bcbcbc");
        //dataset.put(3,"abcabcabd");

        //for(int key : dataset.keySet()){
          //  System.out.println("To group "+dataset.get(key)+" in "+key+" different groups is "+ (rss.solve(key,dataset.get(key))==1 ? "Possible" : "Not Possible"));
        //}
        System.out.println(Integer.parseInt("21st"));
        System.out.println(Integer.parseInt("21th"));
        System.out.println(Integer.parseInt("22h"));
    }

    public int solve(int A,String B){
        char[] characters = B.toCharArray();
        if(characters.length % A != 0) return -1;

        HashMap<Character,Integer> characterFreq = new HashMap<>();

        for(char c : characters){
            if(!characterFreq.containsKey(c)){
                characterFreq.put(c,1);
                continue;
            }
            characterFreq.put(c,characterFreq.get(c)+1);
        }

        Set<Character> keys = characterFreq.keySet();

        int moduloSum = 0;

        for(char key : keys){
            moduloSum += characterFreq.get(key) % A;
        }

        return moduloSum == 0 ? 1 : -1;
    }

}
