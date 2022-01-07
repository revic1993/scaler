package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AggressiveCows {
    public static void main(String[] args) {
        AggressiveCows ac = new AggressiveCows();
        System.out.println(ac.solve(new ArrayList<>(Arrays.asList(82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95)),8));
    }
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size()-1;

        if(B == 2){
            return A.get(n) - A.get(0);
        }

        if(B == n+1){
            int min = Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                min = Math.min(min,A.get(i)-A.get(i-1));
            }
            return min;
        }

        int l = 1, r = A.get(n) - A.get(0);
        int ans = -1;

        while(l <= r){
            int mid = (l+r)>>1;
            if(check(A,B,mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    public boolean check(ArrayList<Integer> A, int B, int distance){
        int lastPlaced = 0;
        int k = 1;

        for(int i=0;i<A.size();i++){
            if(A.get(i) - A.get(lastPlaced) >= distance){
                lastPlaced = i;
                k++;
            }
        }

        return k >= B;
    }
}
