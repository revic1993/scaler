package dsa.scaler.heaps;

public class WaysToFormMaxHeap {
    int mod = (int) (Math.pow(10,9)+7);

    public static void main(String[] args) {
        WaysToFormMaxHeap wtfm = new WaysToFormMaxHeap();
//        System.out.println(wtfm.solve(68));
        System.out.println(wtfm.solve(100));
//        System.out.println(wtfm.modBinomial(18,7,wtfm.mod));
    }

    public int solve(int A) {
        return (int) (ways(A)%mod);
    }

    public long ways(int N){
        if(N <= 2){
            return 1;
        }
        int L = getLeftChildren(N);
        int R = N-L-1;
        long ncl = modBinomial(N-1,L,mod);
        long LR = (ways(L)%mod * ways(R)%mod)%mod;
        return (ncl%mod * LR%mod)%mod;
    }


    long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while(x > 0) {
            if( x % 2 != 0) {
                res = (res * a) % p;
            }
            a = (a * a) % p;
            x /= 2;
        }
        return res;
    }

    long modInverse(long a, long p) {
        return modPow(a, p-2, p);
    }
    long modBinomial(long n, long k, long p) {

        long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (int i=0; i<k; i++) {
            numerator = (numerator * (n-i) ) % p;
        }

        long denominator = 1; // k!
        for (int i=1; i<=k; i++) {
            denominator = (denominator * i) % p;
        }

        return ( numerator* modInverse(denominator,p) ) % p;
    }


    int getLeftChildren(int N){
        int h = log2(N);
        int maxNodes = 1 << h;
        return Math.min((maxNodes >> 1),N-(maxNodes-1))+((maxNodes >> 1) - 1);
    }

    int log2(int N)
    {
        return (int)(Math.log(N) / Math.log(2));
    }
}



//    public long ncr(int n, int r){
//
//        if(n-r < r){
//            r = n-r;
//        }
//        if(r == 1){
//            return n;
//        }
//        int m = n-r+1;
//        int d = 1;
//        long result = 1;
//        while(m <= n){
//            long gcd = findGCD(m,d);
//            result = (result%mod * (((m/gcd))%mod * ((d/gcd))%mod)%mod)%mod;
//            m++;
//            d++;
//        }
//        return result;
//    }
//
//    long findGCD(long A, long B){
//        if(A==0 || B==0){
//            return A == 0 ? B : A;
//        }
//
//        if(A==1 || B==1){
//            return 1;
//        }
//
//        if(A > B){
//            long temp = A;
//            A = B;
//            B = temp;
//        }
//
//        while(A > 0){
//            long t = B%A;
//            B = A;
//            A = t;
//        }
//
//        return A == 0 ? B : A;
//    }