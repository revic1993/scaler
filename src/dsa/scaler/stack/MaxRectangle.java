package dsa.scaler.stack;

import dsa.utils.Utils;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        MaxRectangle mr = new MaxRectangle();
        System.out.println(mr.solve(new int[][]{
                {1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 1}
        }));

        System.out.println(mr.solve(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 0},
        }));
    }

    public int solve(int[][] A) {
        int[][] totalContinuousOne = totalContinuousOne(A);
        int[][] nearestBottom = nearestBottom(totalContinuousOne);
        int[][] nearestTop = nearestTop(totalContinuousOne);

        Utils.printIntArr(totalContinuousOne,"Total Continuous 1s");
        Utils.printIntArr(nearestBottom,"Nearest Bottom");
        Utils.printIntArr(nearestTop,"Nearest Top");
        int[][] result = new int[A.length][A[0].length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                int multiplier = totalContinuousOne[i][j];
                if(multiplier == 0){
                    continue;
                }
                int base = nearestBottom[i][j] - nearestTop[i][j]-1;
                maxArea = Math.max(base*multiplier,maxArea);
                result[i][j] = base*multiplier;
            }
        }
        Utils.printIntArr(result,"result");
        return maxArea;
    }

    public int[][] totalContinuousOne(int[][] A){
        int[][] result = new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            int max = 0;
            for(int j=A[0].length-1;j>=0;j--){
                if(A[i][j] == 0){
                    max = 0;
                    continue;
                }
                result[i][j] = ++max;
            }
        }
        return result;
    }

    int[][] nearestBottom(int[][] data){
        int[][] result = new int[data.length][data[0].length];
        for(int j=data[0].length-1;j>=0;j--){
            Stack<Integer> minBottom = new Stack<>();
            for(int i=data.length-1;i>=0;i--){
                int datum = data[i][j];
                while(!minBottom.isEmpty() && data[minBottom.peek()][j] >= datum){
                    minBottom.pop();
                }
                result[i][j] = minBottom.isEmpty() ? data.length : minBottom.peek();
                minBottom.push(i);
            }
        }
        return result;
    }

    int[][] nearestTop(int[][] data){
        int[][] result = new int[data.length][data[0].length];
        for(int j=0;j<data[0].length;j++){
            Stack<Integer> minBottom = new Stack<>();
            for(int i=0;i<data.length;i++){
                int datum = data[i][j];
                while(!minBottom.isEmpty() && data[minBottom.peek()][j] >= datum){
                    minBottom.pop();
                }
                result[i][j] = minBottom.isEmpty() ?  -1 : minBottom.peek();
                minBottom.push(i);
            }
        }
        return result;
    }

}
