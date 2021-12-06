package dsa.scaler.arrays.search.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {

    public static void main(String[] args) {
        SpecialInteger si = new SpecialInteger();
        System.out.println(si.solve(new ArrayList<>(Arrays.asList(1,2,3,4,5,100)),10));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int lower = 1;
        int higher = A.size();
        int ans = -1;

        while(lower<=higher){
            int mid = (lower+higher)>>1;
            if(check(A,B,mid)){
                ans = mid;
                lower = mid+1;
            }else{
                higher = mid-1;
            }
        }
        if(ans < 0){
            return 0;
        }
        return ans;
    }

    public boolean check(ArrayList<Integer> A, int B,int windowSize){
        int currentSum = 0;

        for(int i=0;i<windowSize;i++){
            currentSum+=A.get(i);
        }

        for(int i=windowSize;i<A.size();i++){
            if(currentSum > B){
                return false;
            }
            currentSum -= A.get(i-windowSize);
            currentSum += A.get(i);
        }

        return currentSum <= B;
    }
}
