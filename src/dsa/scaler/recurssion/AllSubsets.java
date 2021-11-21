package dsa.scaler.recurssion;

import java.lang.reflect.Array;
import java.util.*;

public class AllSubsets {

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        testData.addAll(Arrays.asList(1,2,2));
        System.out.println(subsets(testData));
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> emptySet = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(emptySet);
        if(A.size() == 0){
            return result;
        }
        Collections.sort(A);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        result.addAll(subset(A,0));
        Iterator<ArrayList<Integer>> resItr = result.iterator();
        while(resItr.hasNext()){
            ArrayList<Integer> val = resItr.next();
            if(set.contains(val)){
                resItr.remove();
            }else{
                set.add(val);
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> A,int index){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(index == A.size()-1){
            ArrayList<Integer> currentSet = new ArrayList<>();
            currentSet.add(A.get(index));
            result.add(currentSet);
            return result;
        }

        ArrayList<ArrayList<Integer>> subsets = getTwoDimArrListCopy(subset(A,index+1));
        ArrayList<ArrayList<Integer>> subsetClone = getTwoDimArrListCopy(subsets);
        for(ArrayList<Integer> subset : subsets){
            subset.add(0,A.get(index));
        }
        ArrayList<Integer> currentSet = new ArrayList<>();
        currentSet.add(A.get(index));
        subsets.add(0,currentSet);
        result.addAll(subsets);
        result.addAll(subsetClone);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> getTwoDimArrListCopy(ArrayList<ArrayList<Integer>> original){
        ArrayList<ArrayList<Integer>> copy = new ArrayList<>();

        for (ArrayList<Integer> arr: original){
            copy.add(new ArrayList<Integer>(arr));
        }

        return copy;
    }

}
