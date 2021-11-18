package dsa.scaler.math.combinatrics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateCombinations {
    static ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();

    public static void main(String[] args) {
        int[][] testSet = {
                {6,3}
        };
        for(int[] testData : testSet){
           int[][] result = combine(testData[0],testData[1]);
           System.out.println("A => "+testData[0]+" B => "+testData[1]);
           System.out.println("====================================");
           for(int[] resultData : result){
               System.out.println(Arrays.toString(resultData));
           }
           System.out.println("====================================");
        }
    }

    public static int[][] combine(int A, int B) {
        resultSet = new ArrayList<>();
        if(B > A){
            return new int[][]{};
        }
        int[] data = new int[A];
        boolean[] visited = new boolean[A];

        for(int i=0;i<A;i++){
            data[i] = i+1;
        }

        for(int i=0;i<A-B+1;i++){
            generateCombination(new ArrayList<>(),B,data,i);
        }
        int[][] intRes = new int[resultSet.size()][B];
        int index = 0;
        for(ArrayList<Integer> resData : resultSet){
            intRes[index++] = resData.stream().mapToInt(Integer::intValue).toArray();
        }
        return intRes;
    }

    public static  void generateCombination(ArrayList<Integer> result, int B, int[] A, int startIndex){
        if(result.size() == B){
            resultSet.add((ArrayList<Integer>) result.clone());
            return;
        }
        result.add(A[startIndex]);
        if(result.size() == B){
            resultSet.add((ArrayList<Integer>) result.clone());
            return;
        }
        int nextIndex = startIndex+1;
        for(int i=nextIndex;i<A.length;i++){
            generateCombination(result,B,A,i);
            if(result.size()!=0){
                result.remove(result.size()-1);
            }
        }
    }
}
