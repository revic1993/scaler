package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {

    }
    public int kthsmallest(final List<Integer> A, int B) {
        ArrayList<Integer> copyArr = new ArrayList<>(A);

        for(int i=0;i<B;i++){
            int minInd = i;
            for(int j=i+1;j<copyArr.size();j++){
                if(copyArr.get(minInd) > copyArr.get(j)){
                    minInd = j;
                }
            }
            if(minInd != i){
                int temp = copyArr.get(minInd);
                copyArr.set(minInd,copyArr.get(i));
                copyArr.set(i, temp);
            }
        }
        return copyArr.get(B-1);
    }
}
