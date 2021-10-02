package dsa.scaler.hashmap;

import java.util.*;

public class LastVisitedHotel {

    public static void main(String[] A){
        int[][] dataset = new int[][]{
                { 1, 2, 3, 2, 5, 3, 2, 4},
                {1,2,3,4},
                {1,1,1,1},
                {25,2,3,24,25}
        };

        LastVisitedHotel lastVisitedHotel = new LastVisitedHotel();

        for(int[] data: dataset){
            System.out.println(Arrays.toString(data) + " "+Arrays.toString(lastVisitedHotel.solve(data)));
        }
    }
    public int[] solve(int[] A) {
        HashMap<Integer,Integer> lastVisitedMap = new HashMap<>();

        for(int i=0;i<A.length;i++){
            lastVisitedMap.put(A[i],i);
        }

        List<Integer> indices = new ArrayList<>(lastVisitedMap.values());
        Collections.sort(indices);
        int[] result = new int[indices.size()];

        for(int i=0;i<indices.size();i++){
            result[i] = A[indices.get(i)];
        }
        return result;
    }
}
