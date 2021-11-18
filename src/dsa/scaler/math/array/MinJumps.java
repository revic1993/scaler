package dsa.scaler.math.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MinJumps {

    public static void main(String[] args) {
        int[][] testSet = {
                {29, 61, 17, 3, 66, 16, 56, 13, 49, 79, 7, 7, 40, 8, 49, 66, 30, 46, 79, 19, 77, 97, 97, 43, 22, 77, 81, 76, 15, 80, 64, 33, 70, 15, 81, 31, 50, 25, 96, 73, 49, 47, 7, 82, 13, 53, 77, 57, 89, 88, 84, 60, 78, 68, 23, 62, 75, 7, 81, 41, 94, 16, 42, 68, 2, 62, 48, 84, 4, 49, 9, 48, 13, 42, 61, 58, 30, 8, 48, 89, 15, 60, 8, 58, 13, 87, 26, 45, 11, 42, 26, 0, 48, 10, 82, 45, 45, 88, 11, 52, 47, 59, 53, 97, 54, 10, 12, 31, 22, 7, 95, 65, 9, 86, 63, 86, 81, 65, 62, 20, 44, 58, 93, 43, 58, 52, 33, 80, 26, 90, 56, 81, 38, 15, 90, 89, 24, 51, 48, 57, 37, 100, 61, 7, 65, 80, 0, 7, 62, 14, 32, 16, 82, 66, 80, 12, 43, 54, 40, 45, 12, 44, 28, 53, 22, 83, 25, 84, 87, 84, 15, 37, 46, 74, 14, 41, 2, 26, 7, 74, 84, 67, 43, 56, 15, 96, 49, 98, 80, 94, 49, 74, 46, 93, 29, 87, 3, 79, 89, 46, 11, 49, 79, 30, 65, 8, 69, 11, 28, 81, 5, 31, 99, 36, 95, 74, 28, 1, 84, 59, 36, 69, 56},
//                {1,2,1,2,5},
//                {5,17,100,11},
//                {2,3,1,1,4},
                {3,2,1,0,4},
                {3,1,2,0,4},
//                {1,1,1,1,1},
//                {1, 8, 7, 5, 4, 9, 4, 9, 6, 1, 6, 1, 3, 6, 2, 3, 5, 5 },
//                {3, 6, 6, 10, 6, 1, 3, 1, 10, 1, 1, 10, 1, 7, 7, 2, 3, 1, 2, 4, 5, 8, 7, 2, 6, 8, 6, 7, 5, 4, 10, 4, 8, 10, 8},
                {1, 2, 3, 4, 5}
        };
        for(int[] testData : testSet){
            System.out.println(Arrays.toString(testData) + " => " +solve(testData));
        }
    }

    public static int solve(int[] A){
        if(A[0] == 0){
            return -1;
        }

        int[] pendingJumps = new int[A.length-1];

        for(int i=0;i<A.length-1;i++){
            pendingJumps[i] = A[i] != 0 ? Math.max(0,A.length-1 - A[i]-i)+1 : Integer.MAX_VALUE;
        }

        int nextIndex = 0;
        int jumps = 1;
        while(nextIndex < A.length){
            int steps = A[nextIndex];
            int minJumps = pendingJumps[nextIndex];
            if(minJumps == 1){
                break;
            }
            int k = nextIndex+1;
            int currentIndex = nextIndex;
            int limit = Math.min(A.length-1,steps+k);
            while(k < limit){
                if(pendingJumps[k] < minJumps){
                    nextIndex = k;
                    minJumps = pendingJumps[k];
                    if(minJumps == 1){
                        nextIndex = A.length;
                        break;
                    }
                }
                k++;
            }
            if(nextIndex == currentIndex){
                return -1;
            }
            jumps++;
        }
        return jumps;
    }


    /*
    recursive approach
    public static int solve(int[] A) {
        int result = 0;
        int indexToReach = -1;

        for(int i=0;i<A.length-1;i++){
            if(Math.max(0,A.length - i - A[i] - 1) == 0){
                indexToReach = i;
                break;
            }
        }

        if(indexToReach == -1){
            return -1;
        }
        int[] reachArr = new int[A.length];
        for(int i=0;i<reachArr.length;i++){
            reachArr[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<=indexToReach;i++){
            for(int j=i+1;j<A[i];j++){
                reachArr
            }
        }

        HashMap<Integer,Integer> memo = new HashMap<>();
        return totalMinJumps(0,indexToReach,A,memo);
    }

    static int totalMinJumps(int start,int indexToReach,int[] A,HashMap<Integer,Integer> memo){
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        if(start == indexToReach || start >= A.length){
            memo.put(start,1);
            return 1;
        }

        int minJumps = Integer.MAX_VALUE;

        for(int i=1;i<=A[start];i++){
            int jumps = totalMinJumps(start+i,indexToReach,A,memo);
            if(jumps != Integer.MAX_VALUE &&  jumps + 1 < minJumps){
                minJumps = jumps + 1;
            }

        }
        memo.put(start,minJumps);
        return minJumps;
    }*/
}
