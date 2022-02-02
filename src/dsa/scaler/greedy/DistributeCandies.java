package dsa.scaler.greedy;

import dsa.utils.Utils;

import java.util.ArrayList;

public class DistributeCandies {
    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        System.out.println(dc.candy(Utils.generateList(1,5,2,1)));
    }
    public int candy(ArrayList<Integer> A) {
        ArrayList<Integer> candies = new ArrayList<>();
        candies.add(1);
        for(int i=1;i<A.size();i++){
            if(A.get(i) > A.get(i-1)){
                candies.add(candies.get(i-1)+1);
            }else{
                candies.add(1);
            }
        }

        for(int i=A.size()-2;i>=0;i--){
            if(A.get(i) > A.get(i+1)){
                candies.set(i,Math.max(candies.get(i),candies.get(i+1)+1));
            }
        }
        int total = 0;
        for(int candy : candies){
            total+=candy;
        }
        return total;
    }
}
