package dsa.scaler.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPair {
    public static void main(String[] args) {
        ClosestPair cp = new ClosestPair();
        System.out.println(cp.solve(new ArrayList<>(Arrays.asList(1,3,5,7,9)),new ArrayList<>(Arrays.asList(2,4,6,8,10)),10));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int i=0,j=B.size()-1;
        int firstInd = 0,secondInd=0;
        int minDiff = Integer.MAX_VALUE;
        if( C <= A.get(0) && C <=B.get(0)){
            return new ArrayList<>(Arrays.asList(A.get(0), B.get(0)));
        }

        while(i < A.size() && j >=0){
            int val = A.get(i) + B.get(j);
            int diff = Math.abs(C-val);
            if(diff == 0){
                // move j till last occurance of j
                firstInd = i;
                secondInd = j;
                while(j >=0 && B.get(j).intValue() == B.get(secondInd)){
                    j--;
                }

                if(B.get(j).intValue() == B.get(secondInd)){
                    secondInd = j;
                }else{
                    secondInd = ++j;
                }
                break;
            }




            if(minDiff > diff){
                firstInd = i;
                secondInd = j;
                minDiff = diff;
            }else if(minDiff == diff && firstInd == i){
                secondInd = j;
            }

            if(val >= C){
                j--;
            }else{
                i++;
            }

        }
        return new ArrayList<>(Arrays.asList(A.get(firstInd),B.get(secondInd)));
    }
}
