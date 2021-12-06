package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(new ArrayList<>(Arrays.asList( 1,3,5,6)),7));
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        int start = 0;
        int end = A.size()-1;
        int ans = -1;
        while (start <= end){
            int mid = ((start+end) >> 1);
            if(B > A.get(mid)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}
