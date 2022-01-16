package dsa.scaler.trees.BST;

import dsa.scaler.trees.DeserializeBinaryTree;
import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    boolean isValid = true;
    int maxHeadNodes = Integer.MIN_VALUE;
    TreeNode head = null;
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode node = dbt.solve(new ArrayList<>(List.of(44,30,49,18,40,47,18,9,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
        ValidBST validBST = new ValidBST();
        System.out.println(validBST.isValidBST(node));
        /*
        * 19 -> 44.30
        * 44->49.18
        * 30->40.47
        * 49->18.9
        * 18->*/
    }


    public int isValidBST(TreeNode A) {
        checkValid(A);
        return isValid ? 1 : 0;
    }

    public int[] checkValid(TreeNode A){
        if(A == null || !isValid){
            // 0->min,1->max
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        int[] left = checkValid(A.left);
        int[] right = checkValid(A.right);

        if(!isValid || A.val <= left[1] || A.val > right[0]){
            isValid = false;
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int currentNodes = left[2]+right[2]+1;
        if(head == null || maxHeadNodes < currentNodes){
            maxHeadNodes = currentNodes;
            head = A;
        }

        return new int[]{Math.min(A.val,left[0]),Math.max(A.val,right[1]),currentNodes};
    }


}
