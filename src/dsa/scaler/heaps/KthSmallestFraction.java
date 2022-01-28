package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestFraction {
    public static void main(String[] args) {
        KthSmallestFraction ksf = new KthSmallestFraction();
        Utils.printSingleArr(ksf.solve(new ArrayList<>(List.of(1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297)),42));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o1.fraction,o2.fraction);
            }
        });

        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
                Point point = new Point(A.get(i),A.get(j));
                minHeap.add(point);
            }
        }
        Point p = null;
        for(int i=0;i<B;i++){
            p = minHeap.remove();
        }
        return p.getPoint();
    }
    static class Point{
        int x;
        int y;
        double fraction;
        Point(int x,int y){
            this.x = x;
            this.y = y;
            this.fraction = x*1.0/y;
        }

        ArrayList<Integer> getPoint(){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(x);
            res.add(y);
            return res;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", fraction=" + fraction +
                    '}';
        }
    }
}
