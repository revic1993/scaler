package dsa.scaler.arrays.merge;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        int[][] testSet = {{6037774, 6198243}, {6726550, 7004541}, {8842554, 10866536}, {11027721, 11341296}, {11972532, 14746848}, {16374805, 16706396}, {17557262, 20518214}, {22139780, 22379559}, {27212352, 28404611}, {28921768, 29621583}, {29823256, 32060921}, {33950165, 36418956}, {37225039, 37785557}, {40087908, 41184444}, {41922814, 45297414}, {48142402, 48244133}, {48622983, 50443163}, {50898369, 55612831}, {57030757, 58120901}, {59772759, 59943999}, {61141939, 64859907}, {65277782, 65296274}, {67497842, 68386607}, {70414085, 73339545}, {73896106, 75605861}, {79672668, 84539434}, {84821550, 86558001}, {91116470, 92198054}, {96147808, 98979097} };
        for (int[] testData: testSet) {
            intervals.add(new Interval(testData[0],testData[1]));
        }
        Interval newInterval = new Interval(36210193,61984219);
        System.out.println(Arrays.toString(insert(intervals,newInterval).toArray()));
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        ArrayList<Interval> result = new ArrayList<>();
        int i=0;
        intervals.add(newInterval);
        int j=intervals.size()-2;

        while(j >=0 && newInterval.start < intervals.get(j).start){
            Interval temp = intervals.get(j);
            intervals.set(j,newInterval);
            intervals.set(j+1,temp);
            j--;
        }

        while(i<intervals.size()){
            int min = intervals.get(i).start;
            int max = intervals.get(i).end;
            int k = i+1;
            while(k < intervals.size() && max > intervals.get(k).start){
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

        TestData(ArrayList<Interval> intervals,Interval newInterval){
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

