package dsa.scaler.dynamicprogramming;

public class CountMinSquares {
    public static void main(String[] args) {
        CountMinSquares cms = new CountMinSquares();
        System.out.println(cms.countMinSquares(12));
    }
    public int countMinSquares(int A) {
        int[] memo = new int[A+1];
        memo[0]=0;
        for(int i=1;i<=A;i++){
            memo[i] = i;
            for(int j = 1;j*j<=i;j++){
               memo[i] = Math.min(memo[i],memo[i-j*j]+1);
            }
        }
        return memo[A];
    }

}
