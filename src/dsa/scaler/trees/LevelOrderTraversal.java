package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        LevelOrderTraversal lot = new LevelOrderTraversal();
        Utils.print(lot.levelOrder(root));
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null){
            return result;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        TreeNode current = A;
        levelQueue.add(A);
        int totalDequeue = 1;
        while(!levelQueue.isEmpty()){
            int currentDequeue = 0;
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<totalDequeue;i++){
                TreeNode topNode = levelQueue.peek();

                if(topNode.left != null){
                    levelQueue.add(topNode.left);
                    currentDequeue++;
                }
                if(topNode.right != null){
                    levelQueue.add(topNode.right);
                    currentDequeue++;
                }
                currentLevel.add(topNode.val);
                levelQueue.remove();
            }
            totalDequeue = currentDequeue;
            result.add(currentLevel);
        }

        return result;
    }
}
