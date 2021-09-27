package dsa.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccuranceGTThanThirdArrSize {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 5, 7 ))));
    }

    static int solve(final List<Integer> a){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int count_1 = 0, count_2 = 0;
        int minFreq = (int)Math.floor(a.size()/3);

        for(int i=0;i<a.size();i++){
            if(first == a.get(i)){
                count_1++;
            }else if(second ==a.get(i)){
                count_2++;
            }else if(count_1==0){
                first =a.get(i);
                count_1++;
            }else if(count_2 == 0){
                second =a.get(i);
                count_2++;
            }else{
                count_1--;
                count_2--;
            }
        }

        count_1 = 0;
        count_2 = 0;
        for(int i=0;i<a.size();i++){
            if(a.get(i)== first){
                count_1++;
                continue;
            }

            if(a.get(i)== second){
                count_2++;
            }


        }
        if(count_1 > minFreq){
            return first;
        }

        if(count_2 > minFreq){
            return second;
        }
        return -1;
    }

}
