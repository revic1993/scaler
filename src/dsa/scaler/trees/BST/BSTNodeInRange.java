package dsa.scaler.trees.BST;

import dsa.scaler.trees.DeserializeBinaryTree;
import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTNodeInRange {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(15,12,20,10,14,16,27,8,-1,-1,-1,-1,-1,-1,-1)));
        BSTNodeInRange bstNodeInRange = new BSTNodeInRange();
        System.out.println(bstNodeInRange.countNodes(root,12,20));
    }
    public int solve(TreeNode A, int B, int C) {
        return countNodes(A,B,C);
    }

    private int countNodes(TreeNode a, int b, int c) {
        if(a == null ){
            return 0;
        }
        int countLeft = countNodes(a.left,b,c);
        int countRight = countNodes(a.right,b,c);
        int countCurrent = a.val < b || a.val > c ? 0 : 1;
        return countLeft+countRight+countCurrent;
    }
}
