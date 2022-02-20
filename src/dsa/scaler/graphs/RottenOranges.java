package dsa.scaler.graphs;

import dsa.utils.Utils;

import java.util.*;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        int[][] dataset = {
                {0, 2, 1},
                {2, 2, 1},
                {0, 1, 0},
                {2, 1, 1},
                {0, 1, 1},
                {1, 2, 1}
        };
        System.out.println(ro.solve(dataset));
    }
    public int solve(int[][] A) {
        int[][] timer = new int[A.length][A[0].length];
        Deque<Pair> roQueue = new LinkedList<>();
        Pair lastPair = null;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                timer[i][j] = -1;
                if(A[i][j] == 2){
                    Pair p = new Pair(i,j);
                    roQueue.add(p);
                    lastPair = p;
                }
            }
        }
        int maxTime = -1;
        int currentLevel = 0;
        while(!roQueue.isEmpty()){
            Pair pair = roQueue.removeFirst();
            int i = pair.i;
            int j = pair.j;
            if(timer[i][j] != -1){
                continue;
            }
            timer[i][j] = currentLevel;
            maxTime = Math.max(timer[i][j],maxTime);
            if(i > 0 && A[i-1][j]==1 && timer[i-1][j] == -1){
                roQueue.add(new Pair(i-1,j));
            }
            if(j > 0 && A[i][j-1]==1 && timer[i][j-1] == -1){
                roQueue.add(new Pair(i,j-1) );
            }
            if(i < A.length-1 && A[i+1][j]==1 && timer[i+1][j] == -1){
                roQueue.add(new Pair(i+1,j));
            }
            if(j < A[0].length-1 && A[i][j+1]==1 && timer[i][j+1] == -1){
                roQueue.add(new Pair(i,j+1));
            }
            if(lastPair == pair){
                lastPair = roQueue.peekLast();
                currentLevel++;
            }
        }

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 1 && timer[i][j]==-1){
                    return -1;
                }
            }
        }
        Utils.printIntArr(timer,"timer");
        return maxTime;
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
