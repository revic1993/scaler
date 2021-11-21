package dsa.scaler.recurssion;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths {
    int totalCount = 0;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
        testData.add(new ArrayList<>(Arrays.asList(1,0,0,0)));
        testData.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        testData.add(new ArrayList<>(Arrays.asList(0,0,2,-1)));
        UniquePaths up = new UniquePaths();
        System.out.println(up.solve(testData));
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int totalZeros = 0;
        int r=0,c=0;

        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j) == 1){
                    r = i;
                    c = j;
                }
                if(A.get(i).get(j) == 0){
                    totalZeros++;
                }
            }
        }

        canWalk(A,r+1,c,totalZeros);
        canWalk(A,r,c+1,totalZeros);
        canWalk(A,r-1,c,totalZeros);
        canWalk(A,r,c-1,totalZeros);
        return totalCount;
    }

    public void canWalk(ArrayList<ArrayList<Integer>> A, int r, int c,int totalZeros){
        if(r >= A.size() || c >= A.get(0).size() || r < 0 || c < 0){
            return;
        }

        if(A.get(r).get(c) == -1){
            return;
        }

        if(A.get(r).get(c) == 2 && totalZeros != 0){
            return;
        }
        if(A.get(r).get(c) == 1){
            return;
        }


        if(totalZeros == 0 && A.get(r).get(c) == 2){
            totalCount++;
            return;
        }

        A.get(r).set(c,-1);
        System.out.println("( "+r+", "+c+" )");
        canWalk(A,r+1,c,totalZeros-1);
        canWalk(A,r,c+1,totalZeros-1);
        canWalk(A,r-1,c,totalZeros-1);
        canWalk(A,r,c-1,totalZeros-1);
        A.get(r).set(c,0);
        return;
    }
}
