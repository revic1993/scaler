package dsa.scaler.math.gcd;

import dsa.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class AllGCDPairs {
    public static void main(String[] args) {
        int[][] testSet = {
//                {2, 2, 2, 2, 8, 2, 2, 2, 10},
                {634, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 844, 4, 4, 2, 2, 1, 2, 2, 4, 1, 1, 4, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 4, 2, 4, 780, 20, 10, 6, 1, 2, 26, 4, 1, 15, 12, 5, 3, 1, 1, 1, 4, 65, 12, 1, 1, 5, 20, 2, 4, 20, 140, 70, 2, 1, 2, 2, 4, 1, 5, 28, 35, 7, 1, 1, 1, 28, 5, 28, 1, 1, 5, 140, 2, 2, 10, 70, 490, 2, 1, 2, 2, 2, 1, 5, 14, 35, 7, 1, 1, 1, 14, 5, 14, 1, 1, 5, 70, 2, 2, 6, 2, 2, 726, 1, 2, 22, 2, 1, 3, 6, 1, 33, 1, 1, 11, 2, 1, 6, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 677, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 86, 2, 2, 1, 1, 2, 1, 1, 1, 1, 43, 2, 2, 1, 1, 1, 1, 2, 2, 2, 26, 2, 2, 22, 1, 2, 286, 2, 1, 1, 2, 1, 11, 1, 1, 11, 2, 13, 2, 1, 1, 1, 2, 2, 4, 4, 4, 2, 2, 1, 2, 2, 376, 1, 1, 8, 1, 1, 1, 1, 1, 4, 1, 8, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 359, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 15, 5, 5, 3, 1, 1, 1, 1, 1, 3, 75, 5, 3, 1, 1, 1, 1, 25, 3, 1, 1, 5, 25, 2, 4, 12, 28, 14, 6, 1, 2, 2, 8, 1, 3, 168, 7, 21, 1, 1, 1, 28, 1, 168, 1, 1, 1, 28, 1, 1, 5, 35, 35, 1, 1, 1, 1, 1, 1, 5, 7, 595, 7, 1, 1, 1, 7, 5, 7, 1, 1, 5, 35, 1, 1, 3, 7, 7, 33, 1, 1, 11, 1, 1, 3, 21, 7, 693, 1, 1, 11, 7, 1, 21, 1, 1, 1, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 943, 1, 1, 1, 1, 1, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 193, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 43, 11, 1, 1, 1, 1, 1, 11, 1, 1, 473, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 28, 14, 2, 1, 2, 2, 4, 1, 1, 28, 7, 7, 1, 1, 1, 28, 1, 28, 1, 1, 1, 28, 1, 1, 65, 5, 5, 1, 1, 1, 13, 1, 1, 25, 1, 5, 1, 1, 1, 1, 1, 325, 1, 1, 1, 5, 25, 2, 4, 12, 28, 14, 6, 1, 2, 2, 8, 1, 3, 168, 7, 21, 1, 1, 1, 28, 1, 168, 1, 1, 1, 28, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23, 1, 1, 1, 1, 1, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 619, 1, 1, 1, 1, 5, 5, 5, 1, 1, 1, 1, 1, 1, 5, 1, 5, 1, 1, 1, 1, 1, 5, 1, 1, 1, 635, 5, 2, 4, 20, 140, 70, 2, 1, 2, 2, 4, 1, 25, 28, 35, 7, 1, 1, 1, 28, 25, 28, 1, 1, 700, 5}
//                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,8,10}
        };
        AllGCDPairs allGCDPairs = new AllGCDPairs();
        for(int[] testData : testSet){
            Utils.printSingleArr(allGCDPairs.solve(new ArrayList<>(Arrays.stream(testData).boxed().collect(Collectors.toList()))));
        }
//        System.out.println(allGCDPairs.findGCD(65,2));
    }

    public  ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int a : A){
            if(!freqMap.containsKey(a)){
                freqMap.put(a,0);
            }
            int currentVal = freqMap.get(a);
            freqMap.put(a,++currentVal);
        }
        result.add(A.get(A.size()-1));
        decrementFreq(freqMap,A.get(A.size()-1),1);
        for(int i=A.size()-2;i>0;i--){
            if(freqMap.size() == 0){
                break;
            }
            if(!freqMap.containsKey(A.get(i))){
                continue;
            }

            for(int j=0;j<result.size();j++){
                int num = findGCD(result.get(j),A.get(i));
                decrementFreq(freqMap,num,2);
            }
            int num = decrementFreq(freqMap,A.get(i),1);
            if(num != -1){
                result.add(num);
            }
        }
        return result;
    }

    int decrementFreq(HashMap<Integer,Integer> freqMap, int key,int decrementBy){
        if(!freqMap.containsKey(key)){
            return -1;
        }
        int currentFreq = freqMap.get(key);
        if(currentFreq <= decrementBy){
            freqMap.remove(key);
            return key;
        }
        freqMap.put(key,currentFreq-decrementBy);
        return key;
    }

    int findGCD(int A, int B){
        if(A==0 || B==0){
            return A == 0 ? B : A;
        }

        if(A==1 || B==1){
            return 1;
        }

        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }

        while(A > 0){
            int t = B%A;
            B = A;
            A = t;
        }

        return A == 0 ? B : A;
    }

}