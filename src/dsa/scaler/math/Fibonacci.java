package dsa.scaler.math;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(15));
    }

    public static HashMap<Integer,Integer> fib(int A){
        HashMap<Integer,Integer> fibMap = new HashMap<>();
        fibMap.put(1,1);
        fibMap.put(2,1);
        for(int i=3;i<=A;i++){
            fibMap.put(i,fibMap.get(i-1)+fibMap.get(i-2));
        }
        return fibMap;
    }
}
