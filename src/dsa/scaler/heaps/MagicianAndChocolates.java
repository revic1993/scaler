package dsa.scaler.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public static void main(String[] args) {
        MagicianAndChocolates mc = new MagicianAndChocolates();
        System.out.println(mc.nchoc(5,new ArrayList<>(List.of(2, 4, 6, 8, 10))));
    }
    public int nchoc(int A, ArrayList<Integer> B) {
        int mod = (int) (Math.pow(10,9)+7);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(B);
        int sum = 0;
        for(int i=0;i<A;i++){
            int max = maxHeap.remove();
            sum = (sum % mod + max % mod)%mod;
            maxHeap.add((max >> 1));
        }
        return sum%mod;
    }
}
