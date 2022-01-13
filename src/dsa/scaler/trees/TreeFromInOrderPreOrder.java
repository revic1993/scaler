package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;

public class TreeFromInOrderPreOrder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildForRoot(A,B,0,A.size()-1,0);
    }

    public TreeNode buildForRoot(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder,int inStart, int inEnd, int preStart){
        if(inStart > inEnd){
            return null;
        }

        if(inStart == inEnd){
            return new TreeNode(inOrder.get(inStart));
        }

        TreeNode root = new TreeNode(preOrder.get(preStart));
        int i = inStart;
        while(i <= inEnd && root.val != inOrder.get(i)){
            i++;
        }

        root.left = buildForRoot(preOrder, inOrder, inStart, i-1, preStart+1);
        root.right = buildForRoot(preOrder,inOrder,i+1,inEnd,preStart+(i-inStart)+1);
        return root;
    }
}
