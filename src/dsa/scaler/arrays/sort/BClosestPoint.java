package dsa.scaler.arrays.sort;

import dsa.utils.JSONConverter;

import java.util.*;

public class BClosestPoint {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
        testData.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        testData.add(new ArrayList<Integer>(Arrays.asList(-2,2)));
        BClosestPoint bcp = new BClosestPoint();
        JSONConverter.print(bcp.solve(testData,1));
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        A.sort((a1, a2) -> (a1.get(0) * a1.get(0) - a2.get(0) * a2.get(0) + a1.get(1) * a1.get(1) - a2.get(1) * a2.get(1)));
        return new ArrayList<>(A.subList(0,B));
    }
}
