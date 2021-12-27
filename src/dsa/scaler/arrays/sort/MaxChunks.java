package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.List;

public class MaxChunks {
    public static void main(String[] args) {
        MaxChunks mc = new MaxChunks();
        System.out.println(mc.solve(new ArrayList<>(List.of(2, 0, 1, 3))));
    }
    public int solve(ArrayList<Integer> A) {
        int low=0,high=0,min=A.get(0),max=A.get(0);
        int partition = 0;
        while(high < A.size()){
            if(high!=max || low!=min){
                high++;
                min = Math.min(min,A.get(high));
                max = Math.max(max,A.get(high));
            }else{
                partition++;
                high++;
                low=high;
                if(high >= A.size()){
                    break;
                }
                min = A.get(high);
                max = A.get(high);
            }
        }
        return partition;
    }
}
