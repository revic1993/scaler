package dsa.leetcode.twopointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[][] testSet = {
                {1,8,6,2,5,4,8,3,7},
                {4,3,2,1,4},
                {1,2,1},
                {3,4}
        };
        for (int[] testData : testSet) {
            System.out.println(Arrays.toString(testData)+" has maxArea :"+maxArea(testData));
        }
    }

    public static int maxArea(int[] height){
        int mostWaterContainer = Integer.MIN_VALUE;
        int start = 0, end = height.length-1;
        while(start < end){
            int currentMin = height[start] < height[end] ? start : end;
            mostWaterContainer = Math.max(mostWaterContainer,height[currentMin]*(end-start));
            if(currentMin == start){
                start++;
            }else{
                end--;
            }
        }
        return mostWaterContainer;
    }

}
