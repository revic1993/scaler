package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElements {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1,1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,1,1));
        System.out.println(Arrays.toString(solve(A,B).toArray()));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> commonElementsFreq = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();
        for(int a : A){
            if(commonElementsFreq.containsKey(a)){
                commonElementsFreq.put(a,commonElementsFreq.get(a)+1);
                continue;
            }
            commonElementsFreq.put(a,1);
        }

        for(int b : B){
            if(!commonElementsFreq.containsKey(b)){
                continue;
            }

            int freq = commonElementsFreq.get(b);
            if(freq == 0){
                continue;
            }

            freq--;
            commonElementsFreq.put(b,freq);
            result.add(b);
        }
        return result;
    }
}