package dsa.scaler.math.modulo;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        ArrayList<Integer>[] testSet = new ArrayList[]{
                new ArrayList(Arrays.asList(4,0,2,1,3)),
                new ArrayList(Arrays.asList(0,2,4,3,1)),
                new ArrayList(Arrays.asList(0,1,2,3)),
                new ArrayList(Arrays.asList(0,4,2,3,1,5)),
                new ArrayList(Arrays.asList(5,4,3,2,1,0))
        };
        RearrangeArray rar = new RearrangeArray();
        for(ArrayList<Integer> testData : testSet){
            System.out.print("Test data "+Arrays.toString(testData.toArray())+" is ");
            rar.arrange(testData);
            System.out.println(Arrays.toString(testData.toArray()));
        }
    }

    public void arrange(ArrayList<Integer> A) {
        int N = A.size();
        //we have to preserve previous and next value, we can use mod property for that
        for(int i=0;i<N;i++){
            int currVal = A.get(i);
            int nextVal = A.get(A.get(i));
            A.set(i, currVal + ((nextVal)%N)*N);
        }

        for(int i=0;i<N;i++){
            int currVal = (int) Math.floor(A.get(i)/N);
            A.set(i,currVal);
        }
    }
}
