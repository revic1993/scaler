package dsa.scaler.trees.BST;

import dsa.scaler.trees.structs.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBST {

    public static void main(String[] args) {

    }

    public int t2Sum(TreeNode A, int B) {
        if(A == null){
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        HashMap<Integer,Integer> nodeFreq = new HashMap<>();

        nodeQueue.add(A);
        while(!nodeQueue.isEmpty()){
            TreeNode current = nodeQueue.remove();

            if(current.left != null) nodeQueue.add(current.left);
            if(current.right != null) nodeQueue.add(current.right);

            nodeFreq.put(current.val,nodeFreq.containsKey(current.val) ? nodeFreq.get(current.val)+1 : 1);
        }

        for(int key : nodeFreq.keySet()){
            int searchNum = B - key;
            if(key != searchNum && nodeFreq.containsKey(searchNum) || key == searchNum && nodeFreq.containsKey(searchNum) && nodeFreq.get(searchNum) > 1){
                return 1;
            }
        }

        return 0;
    }
}
