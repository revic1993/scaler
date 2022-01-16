package dsa.scaler.math;

public class ConsecutiveSum {
    public static void main(String[] args) {
        ConsecutiveSum cs = new ConsecutiveSum();
        System.out.println(cs.solve(3));
    }

    public int solve(int A) {
        if(A <= 2){
            return 1;
        }
        int root = ((int)Math.sqrt((A<<1)));
        int totalCom = 0;
        for(int i=1;i<=root;i++){
            int termMul = (i*(i-1))>>1;
            int total = A - termMul;
            if(total % i == 0){
                totalCom++;
            }
        }
        return totalCom;
    }
}
