package dsa.scaler.recurssion;

import dsa.utils.JSONConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.CDATASection;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum {
    static HashSet<ArrayList<Integer>> combinations = new HashSet<>();
    public static void main(String[] args) throws IOException {
        ArrayList<TestData> testSet = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();
        data.add(8);
        data.add(10);
        data.add(6);
        data.add(11);
        data.add(1);
        data.add(16);
        data.add(8);
        TestData td = new TestData(data,28);
        testSet.add(td);
        for (TestData testData : testSet) {
            ArrayList<ArrayList<Integer>> result = combinationSum(testData.getA(),testData.getB());
            JSONConverter.print(result);
        }
    }


    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            for (ArrayList<Integer> datum: generateCombination(A,B,i)) {
                Collections.sort(datum);
                combinations.add(datum);
            }
        }
        result.addAll(combinations);
        Collections.sort(result,new SortArrList());
        return result;
    }

    public static ArrayList<ArrayList<Integer>> generateCombination(ArrayList<Integer> A,int B,int index){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(B - A.get(index) == 0){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(A.get(index));
            result.add(res);
            return result;
        }

        if(B - A.get(index) < 0){
            return result;
        }

        for(int i=0;i<A.size();i++){
            ArrayList<ArrayList<Integer>> currentResult = generateCombination(A,B-A.get(index),i);
            if(currentResult.isEmpty() || currentResult.get(0).isEmpty()){
                continue;
            }

            for(ArrayList<Integer> resultData : currentResult){
                resultData.add(A.get(index));
            }
            result.addAll(JSONConverter.getTwoDimArrListCopy(currentResult));
        }
        return result;
    }

    static class SortArrList implements Comparator<ArrayList<Integer>>
    {
        @Override
        public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
            int i=0,j=0;
            int limit = Math.min(first.size(),second.size());

            while(i < limit && first.get(i).intValue() == second.get(i).intValue()){
                i++;
            }

            return first.get(i) - second.get(i) == 0 ? first.size() - second.size() : first.get(i) - second.get(i);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static
    class TestData{
        private ArrayList<Integer> A;
        private int B;
    }
}
