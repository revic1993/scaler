package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

public class TreeToDoublyLL {
    TreeNode solve (TreeNode root) {
        TreeNode[] doublyFlattened = flatten(root);
        return doublyFlattened[0];
    }
    TreeNode[] flatten(TreeNode node){
        if(node == null){
            return new TreeNode[]{null,null};
        }

        TreeNode[]flattenedLeft = flatten(node.left);
        TreeNode[] flattenedRight = flatten(node.right);

        //link left subtree's tail node with parent
        if(flattenedLeft[0] != null ){
            flattenedLeft[1].right = node;
            node.left = flattenedLeft[1];
        }

        //link right subtree's head node with parent
        if(flattenedRight[1] != null){
            flattenedRight[0].left = node;
            node.right = flattenedRight[0];
        }

        //identify head and tail of current doubly linked list
        TreeNode head = flattenedLeft[0] != null ? flattenedLeft[0] : node;
        TreeNode tail = flattenedRight[1] != null ? flattenedRight[1] : node;

        //link head and tail to form new doubly linked list
        head.left = tail;
        tail.right = flattenedLeft[0];
        return new TreeNode[]{head,tail};
    }
}
