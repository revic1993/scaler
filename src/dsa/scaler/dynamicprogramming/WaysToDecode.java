package dsa.scaler.dynamicprogramming;

import java.util.HashMap;

public class WaysToDecode {
    public static void main(String[] args) {
        WaysToDecode wtdc = new WaysToDecode();
        System.out.println(wtdc.numDecodings("261105"));
//        System.out.println(wtdc.numDecodings("0"));
    }
    HashMap<Integer,Integer> waysMap = new HashMap<>();
    int mod = (int) (Math.pow(10,9)+7);
    public int numDecodings(String A) {
        int current = A.length()-1;
        while(current >=0 && A.charAt(current) == '0'){
            current--;
        }
        if(current == -1){
            return 0;
        }
        String data = A.substring(0,current+1);
        return ways(-1,data);
    }

    public int ways(int current,String A){
        if(waysMap.containsKey(current)){
            return waysMap.get(current);
        }

        if(current == A.length()-1){
            return 1;
        }

//        if(current >= 0 && A.charAt(current) == '0'){
//            return 0;
//        }
        int firstPath = A.charAt(current+1) == '0' ? 0 : ways(current+1,A);
        int secondPath = current+2 <= A.length()-1 && isPairPossible(A.charAt(current+1),A.charAt(current+2)) ? ways(current+2,A) : 0;
        int total = (firstPath%mod+secondPath%mod)%mod;
        waysMap.put(current,total);
        return total;
    }

    public boolean isPairPossible(char a, char b){
        return a=='1' || (a == '2' && b <= '6');
    }
}
