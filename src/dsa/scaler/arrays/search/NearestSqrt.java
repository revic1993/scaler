package dsa.scaler.arrays.search;

public class NearestSqrt {

    public static void main(String[] args) {
        int[] testSet = {6,10};
//        int[] testSet = {6,10};
        for(int testData : testSet){
            System.out.println(testData+" => "+new NearestSqrt().sqrt(testData));
        }
    }

    public int sqrt(int A) {
        int l = 1;
        int r = A >> 1;
        int ans = -1;
        if(A <= 3){
            return A == 0 ? 0 : 1;
        }

        while(l <= r){
            int mid = (l+r)>>1;
            if(mid <= A/mid){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}
