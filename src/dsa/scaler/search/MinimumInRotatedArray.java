package dsa.scaler.search;

import java.util.Arrays;

public class MinimumInRotatedArray {
    public static void main(String[] args){
        MinimumInRotatedArray minimumInRotatedArray = new MinimumInRotatedArray();
        for (int[] ints : Arrays.asList(new int[]{3, 4, 1, 2}, new int[]{3, 4, 5, 1, 2}, new int[]{3, 4, 5, 1}, new int[]{3, 4, 5, 6, 1}, new int[]{1, 2})) {
            System.out.println(minimumInRotatedArray.findMin(ints));
        }
    }


    public int findMin(int[] nums) {
        int pivot = this.binarySearch(nums,0,nums.length-1);
        return nums[pivot];
    }

    public int binarySearch(int[] nums, int start, int end){
        if(start+1 == end){
            return nums[start] > nums[end] ? end : start;
        }

        int mid = (start+end) >> 1;

        // check if first half is not balanced
        if(nums[mid] < nums[start]){
            return this.binarySearch(nums,start,mid);
        }

        //check if second half is not balanced
        if(nums[mid] > nums[end]){
            return this.binarySearch(nums,mid,end);
        }

        return start;
    }

}
