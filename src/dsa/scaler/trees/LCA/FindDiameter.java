package dsa.scaler.trees.LCA;

import dsa.scaler.trees.structs.TreeNode;

public class FindDiameter {
    int diameter = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        return diameter;
    }
    int findDiameter(TreeNode node){
        if(node == null){
            return -1;
        }

        int left = findDiameter(node.left);
        int right = findDiameter(node.right);
        diameter = Math.max(diameter,left+right+2);
        return Math.max(left,right)+1;
    }
}
