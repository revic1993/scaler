package dsa.leetcode.arrays;

import java.util.HashSet;

public class ContainsDuplicate2 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k >= nums.length) {
            k = nums.length;
        }
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            if (numSet.contains(nums[i])) {
                return true;
            }
            numSet.add(nums[i]);
        }

        if (k == nums.length) {
            return false;
        }


        for (int i = 1, j = k + 1; i < nums.length; i++, j++) {

            if (numSet.contains(nums[j])) {
                return true;
            }

            numSet.remove(nums[i]);
            numSet.add(nums[j]);

            if (j == nums.length) {
                j = 0;
            }
        }

        return false;
    }
}
