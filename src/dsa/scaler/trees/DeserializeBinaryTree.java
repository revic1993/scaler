package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeserializeBinaryTree {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        System.out.println(dbt.solve(new ArrayList<>(List.of(1, 2, 3, 5, 6, 4, -1, -1, -1, -1, -1, 7, -1, -1, -1 ))));
    }

    public TreeNode solve(ArrayList<Integer> A) {
        if(A.size() == 0){
            return null;
        }

        int nextPointer = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        nodeQueue.add(root);


        while(nextPointer < A.size() && !nodeQueue.isEmpty()){
            TreeNode current = nodeQueue.remove();
            if(current == null){
                continue;
            }
            nextPointer++;
            TreeNode leftNode = nextPointer < A.size() && A.get(nextPointer) != -1 ?  new TreeNode(A.get(nextPointer)) : null;
            nextPointer++;
            TreeNode rightNode = nextPointer < A.size() && A.get(nextPointer) != -1 ?  new TreeNode(A.get(nextPointer)) : null;
            current.left = leftNode;
            current.right = rightNode;
            nodeQueue.add(leftNode);
            nodeQueue.add(rightNode);
        }
        return root;
    }
}
