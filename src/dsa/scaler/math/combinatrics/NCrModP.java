package dsa.scaler.math.combinatrics;

public class NCrModP {
    public static void main(String[] args) {
        NCrModP nmp = new NCrModP();
        System.out.println(nmp.solve(6,2,13));
    }
    public int solve(int A, int B, int C) {
        long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (int i=0; i<B; i++) {
            numerator = (numerator * (A-i) ) % C;
        }

        long denominator = 1; // B!
        for (int i=1; i<=B; i++) {
            denominator = (denominator * i) % C;
        }

        return (int) (( numerator* modInverse(denominator,C) ) % C);
    }
    long modInverse(long a, long p) {
        return solveForPower(a, p-2, p);
    }
    public int solveForPower(long A, long power, long mod) {
        long ans = 1;
        long a = A;
        while(power > 0){
            if(power%2 == 0){
                a = (a%mod*a%mod)%mod;
                power = power/2;
            }else{
                ans = (ans%mod*a%mod)%mod;
                a = (a%mod*a%mod)%mod;
                power = (power-1)/2;
            }
        }
        return (int) (ans%mod);
    }
}
