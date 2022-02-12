package dsa.scaler.dynamicprogramming;

public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum mps = new MinPathSum();
        System.out.println(mps.minPathSum(new int[][]{
                {1,3,2},
                {4,3,1},
                {5,6,1}
        }));
    }

    public int minPathSum(int[][] A) {
        for(int i=A.length-1;i>=0;i--){
            for(int j=A[0].length-1;j>=0;j--){
                if(i == A.length-1 && j == A[0].length-1){
                    continue;
                }
                int rightVal = j+1 == A[0].length ? Integer.MAX_VALUE : A[i][j+1]+A[i][j];
                int bottomVal = i+1 == A.length ? Integer.MAX_VALUE : A[i+1][j]+A[i][j];
                A[i][j] = Math.min(rightVal,bottomVal);
            }
        }
        return A[0][0];
    }
}
