package dsa.scaler.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public int solve(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = 0;
        int minSum = 0;
        for(int fixedIndex = 0; fixedIndex < nums.length-2;fixedIndex++){
            int start = fixedIndex+1;
            int end = nums.length-1;

            while(start < end){
                int sum = nums[fixedIndex] + nums[start] + nums[end];

                if(target > sum){
                    start++;
                }

                if(target < sum){
                    end--;
                }

                if(distance == 0){
                    distance = Math.abs(target-sum);
                    minSum = sum;
                }

                if(distance > Math.abs(target-sum)){
                    distance = Math.abs(target-sum);
                    minSum = sum;
                }

                if(distance == 0){
                    return sum;
                }
            }
        }
        return minSum;
    }
}
