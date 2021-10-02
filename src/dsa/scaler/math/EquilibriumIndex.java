package dsa.scaler.math;

public class EquilibriumIndex {
    public static void main(String[] args) {

    }


    public int solve(int[] A) {
        int ls = 0;
        int rs = 0;

        for(int i=0;i<A.length;i++){
            rs+=A[i];
        }

        for(int i=0;i<A.length;i++){
            rs-=A[i];
            if(ls == rs){
                return i;
            }
            ls += A[i];
        }

        return -1;
    }
}
