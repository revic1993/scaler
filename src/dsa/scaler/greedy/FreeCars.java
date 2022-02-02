package dsa.scaler.greedy;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {
    public static void main(String[] args) {
        FreeCars fc = new FreeCars();
        System.out.println(fc.solve(Utils.generateList(1, 3, 2, 3, 3),Utils.generateList(5, 6, 1, 3, 9)));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<CarTime> minHeap = new PriorityQueue<>(Comparator.comparing(a->a.profit));
        ArrayList<CarTime> cars = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            cars.add(new CarTime(B.get(i),A.get(i)));
        }
        cars.sort(Comparator.comparing(a -> a.period));
        int timer = 0;
        for(CarTime car : cars){
            if(car.period > timer){
                minHeap.add(car);
                timer++;
                continue;
            }
            if(!minHeap.isEmpty() && minHeap.peek().profit < car.profit){
                minHeap.remove();
                minHeap.add(car);
            }
        }
        int mod = (int) (Math.pow(10,9)+7);
        int totalProfit = 0;
        while(!minHeap.isEmpty()){
            totalProfit = (totalProfit%mod+minHeap.remove().profit%mod)%mod;
        }
        return totalProfit;
    }

    static class CarTime{
        int profit;
        int period;
        CarTime(int profit,int period){
            this.profit = profit;
            this.period = period;
        }
    }
}
