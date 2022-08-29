package dsa.leetcode.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lsc = new LongestConsecutiveSequence();
        System.out.println(lsc.longestConsecutive(new int[]{1,0,-1}));

    }
    public int longestConsecutive(int[] nums) {
        int lcs = 1;
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        for(int i=0;i<nums.length;i++){
            if(i+lcs > nums.length){
                break;
            }
            int currentLCS = 0;
            int currentNum = nums[i];
            while(numSet.contains(currentNum)){
                currentNum++;
                currentLCS++;
            }
            lcs= Math.max(lcs,currentLCS);
        }

        return lcs;
    }
}
