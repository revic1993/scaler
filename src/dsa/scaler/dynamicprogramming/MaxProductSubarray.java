package dsa.scaler.dynamicprogramming;

public class MaxProductSubarray {

    public static void main(String[] args) {
        MaxProductSubarray mps = new MaxProductSubarray();
        System.out.println(mps.maxProduct(new int[]{0, 3, 3, 0}));
    }

    public int maxProduct(final int[] A) {
        int max = A[A.length-1];
        int min = A[A.length-1];
        int res = max;
        for(int i=A.length-2;i>=0;i--){
            int fp = max * A[i];
            int sp = min * A[i];
            max = Math.max(fp,Math.max(A[i],sp));
            min = Math.min(fp,Math.min(A[i],sp));
            res = Math.max(res,max);
        }
        return max;
    }
}
