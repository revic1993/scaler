package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ColorfulNumber {
    public static void main(String[] args) {
        ColorfulNumber cflNum = new ColorfulNumber();
        System.out.println(cflNum.colorful(8496753));
    }

    public int colorful(int A) {
        ArrayList<Integer> numList = new ArrayList<>();
        boolean hasOneOrZero = false;
        while(A > 0){
            int currentNum = A%10;
            A = A/10;
            hasOneOrZero = currentNum == 0 || currentNum == 1 || hasOneOrZero;
            numList.add(currentNum);
        }

        if(numList.size() == 1){
            return 1;
        }

        if(hasOneOrZero){
            return 0;
        }



        Collections.reverse(numList);
        HashSet<Integer> product = new HashSet<>();
        product.addAll(numList);
        if(product.size() < numList.size()){
            return 0;
        }

        for(int i=2;i<numList.size();i++){
            if(!currentWindowProductIsValid(numList,i,product)){
                return 0;
            }
        }
        return 1;
    }

    boolean currentWindowProductIsValid(ArrayList<Integer> numList, int windowSize,HashSet<Integer> product){
        int windowProduct = numList.get(0);

        for(int i=1;i<windowSize;i++){
            windowProduct*=numList.get(i);
        }
        if(product.contains(windowProduct)){
            return false;
        }else{
            product.add(windowProduct);
        }

        for(int i=windowSize;i<numList.size();i++){
            windowProduct = windowProduct/numList.get(i-windowSize);
            windowProduct*=numList.get(i);
            if(product.contains(windowProduct)){
                return false;
            }else{
                product.add(windowProduct);
            }
        }
        return true;
    }
}
