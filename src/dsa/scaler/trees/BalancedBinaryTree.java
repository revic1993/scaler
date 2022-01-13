package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalancedTree = true;
    public int isBalanced(TreeNode A) {
        findHeight(A);
        return isBalancedTree ? 1 : 0;
    }

    public int findHeight(TreeNode node){
        if(!isBalancedTree){
            return Integer.MIN_VALUE;
        }

        if(node == null){
            return -1;
        }

        int leftHeight = node.left == null ? -1 : findHeight(node.left);
        int rightHeight = node.right == null ? -1 : findHeight(node.right);

        if(leftHeight==Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(Math.abs(leftHeight-rightHeight) <= 1){
            return Math.max(leftHeight,rightHeight)+1;
        }else{
            this.isBalancedTree = false;
            return Integer.MIN_VALUE;
        }
    }
}
