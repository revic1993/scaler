package dsa.scaler.arrays.twopointers;

import java.util.ArrayList;
import java.util.List;

public class FindPairsForSum {
    int MOD = 1000000007;

    public static void main(String[] args) {
       FindPairsForSum fpfs = new FindPairsForSum();
        System.out.println(fpfs.solve(new ArrayList<>(List.of(  2, 4, 4, 5, 6, 8, 10)),6));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int i =0, j= A.size()-1;
        int totalPairs=0;
        while(i < j){
            int sum = A.get(i)+A.get(j);
            if(sum > B){
                j--;
            }else if(sum < B){
                i++;
            }else{
                int first = i;
                int second = j;

                if(A.get(i).intValue() == A.get(j)){
                    int totalNum = j-i+1;

                    if(totalNum == 1){
                        return totalPairs;
                    }

                    int odd = (totalNum & 1) == 1 ? totalNum : (totalNum-1);
                    int even = (totalNum & 1) == 0 ? totalNum >>1 : ((totalNum-1)>>1);
                    totalPairs = (totalPairs%MOD + (odd%MOD * even%MOD)%MOD)%MOD;
                    return totalPairs;
                }

                while(i<j && A.get(i).intValue() == A.get(first)){
                    i++;
                }

                while(j >= i && A.get(j).intValue() == A.get(second)){
                    j--;
                }

                first = i-first == 0 ? 1 : i-first;
                second = j-second == 0 ? 1 : j-second;
                second = Math.abs(second);
                totalPairs = (totalPairs%MOD + (first%MOD * second%MOD)%MOD)%MOD;
            }
        }
        return totalPairs;
    }
}
