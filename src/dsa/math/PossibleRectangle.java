package dsa.math;



public class PossibleRectangle {
    public static void main(String[] args){
        System.out.println(canFormRectangle(2,5,3,4));
    }

    public static int canFormRectangle(int A,int B,int C,int D){
        if(A == B){
            return D == C ? 1 : 0;
        }

        if(A == C){
            return D == B ? 1 : 0;
        }

        if(A == D){
            return B == C ? 1 : 0;
        }

        return 0;
    }
}
