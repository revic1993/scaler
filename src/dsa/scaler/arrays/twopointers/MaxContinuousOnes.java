package dsa.scaler.arrays.twopointers;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MaxContinuousOnes {
    public static void main(String[] args) {
        MaxContinuousOnes mco = new MaxContinuousOnes();
        Utils.printSingleArr(mco.maxone(new ArrayList<>(List.of(1,1,0,1,1,0,0,1,1,1)),0));
//        Utils.printSingleArr(mco.maxone(new ArrayList<>(List.of(0, 1, 1, 1)),0));
//        Utils.printSingleArr(mco.maxone(new ArrayList<>(List.of(1, 0, 0, 0, 1, 0, 1)),2));

    }
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> zeroIndex = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<A.size();i++){
            int a = A.get(i);
            if(a == 0){
                zeroIndex.add(i);
            }
        }


        if(zeroIndex.size()==0 || zeroIndex.size() < B){
            for(int i=0;i<A.size();i++){
                result.add(i);
            }
            return result;
        }


        int i = 0;
        int finalLow = 0, finalHigh = 0;
        int max = Integer.MIN_VALUE;

        if(B == 0){
            int low = -1;
            int high = zeroIndex.get(0);
            int currentMax = high;
            for(int j=0;j < zeroIndex.size();j++){
                low = zeroIndex.get(j);
                high = j+1 == zeroIndex.size() ? A.size() : zeroIndex.get(j+1);
                if(currentMax < (high-low-1)){
                    currentMax = high-low-1;
                    finalLow = low+1;
                    finalHigh = high;
                }
            }
        }else{
            for(int j=0;j<zeroIndex.size();j++){
                int low = j == 0 ? 0 : zeroIndex.get(j-1)+1;
                int high = j+B >= zeroIndex.size() ? A.size() : zeroIndex.get(j+B);
                if(max < high-low){
                    finalLow = low;
                    finalHigh = high;
                    max = high-low;
                }
            }
        }

        for(int j=finalLow;j<finalHigh;j++){
            result.add(j);
        }
        return result;
    }
}
