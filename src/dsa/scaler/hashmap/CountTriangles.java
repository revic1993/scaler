package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriangles {

    public static void main(String[] args) {
        CountTriangles ct = new CountTriangles();
        System.out.println(ct.solve(new ArrayList<>(List.of(1,1,2)),new ArrayList<>(List.of(1,2,1))));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int MOD = 1000000007;
        long ans = 0;
        HashMap<Integer,Integer> freqMapX = new HashMap<>();
        HashMap<Integer,Integer> freqMapY = new HashMap<>();

        for(int i=0;i<A.size();i++){
            if(!freqMapX.containsKey(A.get(i))){
                freqMapX.put(A.get(i),0);
            }

            if(!freqMapY.containsKey(B.get(i))){
                freqMapY.put(B.get(i),0);
            }

            freqMapX.put(A.get(i),1+freqMapX.get(A.get(i)));
            freqMapY.put(B.get(i),1+freqMapY.get(B.get(i)));
        }

        for(int i=0;i<A.size();i++){
            int totalX = freqMapX.get(A.get(i))-1;
            int totalY = freqMapY.get(B.get(i))-1;

            ans = (ans%MOD + ((long) totalX %MOD * totalY%MOD)%MOD)%MOD;
        }

        return (int)ans;
    }
}
