package dsa.scaler.dynamicprogramming;

import java.util.HashMap;

public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(34));
    }
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int climbStairs(int A) {
        if(A <= 1){
            return 1;
        }

        if(memo.containsKey(A)){
            return memo.get(A);
        }

        int val = climbStairs(A-1)+climbStairs(A-2);
        memo.put(A,val);
        return val;
    }


}
