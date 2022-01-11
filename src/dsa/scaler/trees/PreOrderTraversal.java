package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;
import dsa.utils.Utils;

import java.util.*;

public class PreOrderTraversal {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,-1,6,-1,-1,7,-1,-1,-1)));

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        Utils.printSingleArr(preOrderTraversal.preorderTraversal(root));
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> preOrderStack = new Stack<>();
        if(A == null){
            return result;
        }

        TreeNode current = A;
        preOrderStack.push(current);
        while(!preOrderStack.isEmpty()){
            if(preOrderStack.peek() == null){
                preOrderStack.pop();
                continue;
            }
            current = preOrderStack.peek();
            preOrderStack.add(current.right);
            preOrderStack.add(current.left);
            result.add(current.val);

        }
        return result;
    }
}
