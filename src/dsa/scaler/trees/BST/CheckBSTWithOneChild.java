package dsa.scaler.trees.BST;

import java.util.ArrayList;
import java.util.List;

public class CheckBSTWithOneChild {
    public static void main(String[] args) {
        CheckBSTWithOneChild cboc = new CheckBSTWithOneChild();
        System.out.println(cboc.solve(new ArrayList<>(List.of(25, 42, 49, 44, 2))));
    }

    public String solve(ArrayList<Integer> A) {
        if(A.size() <= 2){
            return "YES";
        }
        int[] range = {A.get(0) > A.get(1) ? Integer.MIN_VALUE : A.get(0) , A.get(0) > A.get(1) ? A.get(0) : Integer.MAX_VALUE};
        for(int i=2;i<A.size();i++){
            if(A.get(i) < range[0] || A.get(i) >= range[1]){
                return "NO";
            }
            if(A.get(i) > A.get(i-1)){
                range[0] = Math.max(range[0],A.get(i-1));
            }else{
                range[1] = Math.min(range[1],A.get(i-1));
            }
        }
        return "YES";
    }

}
