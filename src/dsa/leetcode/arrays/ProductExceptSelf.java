package dsa.leetcode.arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[][] testSet = {
//                {1,2,3,4},
//                {-1,1,0,-3,3},
//                {-1,1,0,3,3},
//                {-1,1,1,2,3,4,3},
//                {0,0,0,0,0},
                {1,0},
                {0,4,0},
                {0,1}
        };
        for(int[] testData : testSet){
            System.out.println("product except self for: " + Arrays.toString(testData) + " array is " + Arrays.toString(productExceptSelf(testData)));
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countZero = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
                continue;
            }
            product *= num;
        }

        if(countZero == nums.length || countZero == nums.length-1){
            return new int[nums.length];
        }

        for(int i=0;i<nums.length;i++){
            if(countZero > 0 && nums[i] != 0){
                nums[i] = 0;
            } else if (countZero > 0 && nums[i] == 0) {
                nums[i] = product;
            } else {
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}
/**
 * INPUT :
 * [1, 0] -> [0,1]
 * [0, 4, 0] ->  [0,0,0]
 * [0, 1] ->  [1,0]
 * [0,0,1] -> [0,0,0]
 * [0,1,0] -> [0,0,0]
 * [1,0,0] ->  [0,0,0]
 * [1,1,0]
 * [1,0,1]
 * [0,1,1]
 * -------

 * [0,0,0]
 * [0,0,0]
 * [0,0,0]
 * [0,0,1]
 * [0,1,0]
 * [1,0,0]
 */