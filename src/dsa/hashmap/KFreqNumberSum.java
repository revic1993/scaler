package dsa.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KFreqNumberSum {
    public static void main(String[] args){
        ArrayList<Integer> sample = new ArrayList<>(Arrays.asList(2,3,2,3,4));
        System.out.println(getSum(5,1,sample));
    }

    public static int getSum(int A, int B, ArrayList<Integer> C){
        int sum = -1;
        int MOD = ((int) Math.pow(10, 9) + 7);
        HashMap<Integer,Integer> freqCounter = new HashMap<>();
        for(int c : C){

            if(!freqCounter.containsKey(c)){
                freqCounter.put(c,1);
            }else{
                freqCounter.put(c,freqCounter.get(c)+1);
            }

            int latestFreq = freqCounter.get(c);

            if(latestFreq != B && latestFreq!=B+1){
                continue;
            }

            if(latestFreq == B && sum == -1){
                sum = 0;
            }

            if(latestFreq == B){
                sum += c;
                continue;
            }

            if(sum == 0 && latestFreq == B+1 && c==0){
                sum = -1;
                continue;
            }

            if(latestFreq == B+1){
                sum-=c;
            }
        }
        return sum%MOD;
    }
}
