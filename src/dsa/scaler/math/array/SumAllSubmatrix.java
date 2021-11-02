package dsa.scaler.math.array;

public class SumAllSubmatrix {

    public static void main(String[] args) {

    }

    public static int solve(int[][] A) {
        int N = A.length;
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum += (i+1)*(j+1)*(N-i)*(N-j)*A[i][j];
            }
        }
        return sum;
    }


}
