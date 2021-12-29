package dsa.scaler.arrays.sort;

import dsa.utils.Utils;

public class AlternatePositiveNegativeElement {
    public static void main(String[] args) {
        AlternatePositiveNegativeElement alpne = new AlternatePositiveNegativeElement();
        Utils.printIntArr(alpne.solve(new int[]{5, -17, -100, -11}));
    }

    public int[] solve(int[] A) {
        int totalPositive = 0;
        int totalNegative = 0;

        for(int a : A){
            totalPositive+= a >= 0 ? 1 : 0;
            totalNegative+= a < 0 ? 1 : 0;
        }

        for(int i=0;i<A.length;i++){
            if(totalNegative == 0 || totalPositive == 0){
                break;
            }

            boolean currentNegative = (i & 1) == 0;

            if(A[i] < 0 && currentNegative){
                totalNegative--;
                continue;
            }

            if(A[i] >= 0 && !currentNegative){
                totalPositive--;
                continue;
            }

            int j = i+1;
            if(currentNegative){
                while(j < A.length && A[j] >= 0){
                    j++;
                }
            }else{
                while(j < A.length && A[j] < 0){
                    j++;
                }
            }
            while(j!=i){
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                j--;
            }
            if(currentNegative){
                totalNegative--;
            }else{
                totalPositive--;
            }
        }
        return A;
    }
}
