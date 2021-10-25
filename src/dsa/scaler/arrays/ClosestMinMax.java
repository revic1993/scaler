package dsa.scaler.arrays;

public class ClosestMinMax {

    public static void main(String[] args) {
        int[][] testSet = {
                {814, 761, 697, 483, 981}
        };
        for (int[] testData : testSet){
            System.out.println(solve(testData));
        }
    }
    public static int solve(int[] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int latest_min_index = -1;
        int latest_max_index = -1;
        int distance = Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++){
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }

        for(int i=0;i<A.length;i++){
            if(A[i] == min){
                latest_min_index = i;
            }

            if(A[i] == max){
                latest_max_index = i;
            }

            if(latest_max_index == -1 || latest_min_index == -1){
                continue;
            }
            int updated_distance = Math.abs(latest_max_index - latest_min_index);
            distance = Math.min(updated_distance,distance);
        }

        return distance+1;
    }
}
