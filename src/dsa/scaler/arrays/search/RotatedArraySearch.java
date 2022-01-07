package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {
    public static void main(String args[]){
        RotatedArraySearch ras = new RotatedArraySearch();
        ArrayList<List<Integer>> dataset = new ArrayList<>();
        dataset.add(Arrays.asList(1,2,3,4,5));
        dataset.add(Arrays.asList(5,1,2,3,4));
        dataset.add(Arrays.asList(4,5,1,2,3));
        dataset.add(Arrays.asList(3,4,5,1,2));
        dataset.add(Arrays.asList(2,3,4,5,1));
        //dataset.add(Arrays.asList(19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17));

        for(int i : Arrays.asList(1,2,3,4,5,6)){
            for(List<Integer> data : dataset){
                System.out.println("Index of "+i+" in array "+Arrays.toString(data.toArray()) +" is "+ ras.binarySearch(data,0,data.size()-1,i));
            }
        }
    }

    public int binarySearch(List<Integer> A, int start, int end, int target){
        while(start < end){
            if(target == A.get(start)){
                return start;
            }

            if(target == A.get(end)){
                return end;
            }

            if(start+1 == end){
                return -1;
            }

            int mid = (start+end) >> 1;

            if(target == A.get(mid)){
                return mid;
            }

            boolean isLeftSorted = A.get(mid) > A.get(start);


            if(isLeftSorted){
                if( A.get(mid) > target && target > A.get(start)){
                    end = mid-1;
                    continue;
                }
                start = mid+1;
                continue;
            }

            if( A.get(mid) < target && target < A.get(end)){
                start = mid+1;
                continue;
            }

            end = mid-1;
        }
        return -1;
    }
}
