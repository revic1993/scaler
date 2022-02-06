package dsa.scaler.dynamicprogramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinPathTriangle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dataSet = new ArrayList<>();
        dataSet.add(new ArrayList<>(List.of(2)));
        dataSet.add(new ArrayList<>(List.of(3,4)));
        dataSet.add(new ArrayList<>(List.of(6,5,7)));
        dataSet.add(new ArrayList<>(List.of(4,1,8,3)));
        MinPathTriangle mpt = new MinPathTriangle();
        System.out.println(mpt.minimumTotal(dataSet));
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        if(N==1){
            return A.get(0).get(0);
        }
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            dp.add(new ArrayList<>());
        }

        for(int i=N-1;i>0;i--){
            for(int j=0;j<A.get(i).size()-1;j++){
                int addFirst = i == N-1 ? 0 : dp.get(i).get(j);
                int addSecond = i == N-1 ? 0 : dp.get(i).get(j+1);

                dp.get(i-1).add(Math.min(A.get(i).get(j)+addFirst,A.get(i).get(j+1)+addSecond));
            }
        }
        return dp.get(0).get(0)+A.get(0).get(0);
    }
}
