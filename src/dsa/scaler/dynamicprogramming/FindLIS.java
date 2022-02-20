package dsa.scaler.dynamicprogramming;

public class FindLIS {
    public static void main(String[] args) {
        FindLIS fl = new FindLIS();
        System.out.println(fl.findLIS(new int[]{5, 6, 3, 7, 9}));
    }
    public int findLIS(final int[] A) {
        int result = 0;
        int[] LIS = new int[A.length];
        LIS[0] = A[0];
        int maxLIS = 1;
        for(int i=1;i<A.length;i++){
            if(LIS[maxLIS-1] < A[i]){
                maxLIS++;
                LIS[maxLIS-1] = A[i];
            }else{
                int pos = findPos(LIS,maxLIS-1,A[i]);
                LIS[pos] = A[i];
            }
        }
        return maxLIS;
    }

    int findPos(int[] LIS, int high,int target){
        int low = 0;
        int ans=0;
        while(low <= high){
            int m = (low+high) >> 1;
            if(LIS[m] < target){
                low = m+1;
            }else{
                ans = m;
                high = m-1;
            }
        }
        return ans;
    }
}
