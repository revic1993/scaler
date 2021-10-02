package dsa.scaler.math;

public class KillTheMonsters {
    public static void main(String[] args) {
        int[] testSetA = {10, 13, 25, 14, 24, 49, 43, 48};
        int[] testSetB = { 38, 23, 47, 20, 49, 40, 22, 39};
        System.out.println(solve(testSetA,testSetB));
    }

    public static int solve(int[] A,int[] B){
        long sum = 0;
        long MOD = 1000000007;
        for(int i=0;i<A.length;i++){
            int prevInd = i>0 ? i-1 : A.length-1;
            sum += Math.max(0,A[i]-B[prevInd]);
        }

        long min = Long.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            int prevInd = i>0 ? i-1 : A.length-1;
            long currentBulletRequired = sum - Math.max(0,A[i]-B[prevInd]) + A[i];
            min = Math.min(min,currentBulletRequired);
        }

        return (int)(min%MOD);
    }
}
