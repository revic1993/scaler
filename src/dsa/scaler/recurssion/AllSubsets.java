package dsa.scaler.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class AllSubsets {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> testSet = new ArrayList<>();
        ArrayList<Integer> testData = new ArrayList<>();
        testData.add(1);
        testData.add(2);
        testData.add(3);
        testSet.add(testData);
        for(ArrayList<Integer> td : testSet){
            System.out.println(td + " => "+subsets(td));
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Stack<Stack<Integer>> result = subset(A,0);
        result.push(new Stack<>());
        Iterator<Stack<Integer>> resultItr = result.iterator();
        ArrayList<ArrayList<Integer>> retRes = new ArrayList<>();
        retRes.add(new ArrayList<>());
        while(resultItr.hasNext()){
            Stack<Integer> nextVal = resultItr.next();
            ArrayList<Integer> resInt = new ArrayList<>(nextVal);
            retRes.add(resInt);
        }
        return retRes;
    }

    public static Stack<Stack<Integer>> subset(ArrayList<Integer> A, int index){
        Stack<Integer> ele = new Stack<>();
        Stack<Stack<Integer>> result;
        ele.push(A.get(index));
        if(index == A.size()-1){
            result = new Stack<>();
            result.push(ele);
            return result;
        }

        Stack<Stack<Integer>> nextSubset = subset(A,index+1);
        result = (Stack<Stack<Integer>>) nextSubset.clone();
        for (Stack<Integer> integerStack : nextSubset) {
            integerStack.push(A.get(index));
        }
        for (Stack<Integer> integers : nextSubset) {
            result.push(integers);
        }
        result.push(ele);
        return result;
    }
}
