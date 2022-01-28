package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(3,-1,1,2,-1,-1,-1)));
        RecoverBST rbst = new RecoverBST();
        Utils.printSingleArr(rbst.recoverTree(root));
    }
    public ArrayList<Integer> recoverTree(TreeNode A) {
        return inOrderInPlace(A);
    }

    ArrayList<Integer> inOrderInPlace(TreeNode root){
        TreeNode current = root;
        ArrayList<Integer> currentSet = new ArrayList<>();
        currentSet.add(-1);
        currentSet.add(-1);
        currentSet.add(-1);
        ArrayList<Integer> firstSet = null;
        ArrayList<Integer> secondSet = null;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        while(current != null){
            if(current.left == null){
                addToSet(currentSet,i++,current.val);

                if(i >= 3 && !isInPlace(currentSet)){
                    secondSet = firstSet != null ?  (ArrayList<Integer>) currentSet.clone() : secondSet;
                    firstSet = firstSet!= null ? firstSet : (ArrayList<Integer>) currentSet.clone();
                }
                current = current.right;
                continue;
            }

            TreeNode predecesor = predecesor(current);
            if(predecesor.right == null){
                predecesor.right = current;
                current = current.left;
            }else{
                predecesor.right = null;
                addToSet(currentSet,i++,current.val);
                if(i >= 3 && !isInPlace(currentSet)){
                    secondSet = firstSet != null ?  (ArrayList<Integer>) currentSet.clone() : secondSet;
                    firstSet = firstSet!= null ? firstSet : (ArrayList<Integer>) currentSet.clone();
                }
                current = current.right;
            }
        }
        if(i == 2){
            result.add(currentSet.get(0));
            result.add(currentSet.get(1));
            Collections.sort(result);
        }else{
                if(secondSet!=null){
                    Collections.sort(firstSet);
                    Collections.sort(secondSet);
                    result.add(secondSet.get(0));
                    result.add(firstSet.get(2));
                }else{
                    secondSet = (ArrayList<Integer>) firstSet.clone();
                    Collections.sort(secondSet);
                    result.add(secondSet.get(0));
                    result.add(firstSet.get(0));
                }
        }
        return result;
    }

    void addToSet(ArrayList<Integer> currentSet,int i, int val){
        if(i < 3 ){
            currentSet.set(i,val);
            return;
        }
        currentSet.set(0,currentSet.get(1));
        currentSet.set(1,currentSet.get(2));
        currentSet.set(2,val);
    }

    boolean isInPlace(ArrayList<Integer> sortedSet){
        if(sortedSet.size() < 3){
            return true;
        }
        return sortedSet.get(0) <= sortedSet.get(1) && sortedSet.get(1) <= sortedSet.get(2);
    }

    TreeNode predecesor(TreeNode node){
        TreeNode current = node.left;
        while(current.right != null &&  current.right != node ){
            current = current.right;
        }
        return current;
    }

}

//            if(secondSet != null){
//                if(firstSet.get(2) == secondSet.get(1)){
//                    result.add(firstSet.get(1));
//                    result.add(firstSet.get(2));
//                }else{
//                    result.add(firstSet.get(1));
//                    result.add(secondSet.get(2));
//                }
//            }else{
//                secondSet = (ArrayList<Integer>) firstSet.clone();
//                Collections.sort(secondSet);
//                result.add(firstSet.get(0));
//                result.add(secondSet.get(0));