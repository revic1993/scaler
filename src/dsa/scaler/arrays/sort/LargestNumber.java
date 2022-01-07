package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(List.of(9,4,30,3,34)));
    }

    public String largestNumber(final List<Integer> A) {
        ArrayList cloned = new ArrayList<>(A);
        cloned.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Long.parseLong(o1 + "" + o2) < Long.parseLong(o2 + "" + o1) ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cloned.size();i++){
            sb.append(cloned.get(i));
        }
        int pos = 0;
        while(pos < sb.length() && sb.charAt(pos) == '0'){
            pos++;
        }
        String result = sb.toString().substring(pos,sb.length());
        if(result.length() == 0){
            return "0";
        }
        return result;
    }


}
