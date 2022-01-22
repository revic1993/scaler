package dsa.scaler.trees.LCA;

import dsa.scaler.trees.DeserializeBinaryTree;
import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenNodes {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode bst = dbt.solve(new ArrayList<>(List.of(5,2,8,1,4,6,11,-1,-1,-1,-1,-1,-1,-1,-1)));
        DistanceBetweenNodes dbn = new DistanceBetweenNodes();
        System.out.println(dbn.solve(bst,4,11));
    }

    public int solve(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A,B,C);
        int bHeight = findHeight(lca,B);
        int cHeight = findHeight(lca,C);
        return bHeight+cHeight;
    }

    TreeNode findLCA(TreeNode node, int B, int C){
        if(node == null){
            return node;
        }
        if(node.val < B && node.val < C){
            return findLCA(node.right,B,C);
        }
        if(node.val > B && node.val > C){
            return findLCA(node.left,B,C);
        }
        return node;
    }

    int findHeight(TreeNode root,int B){
        if(root == null){
            return 0;
        }
        if(root.val < B){
            return findHeight(root.right,B)+1;
        }
        if(root.val > B){
            return findHeight(root.left,B)+1;
        }
        return 0;
    }
}
