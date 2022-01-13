package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        if(A == null){
            return result;
        }

        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(A);
        TreeNode prev = A;
        while(!nodeQueue.isEmpty()){
            TreeNode current = nodeQueue.remove();
            if(current.left != null){
                nodeQueue.addLast(current.left);
            }

            if(current.right != null){
                nodeQueue.addLast(current.right);
            }

            if(prev == current){
                result.add(current.val);
                if(!nodeQueue.isEmpty()){
                    prev = nodeQueue.peekLast();
                }
            }
        }

        return result;
    }
}
