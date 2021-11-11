package dsa.scaler.math.prime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class PrimeSum {
    public static void main(String[] args) {
        int[] testSet = {4,6,8,10,12,14,16,1048574};
        for(int testData : testSet){
            System.out.println(testData + " -> "+ Arrays.toString(primeSum(testData)));
        }
    }
    public static int[] primeSum(int A) {
        HashSet<Long> primeNum = new HashSet<>();
        for(int i=2;i<=A;i++){
            primeNum.add((long) i);
        }

        for(int i=2;i*i<=A;i++){
            for(long j=i*i;j<=A;j+=i){
                if(primeNum.contains(j)){
                    primeNum.remove(j);
                }
            }
        }

        Iterator<Long> it = primeNum.iterator();
        while(it.hasNext()){
            long next = it.next();
            int search = (int) (A - next);
            if(primeNum.contains((long)search)){
                return new int[]{(int) next,search};
            }
        }
        return new int[]{};
    }
}
