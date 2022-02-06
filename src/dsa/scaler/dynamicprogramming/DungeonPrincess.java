package dsa.scaler.dynamicprogramming;

import dsa.utils.Utils;

import java.util.ArrayList;

public class DungeonPrincess {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        data.add(Utils.generateList(1, -1, 0));
        data.add(Utils.generateList(-1, 1, -1));
        data.add(Utils.generateList(1, 0, -1));
        DungeonPrincess dp = new DungeonPrincess();
        System.out.println(dp.calculateMinimumHP(data));
    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int N = A.size()-1;
        int M = A.get(0).size()-1;

        for(int i=N;i>=0;i--){
            for(int j=M;j>=0;j--){
                if(i == N && j==M){
                    A.get(i).set(j, Math.max(1,1-A.get(i).get(j)));
                    continue;
                }
                int currVal = A.get(i).get(j);
                if(i+1 <= N && j+1 > M){
                    A.get(i).set(j, Math.max(1,A.get(i+1).get(j)-currVal));
                }else if(i+1 > N && j+1<=M){
                    A.get(i).set(j, Math.max(1,A.get(i).get(j+1)-currVal));
                }else{
                    A.get(i).set(j,Math.max(1,Math.min(A.get(i+1).get(j)-currVal,A.get(i).get(j+1)-currVal  )));
                }
            }
        }
        return A.get(0).get(0);
    }
}
