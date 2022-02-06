package dsa.scaler.dynamicprogramming;

import java.util.HashMap;

public class NDigitSum {
    public static void main(String[] args) {
        NDigitSum nDigitSum = new NDigitSum();
        System.out.println(nDigitSum.solve(2,4));
    }
    int mod = 1000000007;
    HashMap<String,Integer> memo = new HashMap<>();

    public int solve(int A, int B) {
        return totalSum(A,A,B);
    }

    public int totalSum(int pendingChances,int actualChances,int num){
        String key = pendingChances+"_"+num;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(pendingChances == 1){
            memo.put(key,num <= 9 ? 1 : 0);
            return num <= 9 ? 1 : 0;
        }

        int total = 0;
        int startWith = pendingChances == actualChances ? 1 : 0;
        for(int i=startWith;i<=9;i++){
            if(num-i >=0){
                total = (total%mod+totalSum(pendingChances-1,actualChances,num-i)%mod)%mod;
            }
        }
        memo.put(key,total);
        return total;
    }
}
