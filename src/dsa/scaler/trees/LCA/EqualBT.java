package dsa.scaler.trees.LCA;

import dsa.scaler.trees.structs.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class EqualBT {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return A == B ? 1 : 0;
        }
        Queue<TreeNode> aLevelOrder = new LinkedList<>();
        Queue<TreeNode> bLevelOrder = new LinkedList<>();
        aLevelOrder.add(A);
        bLevelOrder.add(B);
        while(!aLevelOrder.isEmpty() && !bLevelOrder.isEmpty()){
            TreeNode currentA = aLevelOrder.remove();
            TreeNode currentB = bLevelOrder.remove();
            if(currentA.val != currentB.val){
                return 0;
            }
            if(currentA.left != null){
                aLevelOrder.add(currentA.left);
            }
            if(currentA.right != null){
                aLevelOrder.add(currentA.right);
            }
            if(currentB.left != null){
                aLevelOrder.add(currentB.left);
            }
            if(currentB.right != null){
                aLevelOrder.add(currentB.right);
            }
        }
        return !aLevelOrder.isEmpty() || !bLevelOrder.isEmpty() ? 0 : 1;
    }
}
