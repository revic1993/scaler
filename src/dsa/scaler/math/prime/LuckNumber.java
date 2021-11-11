package dsa.scaler.math.prime;

import java.util.*;

public class LuckNumber {

    public static void main(String[] args) {
        int[] testSet = new int[]{
                50,
                78
        };
        for(int testData : testSet){
            System.out.println(testData + " => "+solve(testData));
        }
    }

    public static int solve(int A) {
        HashSet<Integer> primeNums = new HashSet<>();
        HashSet<Integer> primePower = new HashSet<>();
        int limit = A >> 1;

        for(int i=2;i<=limit;i++){
            primeNums.add(i);
        }



        for(int i=2;i<=limit;i++){
            int lastPower = i*i;
            for(int j=i;j<=limit;j+=i){
                if(i == j){
                    continue;
                }

                if(lastPower == j && !primePower.contains(lastPower)){
                    primePower.add(lastPower);
                    lastPower = i * lastPower;
                    continue;
                }
                primeNums.remove(j);
            }
        }
        System.out.println("primePower => " + primePower);
        System.out.println("primeNums => "+primeNums);
        return 10;
//        return primeNums.size();

    }
}
