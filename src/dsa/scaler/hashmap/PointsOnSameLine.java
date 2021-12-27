package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PointsOnSameLine {
    public static void main(String[] args) {
        PointsOnSameLine posl = new PointsOnSameLine();
        System.out.println(posl.solve(new ArrayList<>(List.of(2, 1, -7, 4, 1, -2, -7, 5)),new ArrayList<>(List.of(-6, -7, 3, -10, 7, -10, 1, 2))));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> horizontal = new HashMap<>();
        HashMap<Integer,Integer> vertical = new HashMap<>();
        HashSet<String> coordinates = new HashSet<>();

        int maxOnSameLine = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            int x = A.get(i);
            int y = B.get(i);
            coordinates.add(x+"_"+y);

            if(!horizontal.containsKey(y)){
                horizontal.put(y,0);
            }

            if(!vertical.containsKey(x)){
                vertical.put(x,0);
            }

            horizontal.put(y,horizontal.get(y)+1);
            vertical.put(x,vertical.get(x)+1);
            maxOnSameLine = Math.max(maxOnSameLine,horizontal.get(y));
            maxOnSameLine = Math.max(maxOnSameLine,vertical.get(x));
        }
        int cross = 1;
        for(int i=0;i<A.size();i++){
            int x = A.get(i);
            int y = B.get(i);
            String key = x+"_"+y;
            if(!coordinates.contains(key)){
                continue;
            }
            int j=1;
            String updatedKey = (x+j)+"_"+(y+j);
            while(coordinates.contains(updatedKey)){
                coordinates.remove(updatedKey);
                cross++;
                j++;
                updatedKey = (x+j)+"_"+(y+j);
            }

            j = -1;

            updatedKey = (x+j)+"_"+(y+j);
            while(coordinates.contains(updatedKey)){
                coordinates.remove(updatedKey);
                cross++;
                j--;
                updatedKey = (x+j)+"_"+(y+j);
            }
        }
        maxOnSameLine = Math.max(maxOnSameLine,cross);
        return maxOnSameLine;
    }
}
