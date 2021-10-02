package dsa.scaler.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBooking {

    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8)) ;
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53));
        System.out.println(hotel(arrive,depart,23));
    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int arrInd = 0, depInd = 0;

        int count = 0;
        Collections.sort(arrive);
        Collections.sort(depart);
        while(arrInd < arrive.size() && depInd < depart.size()){
            if(arrInd < arrive.size() && arrive.get(arrInd) <= depart.get(depInd)){
                count++;
                arrInd++;
            }else if(depInd < depart.size() && depart.get(depInd) < arrive.get(arrInd)){
                count--;
                depInd++;
            }
            if(count > K){
                return false;
            }
        }
        return true;
    }
}
