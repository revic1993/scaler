package dsa.scaler.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SquarefulArrays {
    public static void main(String[] args) {
        SquarefulArrays sqfa = new SquarefulArrays();
//        System.out.println(sqfa.solve(new ArrayList<>(List.of(42, 72, 76 ))));
//        System.out.println(sqfa.resultSet);
        System.out.println(sqfa.isCurrentArrPerfectSquare(new ArrayList<>(List.of(76, 42, 72))));
    }

    HashSet<String> resultSet = new HashSet<>();
    public int solve(ArrayList<Integer> A) {
        if(A.size() == 1){
            return 0;
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            indexes.add(i);
        }
        generateCom(A,new ArrayList<>(),new HashSet<>());
        return resultSet.size();
    }

    public void generateCom(ArrayList<Integer> A,ArrayList<Integer> currentList, HashSet<Integer> usedIndexes){
        if(currentList.size() > 1){
            ArrayList<Integer> result = new ArrayList<>();
            int prev = -1;
            for (Integer index : currentList) {
                int current = A.get(index);
                if(prev == -1){
                    prev = current;
                    result.add(current);
                    continue;
                }else{
                    if(!isPerfectSquare(prev,current)){
                        return;
                    }
                    result.add(current);
                    prev = current;
                }
            }
            if(currentList.size() == A.size()){
                resultSet.add(result.toString());
                return;
            }
        }



        for(int i=0;i<A.size();i++){
            if(usedIndexes.contains(i)){
                continue;
            }
            usedIndexes.add(i);
            currentList.add(i);
            generateCom(A,currentList,usedIndexes);
            currentList.remove(currentList.size()-1);
            usedIndexes.remove(i);
        }
    }

    public boolean isCurrentArrPerfectSquare(ArrayList<Integer> A){
        for(int i=0;i<A.size()-1;i++){
            if(!isPerfectSquare(A.get(i),A.get(i+1))){
                return false;
            }
        }
        return true;
    }

    public boolean isPerfectSquare(int a, int b){
        double root = Math.sqrt(a+b);
        return root-Math.floor(root) == 0;
    }
}
