package dsa.leetcode.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[][] testSet = {
                {1,2,3,4,5},
                {1,2,5,3,4},
                {1,2,5,4,3},
                {5,4,3,2,1},
                {2,4,1,5,3},
                {1,2,3},
                {3,2,1},
                {1,1,5},
                {1,5,1},
                {5,1,1}
        };
        for(int[] testData : testSet){
           System.out.print(Arrays.toString(testData)+"'s next permutation is ");
           nextPermutation(testData);
           System.out.println(Arrays.toString(testData));
        }
    }

    public static void nextPermutation(int[] nums) {
        //find the first decreasing index
        int j = nums.length - 1;
        while(j > 0 && nums[j] <= nums[j-1]){
            j--;
        }

        if(j==0){
            reverse(nums,0, nums.length-1);
            return;
        }

        int firstDecreasingInd = j-1;

        //check for next highest value on right and swap
        int nextNum = nums[j];
        int nextMaxInd = j;
        while(j < nums.length){
            if(nums[firstDecreasingInd] < nums[j]){
                nextNum = Math.min(nextNum,nums[j]);
                nextMaxInd = j;
            }
            j++;
        }

        //swap first decreasing index and next highest value
        nums[nextMaxInd] = nums[firstDecreasingInd];
        nums[firstDecreasingInd] = nextNum;
        //sort on right
        reverse(nums,firstDecreasingInd+1, nums.length-1);
    }

    public static void reverse(int[] nums, int startInd, int endInd){
        while(startInd < endInd){
            int temp = nums[startInd];
            nums[startInd] = nums[endInd];
            nums[endInd] = temp;
            startInd++;
            endInd--;
        }
    }
}
