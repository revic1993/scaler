package dsa.scaler.dynamicprogramming.knapsack;

public class WaysToSendSignal {
    public static void main(String[] args) {
        WaysToSendSignal wts = new WaysToSendSignal();
        System.out.println(wts.solve(25));
    }
    public int solve(int A) {
        long ways = 2;
        long startsWithOne = 1;

        int mod = 1000*1000*1000+7;
        for(int i=2;i<=A;i++){
            startsWithOne = (ways%mod-startsWithOne%mod + mod)%mod;
            ways = (ways%mod+startsWithOne%mod)%mod;
        }
        return (int) ways;
    }
}
