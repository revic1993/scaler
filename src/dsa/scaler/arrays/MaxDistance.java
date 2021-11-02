package dsa.scaler.arrays;

public class MaxDistance {
    public static void main(String[] args) {

    }

    public static int maximumGap(final int[] A){
        //Brute force approach
        int maxGap = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                if(A[i]<=A[j]){
                    maxGap = Math.max(maxGap,j-i);
                }
            }
        }
        return maxGap;
    }
}
