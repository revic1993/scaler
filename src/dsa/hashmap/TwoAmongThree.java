package dsa.hashmap;

import java.util.*;

public class TwoAmongThree {

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,3,4));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,1,1));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1,1));
        System.out.println(Arrays.toString(solve(A,B,C).toArray()));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashSet<Integer> aSet = new HashSet<>(A);
        HashSet<Integer> bSet = new HashSet<>(B);
        HashSet<Integer> cSet = new HashSet<>(C);
        HashMap<Integer,Integer> numFreq = new HashMap<>();
        aSet.forEach(val -> numFreq.put(val,1));
        bSet.forEach(val -> {
            if(numFreq.containsKey(val)){
                numFreq.put(val,numFreq.get(val)+1);
                return;
            }
            numFreq.put(val,1);
        });
        cSet.forEach(val -> {
            if(numFreq.containsKey(val)){
                numFreq.put(val,numFreq.get(val)+1);
                return;
            }
            numFreq.put(val,1);
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int key: numFreq.keySet()){
            if(numFreq.get(key) >=2){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;

    }

}
