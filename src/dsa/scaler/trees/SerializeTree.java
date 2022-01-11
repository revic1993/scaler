package dsa.scaler.trees;


import dsa.scaler.trees.structs.TreeNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeTree {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,-1,6,-1,-1,7,-1,-1,-1)));
        SerializeTree st = new SerializeTree();
        Utils.printSingleArr(st.solve(root));

    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(A);
        while(!nodeQueue.isEmpty()){
            TreeNode current = nodeQueue.remove();
            result.add(current == null ? -1 : current.val);
            if(current == null){
                continue;
            }
            nodeQueue.add(current.left);
            nodeQueue.add(current.right);
        }

        return result;
    }
}
