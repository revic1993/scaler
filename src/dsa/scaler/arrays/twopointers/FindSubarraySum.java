package dsa.scaler.arrays.twopointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubarraySum {
    public static void main(String[] args) {
        FindSubarraySum fss = new FindSubarraySum();
        System.out.println(Arrays.toString(fss.solve(new ArrayList<>(Arrays.asList(23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6)),62).toArray()));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int i=0,j = 0;
        int currentSum = A.get(i);
        ArrayList<Integer> result = new ArrayList<>(List.of(-1));
        while(i<A.size()){
            if(currentSum == B){
                result.set(0,A.get(i));
                while(i < j){
                    result.add(A.get(++i));
                }
                return result;
            }

            if(currentSum < B){
                if(j+1 == A.size()){
                    return result;
                }
                currentSum+=A.get(++j);
            }else{
                currentSum-=A.get(i++);
            }
        }
        return result;
    }
}
