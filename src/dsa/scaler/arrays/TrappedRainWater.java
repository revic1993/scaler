package dsa.scaler.arrays;

public class TrappedRainWater {

    public static void main(String[] args) {

    }

    public static int trap(final int[] A) {
        int[] rightMax = new int[A.length];
        int[] leftMax = new int[A.length];
        rightMax[A.length-1] = A[A.length-1];
        leftMax[0] = A[0];

        for(int i=1, j=A.length-2;i<A.length;i++,j--){
            rightMax[j] = Math.max(rightMax[j+1],A[j]);
            leftMax[i] = Math.max(leftMax[i-1],A[i]);
        }


        int totalTrappedWater = 0;
        for(int i=0;i<A.length;i++){
            totalTrappedWater += (Math.min(rightMax[i],leftMax[i]) - A[i]);
        }

        return totalTrappedWater;
    }
}
