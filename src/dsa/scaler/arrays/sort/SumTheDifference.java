package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTheDifference {
    ArrayList<Integer> countArr = new ArrayList<>();
    int MOD = 1000000007;
    public int solve(ArrayList<Integer> A) {
        int[] powerArr = new int[A.size()];
        generatePowers(powerArr);
        countSort(A);
        long total = 0;
        for(int i=0;i<A.size();i++){
            int contribution;
            int right = A.size() - i - 1;
            contribution = powerArr[i] - powerArr[right];

            if(right > i && contribution > 0){
                contribution = -1 * (MOD + contribution);
            }

            total = (total%MOD + (A.get(i)%MOD * ((int)contribution%MOD))%MOD)%MOD;
            total = (MOD+total)%MOD;
        }
        return (int) total;
    }

    public void generatePowers(int[] powerArr){
        powerArr[0] = 1 ;
        for(int i=1;i<powerArr.length;i++){
            powerArr[i] = (powerArr[i-1]%MOD * 2) % MOD;
        }
    }

    public void countSort(ArrayList<Integer> A){
        for(int i=0;i<=1001;i++){
            countArr.add(0);
        }

        for(int a : A){
            countArr.set(a,countArr.get(a)+1);
        }

        int k = 0;
        for(int i=0;i<=1001;i++){
            for(int j=0;j<countArr.get(i);j++){
                A.set(k++,i);
            }
        }
    }
}
