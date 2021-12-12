package dsa.scaler.arrays.search;

public class AthMagicalNumber {
    public static void main(String[] args) {
        AthMagicalNumber amn = new AthMagicalNumber();
        System.out.println(amn.solve(807414236,3788,38141));
    }
    public int solve(int A, int B, int C) {
        int gcd = findGCD(B,C);
        int lcm = (B) * (C/gcd);
        long low = 1, high = (long) Math.min(B, C) *A;
        long ans = -1;
        while(low <= high){
            long mid = (low + ( (high - low )>>1 ));
            long totalNums = (mid/B)+(mid/C) - (mid/lcm);


            if(totalNums >= A){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int) (ans % 1000000007);
    }

    int findGCD(int A,int B){
        if(A==0 || B==0){
            return A == 0 ? B : A;
        }

        if(A==1 || B==1){
            return 1;
        }

        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }

        while(A > 0){
            int t = B%A;
            B = A;
            A = t;
        }

        return A == 0 ? B : A;
    }
}
