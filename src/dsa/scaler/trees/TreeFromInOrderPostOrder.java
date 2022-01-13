package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeFromInOrderPostOrder {
    public static void main(String[] args) {
        TreeFromInOrderPostOrder tip = new TreeFromInOrderPostOrder();
        tip.buildTree(new ArrayList<>(List.of(7, 5, 6, 2, 3, 1, 4)),new ArrayList<>(List.of(5, 6, 3, 1, 4, 2, 7)));
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildForRoot(A,B,0,A.size()-1,A.size()-1);
    }

    public TreeNode buildForRoot(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder,int inStart, int inEnd, int postEnd){
        if(inStart > inEnd){
            return null;
        }

        if(inStart == inEnd){
            return new TreeNode(inOrder.get(inStart));
        }

        TreeNode root = new TreeNode(postOrder.get(postEnd));
        int i = inStart;
        while(i<=inEnd && root.val != inOrder.get(i)){
            i++;
        }

        root.left = buildForRoot(inOrder,postOrder,inStart,i-1,postEnd-inEnd+i-1);
        root.right = buildForRoot(inOrder,postOrder,i+1,inEnd,postEnd-1);
        return root;
    }
}
