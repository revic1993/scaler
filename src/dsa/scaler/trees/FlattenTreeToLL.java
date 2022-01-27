package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenTreeToLL {
    public static void main(String[] args) {
        FlattenTreeToLL fll = new FlattenTreeToLL();
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,6,9,-1,7,8,-1,-1,-1,-1,-1)));
        fll.flatten(root);
    }
    public TreeNode flatten(TreeNode a) {
        TreeNode[] node = flattenTree(a);
        return node[0];
    }

    public TreeNode[] flattenTree(TreeNode node){
        if(node == null){
            return new TreeNode[]{null,null}; // head,tail
        }
        TreeNode[] leftFlattened = flattenTree(node.left);
        TreeNode[] rightFlattened = flattenTree(node.right);
        node.left = null;
        TreeNode tailNode = null;
        if(leftFlattened[0]!=null){
            node.right = leftFlattened[0];
            leftFlattened[1].right = rightFlattened[0];
            tailNode = rightFlattened[1] == null ? leftFlattened[1] : rightFlattened[1];
        }else{
            node.right = rightFlattened[0];
            tailNode = rightFlattened[1] == null ? node : rightFlattened[1];
        }
        return new TreeNode[]{node,tailNode};
    }
}
