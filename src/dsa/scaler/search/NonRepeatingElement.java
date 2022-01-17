package dsa.scaler.search;

import java.util.ArrayList;
import java.util.Arrays;

public class NonRepeatingElement {
    public static void main(String[] args) {
        System.out.println(new NonRepeatingElement().solve(new ArrayList<>(Arrays.asList(13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493))));
    }

    public int solve(ArrayList<Integer> A) {
        int l = 0;
        int r = A.size()-1;

        if(r == 0){
            return A.get(0);
        }

        while(l <= r){
            int m = (r+l) >> 1;

            if((m == 0 || A.get(m).intValue()!= A.get(m-1).intValue())  && (m==A.size()-1 || A.get(m).intValue()!=A.get(m+1).intValue())){
                return A.get(m);
            }

            if( (m&1)==0 ){
                if(A.get(m).intValue() == A.get(m-1).intValue()){
                    r = m-1;
                    continue;
                }

                l = m+1;
                continue;
            }

            if(A.get(m).intValue() == A.get(m+1).intValue()){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }
}
