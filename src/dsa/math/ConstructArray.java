package dsa.math;

import java.util.Arrays;

public class ConstructArray {
    public static void main(String[] args) {
        int[][] testSet = {
                {3,20,30},
                {4,20,30},
                {5,20,30},
                {6,20,30},
                {7,20,30},
                {15,20,30},
                {16,20,30},
                {3,7,13},
                {4,7,13},
                {5,7,13},
                {6,7,13},
                {7,7,13},
                {8,7,13},
                {10,7,13},
                {3,10,39},
                {3,2,18},
                {4,2,18},
                {5,2,18},
                {6,2,18},
                {7,2,18},
        };
        for(int[] testData : testSet){
            System.out.println("constructed array for "+Arrays.toString(testData)+" is "+ Arrays.toString(solve(testData[0],testData[1],testData[2])));
        }
    }

    public static int[] solve(final int A, final int B, final int C) {
        if(A == 2){
            return new int[]{B,C};
        }
        int[] result = new int[A];
        int gap = C-B;

        int currentFactor = gap;



        int tl = Math.min(A-1,(int)Math.floor(C/currentFactor)+ ((C % currentFactor)==0? -1 : 0));

        int bestLM = C - (tl * currentFactor);
        int bestRM = bestLM+currentFactor*(A-1);
        int bestGap = currentFactor;

        while(currentFactor >=1){
            if(gap % currentFactor != 0){
                currentFactor--;
                continue;
            }

            int ctl = Math.min(A-1,((int)Math.floor(C/currentFactor) + ((C % currentFactor)==0? -1 : 0)));
            int cBestLM = C - (ctl * currentFactor);
            int cBestRM = cBestLM+currentFactor*(A-1);

            if(cBestLM > B || cBestRM < C){
                break;
            }

            if(bestRM < cBestRM){
                currentFactor--;
                continue;
            }

            if(bestRM > cBestRM){
                bestRM = cBestRM;
                bestLM = cBestLM;
                bestGap = currentFactor;
                currentFactor--;
                continue;
            }

            if(bestLM > cBestLM){
                bestRM = cBestRM;
                bestLM = cBestLM;
                bestGap = currentFactor;
            }
            currentFactor--;
        }

        result[0] = bestLM;
        for(int i=1;i<A;i++){
            result[i] = result[i-1]+bestGap;
        }

        return result;
    }


}
