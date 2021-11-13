package dsa.scaler.recurssion;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePermutations {
    public static void main(String[] args) {
        int[][] testSet = {
                {1,2,3,4}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " => : [ ");
            int[][] test = permute(testData);
            for(int[] testVal : test){
                System.out.println(Arrays.toString(testVal));
            }
            System.out.println("]");
        }
    }

    public static int[][] permute(int[] A) {
        int[] numFreq = new int[A.length];
        Arrays.fill(numFreq, 1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(A,numFreq,new ArrayList<>(),result);
        int[][] resultVal = new int[result.size()][A.length];
        int i = 0;
        for(ArrayList<Integer> resData : result){
            resultVal[i++] = resData.stream().mapToInt(Integer::intValue).toArray();
        }
        return resultVal;
    }

    public static void solve(int[] A,int[] numFreq,ArrayList<Integer> currentList,ArrayList<ArrayList<Integer>> result){
        if(currentList.size() == A.length){
            result.add((ArrayList<Integer>) currentList.clone());
            return;
        }

        for(int i=0;i<numFreq.length;i++){
            if(numFreq[i] == 0){
                continue;
            }

            currentList.add(A[i]);
            numFreq[i] = 0;
            solve(A,numFreq,currentList,result);
            numFreq[i] = 1;
            currentList.remove(currentList.size()-1);
        }
    }
}
