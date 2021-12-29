package dsa.scaler.arrays.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountSubArrays {
    public static void main(String[] args) {
        CountSubArrays csa = new CountSubArrays();
        System.out.println(csa.solve(new ArrayList<>(List.of(2,3,4,4,5,6))));
    }

    int M = 1000000007;
    public int solve(ArrayList<Integer> A) {
        if(A.size() == 1){
            return 1;
        }
        HashSet<Integer> currentSet = new HashSet<>();
        int i=0,j=0;
        currentSet.add(A.get(0));
        long totalSubArrays = 0;
        long subArraysToRemove = 0;
        while(j<A.size()){
            if(j+1 == A.size()){
                int currentSubArrSize = j-i+1;
                totalSubArrays = (totalSubArrays%M +totalSubArr(currentSubArrSize))%M;
                break;
            }
            int nextIndex = j+1;
            int size = nextIndex-i;

            if(currentSet.contains(A.get(nextIndex))){
                int low = i;
                while(low < nextIndex && A.get(low).intValue() != A.get(nextIndex)){
                    currentSet.remove(A.get(low));
                    low++;
                }
                int commonElements = j-low;
                int currentSubArrSize = j-i+1;
                if(commonElements != 0){
                    subArraysToRemove = (subArraysToRemove%M + totalSubArr(commonElements))%M;
                }
                totalSubArrays = (totalSubArrays%M +totalSubArr(currentSubArrSize))%M;
                i = low+1;
            }
            j++;
            currentSet.add(A.get(j));
        }
        return (int) (totalSubArrays%M - subArraysToRemove%M + M)%M;
    }

    long totalSubArr(int totalElements){
        int odd = (totalElements & 1) == 0 ? totalElements+1 : totalElements;
        int even = (totalElements&1) == 0 ? totalElements>>1 : (totalElements+1) >> 1;
        return ((long) odd %M*even%M)%M;
    }
}
/*
*
*  if(A.get(i) == nextIndex){
                totalSubArrays =  (totalSubArrays % M + (1l*(size%M)*(size+1)%M)%M)%M;
                totalSubArrays = (totalSubArrays%M - 1 + M)%M;
                i++;
            }else if(A.get(j) == nextIndex){
                totalSubArrays =  (totalSubArrays % M + (1l*(size%M)*(size+1)%M)%M)%M;
                i = j+1;
                j++;
            }*/