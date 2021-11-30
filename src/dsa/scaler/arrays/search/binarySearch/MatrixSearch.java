package dsa.scaler.arrays.search.binarySearch;

import java.util.ArrayList;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int row = 0;
        while(row < n ){
            if(A.get(row).get(0) < B && A.get(row).get(m-1) < B){
                row++;
                continue;
            }

            if(A.get(row).get(0) > B ){
                return 0;
            }

            if(A.get(row).get(0) <= B && A.get(row).get(m-1) >= B){
                return binarySearch(A,B,row);
            }
        }
        return 0;
    }

    public int binarySearch(ArrayList<ArrayList<Integer>> A, int B, int row){
        int start = 0;
        int end = A.get(row).size();
        while(start < end){
            if(A.get(row).get(start) == B || (end!=A.get(row).size() && A.get(row).get(end)==B)){
                return 1;
            }
            int mid = ((start+end)>>1);

            if(A.get(row).get(mid) == B){
                return 1;
            }

            if(A.get(row).get(mid) > B){
                end = mid-1;
                continue;
            }

            if(A.get(row).get(mid) < B){
                start = mid+1;
            }
        }

        return 0;
    }
}
