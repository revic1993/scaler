package dsa.scaler.dynamicprogramming;

import java.util.HashMap;

public class DistinctSubsequence {

    public static void main(String[] args) {
        DistinctSubsequence ds = new DistinctSubsequence();
        System.out.println(ds.numDistinct("rabbbit","rabbit"));
//        System.out.println(ds.numDistinct("rabbi","abc"));
    }
    HashMap<String,Integer> distinctMap = new HashMap<>();
    public int numDistinct(String A, String B) {
        int[][] distinct = new int[A.length()+1][B.length()+1];
        distinct[0][0] = 1;
        for(int i=1;i<=A.length();i++){
            distinct[i][0] = 1;
            int range = Math.min(B.length(),i);
            for(int j=1;j<=range;j++){
                distinct[i][j] = distinct[i-1][j];
                if(A.charAt(i-1) == B.charAt(j-1)){
                    distinct[i][j]+=distinct[i-1][j-1];
                }
            }
        }
        return distinct[A.length()][B.length()];
//        return totalDistinct(A,B,-1,-1);
    }

    public int totalDistinct(String A,String B, int aInd,int bInd){
        int total = 0;
        if(distinctMap.containsKey(aInd+"_"+bInd)){
            return distinctMap.get(aInd+"_"+bInd);
        }
        if(bInd == B.length()-1){
            return 1;
        }
        for(int i=aInd+1;i<A.length();i++){
            if(A.charAt(i) == B.charAt(bInd+1)) {
                total += totalDistinct(A, B, i, bInd + 1);
            }
        }
        distinctMap.put(aInd+"_"+bInd,total);
        return total;
    }


}
/*
*
*
* HashMap<String,Integer> distinctMap = new HashMap<>();
    public int numDistinct(String A, String B) {
        return totalDistinct(A,B,-1,-1);
    }

    public int totalDistinct(String A,String B, int aInd,int bInd){
        int total = 0;
        if(distinctMap.containsKey(aInd+"_"+bInd)){
            return distinctMap.get(aInd+"_"+bInd);
        }
        if(bInd == B.length()-1){
            return 1;
        }
        for(int i=aInd+1;i<A.length();i++){
            if(A.charAt(i) == B.charAt(bInd+1)) {
                total += totalDistinct(A, B, i, bInd + 1);
            }
        }
        distinctMap.put(aInd+"_"+bInd,total);
        return total;
    }*/