package dsa.scaler.arrays.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        int[][] testSet = {{5, 28}, {7, 70}, {54, 93}, {5, 98}, {46, 70}, {42, 63}, {5, 91}, {30, 49}, {36, 57}, {31, 95}, {86, 88}, {9, 90}, {5, 53}, {42, 62}, {14, 100}, {59, 75}, {32, 100}, {5, 79}, {31, 31}, {7, 42}, {13, 47}, {44, 87}, {61, 83}, {100, 100}, {96, 98}, {47, 51}, {34, 44}, {6, 53}, {30, 92}, {50, 64}, {37, 57}, {49, 67}, {2, 67}, {36, 50}, {55, 100}, {54, 78}, {58, 70}, {2, 37}, {13, 54}, {7, 60}, {16, 79}, {35, 78}, {17, 57}, {16, 84}, {60, 80}, {10, 54}, {54, 59}, {62, 85}, {7, 37}, {31, 99}, {40, 41}, {4, 99}, {28, 45}, {27, 71}, {14, 64}};
        for (int[] testData: testSet) {
            intervals.add(new Interval(testData[0],testData[1]));
        }
        System.out.println(Arrays.toString(merge(intervals).toArray()));
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(o1, o2)->o1.start-o2.start);
        ArrayList<Interval> result = new ArrayList<>();
        int i=0;
        while(i<intervals.size()){
            int min = intervals.get(i).start;
            int max = intervals.get(i).end;
            int k = i+1;
            while(k < intervals.size() && max >= intervals.get(k).start){
                max = Math.max(max,intervals.get(k).end);
                k++;
            }
            result.add(new Interval(min,max));
            i = k;
        }
        return result;
    }

    class TestData{
        ArrayList<Interval> intervals;
        Interval newInterval;

        TestData(ArrayList<Interval> intervals, Interval newInterval){
            this.intervals = intervals;
            this.newInterval = newInterval;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "intervals=" + Arrays.toString(intervals.toArray()) +
                    ", newInterval=" + newInterval +
                    '}';
        }
    }
    static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
