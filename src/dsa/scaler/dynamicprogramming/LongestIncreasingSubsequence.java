package dsa.scaler.dynamicprogramming;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }

    public int lis(final int[] A) {
        int result = 0;
        int[] LIS = new int[A.length];

        for(int i=0;i<A.length;i++){
            LIS[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(A[i] > A[j]){
                    LIS[i] = Math.max(LIS[j]+1,LIS[i]);
                }
            }
            result = Math.max(result,LIS[i]);
        }
        return result;
    }
}
