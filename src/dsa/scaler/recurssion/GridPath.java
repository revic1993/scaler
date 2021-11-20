package dsa.scaler.recurssion;

import java.util.Arrays;
import java.util.HashMap;

public class GridPath {
    public static void main(String[] args) {
        int testSet[][] = {
                {1,1},
                {1,2},
                {1,3},
                {2,1},
                {2,2},
                {2,3},
                {3,1},
                {3,2},
                {3,3}
        };
        GridPath gp = new GridPath();
        for(int[] testData : testSet){
            System.out.println("For grid of "+ Arrays.toString(testData)+" total paths are "+gp.uniquePaths(testData[0],testData[1]));
        }
    }
    public int uniquePaths(int A, int B) {
        int[][] grid = new int[A][B];
        int startRow = A-1, startCol = B-1;
        grid[startRow][startCol] = 1;

        if(A <=1 || B <=1){
            return 1;
        }

        while(startRow > 0 || startCol > 0){
            for(int i=startRow;i>=0;i--){
                if(i+1 == A || startCol+1 == B){
                    grid[i][startCol] = 1;
                    continue;
                }
                grid[i][startCol] = grid[i+1][startCol] + grid[i][startCol+1];
            }

            for(int j=startCol;j>=0;j--){
                if(j+1 == B || startRow+1 == A){
                    grid[startRow][j] = 1;
                    continue;
                }
                grid[startRow][j] = grid[startRow+1][j] + grid[startRow][j+1];
            }

            if(startRow > 0){
                startRow--;
            }

            if(startCol > 0){
                startCol--;
            }
        }
        grid[0][0] = grid[1][0] + grid[0][1];
        return grid[0][0];
    }
//    public int uniquePaths(int A, int B) {
//        HashMap<String,Integer> memo = new HashMap<>();
//        return this.returnPaths(0,0,memo,A,B);
//    }

    public int returnPaths(int row,int col,HashMap<String,Integer> memo,int A,int B){
        String key = row+","+col;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(row == A-1 || col == B-1){
            memo.put(key,1);
            return 1;
        }
        int total = this.returnPaths(row+1,col,memo,A,B)+this.returnPaths(row,col+1,memo,A,B);
        memo.put(key,total);

        return total;
    }
}
