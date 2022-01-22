package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EqualPartition {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(1,7,-6,-9,5,-3,-4,-3,9,9,-9,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
        EqualPartition ep = new EqualPartition();
        System.out.println(ep.solve(root));
    }
    boolean partitionFlag = false;
    public int solve(TreeNode A) {
        HashSet<Integer> sumSet = new HashSet<>();
        int sum = findSum(A,sumSet);
        if((sum & 1 ) != 0){
            return 0;
        }

        sum = sum>>1;

        return sumSet.contains(sum) ? 1 : 0;
    }

    public int findSum(TreeNode node,HashSet<Integer> sumSet){
        int leftSum  = 0;
        int rightSum = 0;

        if(node.left != null){
            leftSum = findSum(node.left,sumSet);
            sumSet.add(leftSum);
        }
        if(node.right!=null){
            rightSum = findSum(node.right,sumSet);
            sumSet.add(rightSum);
        }
        return leftSum+rightSum+node.val;
    }
}
