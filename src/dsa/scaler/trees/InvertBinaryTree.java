package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode A) {
        if(A == null){
            return null;
        }
        TreeNode temp = A.left;
        A.left = invertTree(A.right);
        A.right = invertTree(temp);
        return A;
    }
}
