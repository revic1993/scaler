package dsa.scaler.heaps;

import dsa.utils.Utils;

import java.util.*;

public class BClosestPointToOrigin {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        data.add(new ArrayList<>(List.of(1,3)));
        data.add(new ArrayList<>(List.of(-2,2)));
        BClosestPointToOrigin bpto = new BClosestPointToOrigin();
        Utils.print(bpto.solve(data,1));
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(ArrayList<Integer> current : A){
            points.add(new Point(current.get(0),current.get(1)));
        }
        PriorityQueue<Point> minHeap = new PriorityQueue<>( new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.distance,o2.distance);
            }
        });
        minHeap.addAll(points);
        for(int i=0;i<B;i++){
            Point minPoint = minHeap.remove();
            result.add(minPoint.getPoint());
        }
        return result;
    }

    static class Point{
        int x;
        int y;
        int distance;
        Point(int x,int y){
            this.x = x;
            this.y = y;
            this.distance = (x *x) + (y * y);
        }

        ArrayList<Integer> getPoint(){
            return new ArrayList<>(List.of(x,y));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }
}
