package dsa.arrays;

public class MaxPathInTriangle {
    public static void main(String[] args) {
        int A[][] = {
            {8, 0},
            {4, 5}
        };
        System.out.println(solve(A));
    }

    public static int solve(int[][] A) {
        int N = A.length - 1;

        for(int i=N;i>=0;i--){
            for(int j=0;j<i;j++){
                if(i == N){
                    A[i][j] = Math.max(A[i][j], A[i][j + 1]);
                    continue;
                }
                A[i][j] = Math.max( (A[i][j] + A[i+1][j]),(A[i][j+1]+A[i+1][j+1]));
            }
        }
        A[0][0] = A[0][0]+A[1][0];
        return A[0][0];
    }
}
