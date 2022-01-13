package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OddEvenLevels {
    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode A = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,6,7,8,-1,-1,-1,-1,-1,-1)));
        OddEvenLevels oel = new OddEvenLevels();
        System.out.println(oel.solve(A));
    }

    public int solve(TreeNode A) {
        if(A == null){
            return 0;
        }

        Queue<NodeSign> nodeQueue = new LinkedList<>();
        nodeQueue.add(new NodeSign(A,true));
        int total = 0;
        while(!nodeQueue.isEmpty()){
            NodeSign current = nodeQueue.remove();
            total += current.isPositive ? current.node.val : (-1*current.node.val);
            if(current.node.left!=null){
                nodeQueue.add(new NodeSign(current.node.left,!current.isPositive));
            }

            if(current.node.right!=null){
                nodeQueue.add(new NodeSign(current.node.right,!current.isPositive));
            }
        }
        return total;
    }

    static class NodeSign{
        public TreeNode node;
        public boolean isPositive;

        public NodeSign(TreeNode node,boolean isPositive){
            this.node = node;
            this.isPositive = isPositive;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{ val : ");
            if(!isPositive){
                sb.append("-");
            }
            sb.append(node.val).append(" }");
            return sb.toString();
        }
    }
}
