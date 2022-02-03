package dsa.scaler.dynamicprogramming;

public class MaxSumWithoutAdjacent {
    public static void main(String[] args) {
        MaxSumWithoutAdjacent mswa = new MaxSumWithoutAdjacent();
        System.out.println(mswa.adjacent(new int[][]{
                {28},
                {10}
        }));
    }
    public int adjacent(int[][] A) {
        int[] maxNums = new int[A[0].length];
        maxNums[0] = Math.max(A[0][0],A[1][0]);
        if(A[0].length == 1){
            return maxNums[0];
        }
        maxNums[1] = Math.max(A[0][1],A[1][1]);
        for(int i=2;i<A[0].length;i++){
            int colMax = Math.max(A[0][i],A[1][i]);
            maxNums[i] = colMax+Math.max(maxNums[i-2],i < 3 ? Integer.MIN_VALUE : maxNums[i-3]);
        }
        return Math.max(maxNums[maxNums.length-1],maxNums[maxNums.length-2]);
    }
}
