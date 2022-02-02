package dsa.scaler.math;

public class VeryLargePower {
    public static void main(String[] args) {
        VeryLargePower vlp = new VeryLargePower();
        System.out.println(vlp.solve(51013,188812));
//        System.out.println(vlp.solve(3,6));
    }
    int mod = (int) (Math.pow(10,9)+7);
    public int solve(int A, int B) {
        long power = 1;
        while(B > 1){
            power = (power%(mod-1) * B--%(mod-1))%(mod-1);
        }
        return solveForPower(A, (int) power);
    }
    public int solveForPower(long A, int power) {
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
