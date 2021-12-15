package dsa.scaler.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class PeriodOfString {

    public static void main(String[] args) {
        PeriodOfString pos = new PeriodOfString();
        System.out.println(pos.solve("aaaa"));
    }

    public int solve(String A) {
        ArrayList<Integer> zValues = calculateZValue(A);
        for(int i=1;i<zValues.size();i++){
            if(zValues.get(i)+i == A.length()){
                return i;
            }
        }
        return A.length();
    }



    public ArrayList<Integer> calculateZValue(String A){
        int l=0,r=0;
        ArrayList<Integer> Z = new ArrayList<>();
        Z.add(-1);
        for(int current = 1;current < A.length();current++){
            if(current > r){
                l = current;
                r = current;
            }else{
                int k = current - l;
                if(Z.get(k) < (r-current+1)){
                    Z.add(Z.get(k));
                    continue;
                }
                l = current;
            }
            while(r < A.length() && A.charAt(r-l) == A.charAt(r)) r++;
            Z.add(r-l);
            r--;
        }
        return Z;
    }
}
