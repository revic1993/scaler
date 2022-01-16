package dsa.scaler.trees.BST;

import dsa.scaler.trees.structs.TreeNode;

public class SortedArrayToBST{
    public static void main(String[] args) {
        
    }

     // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        if(A.length == 0){
            return null;
        }

        return generateRoot(A,0,A.length-1);
    }

    public TreeNode generateRoot(final int[] A, int start, int end){
        if(start > end) return null;
        int mid = (start+end) >> 1;
        
        TreeNode root = new TreeNode(A[mid]);
        root.left = generateRoot(A,start,mid-1);
        root.right = generateRoot(A,mid+1,end);

        return root;
    }
}