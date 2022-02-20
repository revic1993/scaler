package dsa.scaler.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

public class FlipArray {
    public static void main(String[] args) {
        FlipArray fa = new FlipArray();
        System.out.println(fa.solve(new int[]{ 11, 10, 8, 6, 8, 11, 1, 10, 2, 3, 8, 3, 8, 12, 11, 1, 7, 5, 5, 12, 9, 4, 10, 3, 3, 3, 8, 8, 8, 6, 7, 7, 7, 6, 4, 2, 5, 8, 11, 10, 10, 10, 12, 9, 2, 3, 9, 12, 7, 6, 11, 8, 9, 9, 10, 3, 3, 5, 2, 10, 10, 9, 4, 9, 6, 11, 10, 2, 6, 1, 4, 7, 10, 3, 4, 3, 9, 4, 3, 8, 1, 1, 3}));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int min = Integer.MAX_VALUE;
    int total = Integer.MAX_VALUE;
    public int solve(final int[] A) {
        int totalSum = Arrays.stream(A).sum();
        flipArr(A,0,0,totalSum);
        return total;
    }

    void flipArr(final int[] A,int current,int totalFlipped,int currentTotal){
        if(currentTotal < 0){
            return;
        }
        if(current == A.length){
            if(min >= currentTotal){
                total = min == currentTotal ? Math.min(total,totalFlipped) : totalFlipped;
                min = currentTotal;
            }
            return;
        }

        flipArr(A,current+1,totalFlipped+1,currentTotal-2*A[current]);
        flipArr(A,current+1,totalFlipped,currentTotal);
    }


//    void flipArr(final int[] A,int current,int totalFlipped,int currentTotal){
//        if(current == A.length ){
//            System.out.println("currentTotal : "+currentTotal + " totalFlipped: "+totalFlipped);
//            if(currentTotal >= 0 && min >= currentTotal){
//                if(min == currentTotal ){
//                    total = Math.min(total,totalFlipped);
//                    return;
//                }
//                total = totalFlipped;
//                min = currentTotal;
//            }
//            return;
//        }
//
//        flipArr(A,current+1,totalFlipped,currentTotal+A[current]);
//        flipArr(A,current+1,totalFlipped+1,currentTotal-A[current]);
//    }
}
