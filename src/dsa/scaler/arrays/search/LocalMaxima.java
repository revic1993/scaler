package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;

public class LocalMaxima {
    public static void main(String[] args) {
        LocalMaxima lm = new LocalMaxima();
        System.out.println(lm.solve(new ArrayList<>(Arrays.asList(1,3,3))));
    }
    public int solve(ArrayList<Integer> A) {
        if(A.size() == 1){
            return A.get(0);
        }

        if(A.size() == 2){
            return A.get(0) > A.get(1) ? A.get(0) : A.get(1);
        }


        int start = 0;
        int end = A.size();
        while(start < end){
            int mid = ((start + end) >> 1);

            //end cases
            if(mid == 0 && A.get(mid) >= A.get(mid+1)){
                return A.get(mid);
            }

            if(mid == A.size()-1 && A.get(mid) >= A.get(mid-1)){
                return A.get(mid);
            }


            //local maxima
            if(A.get(mid) > A.get(mid+1) && A.get(mid) > A.get(mid-1)){
                return A.get(mid);
            }


            //local minima
            if(A.get(mid-1) > A.get(mid) && A.get(mid+1) > A.get(mid)){
                start = mid-1;
                continue;
            }

            if(A.get(mid-1) < A.get(mid) && A.get(mid) <= A.get(mid+1)){
                start = mid;
                continue;
            }

            if(A.get(mid-1) >= A.get(mid) && A.get(mid) > A.get(mid+1)){
                end = mid;
            }
        }
        return -1;
    }
}
