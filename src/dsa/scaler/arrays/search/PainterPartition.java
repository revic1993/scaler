package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartition {
    int MOD = 10000003;

    public static void main(String[] args) {
        PainterPartition pp = new PainterPartition();
        System.out.println(pp.paint(1,1000000,new ArrayList<>(Arrays.asList(1000000, 1000000))));
    }

    public int paint(int painters, int perUnitTime, ArrayList<Integer> boards) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        int ans = -1;
        for(int board : boards){
            left = Math.max(left,board);
            right+=board;
        }

        while(left <= right){
            int mid = left + ((right-left) >> 1);
            if(check(boards,painters,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        long ansInLong = ((1l*ans % MOD * perUnitTime%MOD)%MOD);
        return (int) ansInLong;
    }

    public boolean check(ArrayList<Integer> boards,int availablePainters,int timeAvailable){
        int totalPainterRequired = 1;
        int currentBoardPainted = 0;

        for(int board : boards){
            if(currentBoardPainted+board <= timeAvailable){
                currentBoardPainted+=board;
            }else{
                currentBoardPainted = board;
                totalPainterRequired++;
            }

            if(totalPainterRequired > availablePainters){
                return false;
            }


        }

        return true;
    }
}
