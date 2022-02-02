package dsa.scaler.greedy;

import java.util.ArrayList;

public class ConsecutiveSeats {
    public static void main(String[] args) {
        ConsecutiveSeats cs = new ConsecutiveSeats();
        System.out.println(cs.seats("...."));
    }
    public int seats(String A) {
        ArrayList<Integer> xPos = new ArrayList<>();
        int mod = (int) (Math.pow(10,7)+3);
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(c == 'x'){
                xPos.add(i);
            }
        }
        if(xPos.size()==0){
            return 0;
        }

        int pivotPos = xPos.get((xPos.size() >> 1));
        int total = 0;
        int alreadyMoved = 1;
        for (Integer xPo : xPos) {
            if (xPo == pivotPos) {
                alreadyMoved = 1;
                continue;
            }
            total = (total%mod+(Math.abs(xPo - pivotPos) - alreadyMoved)%mod)%mod;
            alreadyMoved++;
        }
        return total;
    }
}
