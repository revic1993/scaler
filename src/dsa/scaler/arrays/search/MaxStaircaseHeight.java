package dsa.scaler.arrays.search;

public class MaxStaircaseHeight {
    public static void main(String[] args) {
        System.out.println(new MaxStaircaseHeight().solve(631974));
    }
    public int solve(int A) {
        int left =1;
        int right = A >> 1;
        int mid = -1;
        int ans = -1;
        if(A<=1){
            return A;
        }

        if(A <= 3){
            return A-1;
        }

        while(left <= right){
            mid = (left + right) >> 1;
            int even, odd;

            if((mid & 1) == 0){
                even = mid >> 1;
                odd = mid+1;
            }else{
                even = (mid+1) >> 1;
                odd = mid;
            }

            if(odd <= A/even){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }

        }

        return ans;
    }
}
