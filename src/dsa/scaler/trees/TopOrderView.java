package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopOrderView {
    public ArrayList<Integer> verticalOrderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }

        HashMap<Integer,Integer> nodeMap = new HashMap<>();
        Queue<NodeDistance> nodeDistanceQueue = new LinkedList<>();

        nodeDistanceQueue.add(new NodeDistance(A,0));
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        while(!nodeDistanceQueue.isEmpty()){
            NodeDistance current = nodeDistanceQueue.remove();
            if(current.node.left!=null){
                nodeDistanceQueue.add(new NodeDistance(current.node.left,current.distance-1));
            }

            if(current.node.right!=null){
                nodeDistanceQueue.add(new NodeDistance(current.node.right,current.distance+1));
            }

            if(!nodeMap.containsKey(current.distance)){
                nodeMap.put(current.distance, current.node.val);
            }

            minDistance = Math.min(minDistance,current.distance);
            maxDistance = Math.max(maxDistance,current.distance);
        }

        for(int i=minDistance;i<=maxDistance;i++){
            result.add(nodeMap.get(i));
        }

        return result;
    }

    static class NodeDistance{
        public TreeNode node;
        public int distance;

        public NodeDistance(TreeNode node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
}
