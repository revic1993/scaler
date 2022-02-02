package dsa.scaler.greedy;

public class MinCoins {
    public static void main(String[] args) {
        MinCoins mc = new MinCoins();
        System.out.println(mc.solve(3125));
    }
    public int solve(int A) {
        int totalCoins = Integer.MAX_VALUE;
        int maxNum = getMaxDivisor(A);
        while(maxNum >= 1){
            totalCoins = Math.min(totalCoins,getTotalCoins(A,maxNum));
            maxNum/=5;
        }
        return totalCoins;
    }

    public int getTotalCoins(int A,int max){
        if(max == 1){
            return A;
        }
        int totalCoins=0;
        while(A > 0){
            totalCoins += (A/max);
            A = A%max;
            max/=5;
        }
        return totalCoins;
    }

    public int getMaxDivisor(int A){
        int current = 1;
        while(current <= A){

            current*=5;
        }
        current/=5;
        return Math.max(current,1);
    }
}
