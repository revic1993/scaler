package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.*;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        int[][] dataset = {
        {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
        {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
        {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
        {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
        {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
        {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
        {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
        {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}};
        System.out.println(ro.solve(dataset));
    }
    public int solve(int[][] A) {
        int[][] timer = new int[A.length][A[0].length];
        Deque<Pair> roQueue = new LinkedList<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                timer[i][j] = -1;
                if(A[i][j] == 2){
                    Pair p = new Pair(i,j);
                    roQueue.add(p);
                    timer[i][j] = 0;
                }
            }
        }
        int maxTime = -1;

        while(!roQueue.isEmpty()){
            Pair current = roQueue.removeFirst();
            int i = current.i;
            int j = current.j;
            if(i > 0 && A[i-1][j] == 1 && timer[i-1][j] == -1){
                timer[i-1][j] = timer[i][j]+1;
                roQueue.add(new Pair(i-1,j));
            }

            if(j > 0 && A[i][j-1] == 1 && timer[i][j-1] == -1){
                timer[i][j-1] = timer[i][j]+1;
                roQueue.add(new Pair(i,j-1));
            }

            if(i+1 < A.length && A[i+1][j] == 1 && timer[i+1][j] == -1){
                timer[i+1][j] = timer[i][j]+1;
                roQueue.add(new Pair(i+1,j));
            }

            if(j+1 < A[0].length && A[i][j+1] == 1 && timer[i][j+1] == -1){
                timer[i][j+1] = timer[i][j]+1;
                roQueue.add(new Pair(i,j+1));
            }
        }
        Utils.printIntArr(timer,"timer");
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1 && timer[i][j] == -1){
                    return 0;
                }
                maxTime = Math.max(maxTime,timer[i][j]);
            }
        }
        return maxTime == -1 ? 0 : maxTime;
    }

    static class Pair{
        int i;
        int j;

        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "{" +
                    "i: " + i +
                    ", j: " + j +
                    '}';
        }
    }

}
