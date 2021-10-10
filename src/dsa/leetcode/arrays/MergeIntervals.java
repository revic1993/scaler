package dsa.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{
                {1,4},
                {3,10},
                {9,20}
        });
        for (int[] res : result) {
          System.out.println(Arrays.toString(res));
        };
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<Integer[]> resultArr = new ArrayList<>();
        int i = 0;
        while(i < intervals.length){
            int min = intervals[i][0];
            int max = intervals[i][1];
            int j = i+1;
            while(j < intervals.length && intervals[j][0] <= max){
                max = Math.max(max,intervals[j][1]);
                j++;
            }
            resultArr.add(new Integer[]{min,max});
            i=j;
        }
        int[][] result = new int[resultArr.size()][2];

        for(int k=0;k< result.length;k++){
            result[k][0] = resultArr.get(k)[0];
            result[k][1] = resultArr.get(k)[1];
        }
        return result;
    }
}
