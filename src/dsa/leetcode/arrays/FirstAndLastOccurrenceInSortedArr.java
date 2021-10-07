package dsa.leetcode.arrays;

import java.util.Arrays;

public class FirstAndLastOccurrenceInSortedArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 7, 7, 7, 7, 8, 8, 10}, 7)));
    }

    public static int[] searchRange(int nums[], int target){
        int[] result = {-1,-1};
        searchRangeRec(nums,target,result,0,nums.length-1);
        return result;
    }

    public static void searchRangeRec(int nums[], int target,int[] result, int start,int end){
        if(start > end){
            return;
        }
        int mid = (start+end) >> 1;

        if(nums[mid] == target) {
            if(nums[mid-1] == target){
                searchRangeRec(nums,target,result,0,mid-1);
            }

            if(nums[mid+1] == target){
                searchRangeRec(nums,target,result,mid+1,end);
            }

            if(nums[mid-1]!=target){
                result[0] = mid-1;
            }
            if(nums[mid+1]!=target){
                result[1] = mid+1;
            }
            return;
        }

        if(nums[mid] > target){
            searchRangeRec(nums,target,result,start,mid);
            return;
        }

        searchRangeRec(nums,target,result,mid+1,end);
    }
}
