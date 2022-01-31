package dsa.scaler.strings;

import dnl.utils.text.table.TextTable;
import dsa.utils.Utils;

import java.util.ArrayList;

public class CyclicPermutations {

    public static void main(String[] args) {
//        TextTable tt = new TextTable(new String[]{"Bit","Z-Index"},)
        String data = "1001#1100";
        CyclicPermutations cp = new CyclicPermutations();
        System.out.println(cp.solve("110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111",
                                    "110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111110111111111011111111101111111"));
    }

    public int solve(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("#").append(B).append(B);
        sb.deleteCharAt(sb.length()-1);
        ArrayList<Integer> zValues = calculateZValue(sb.toString());
        int totalCount = 0;
        for(int z : zValues){
            totalCount+= z == A.length() ? 1 : 0;
        }
        return totalCount;
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
