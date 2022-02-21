package dsa.scaler.graphs;

import dsa.scaler.graphs.struct.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        UndirectedGraphNode node6 = new UndirectedGraphNode(6);

        node4.neighbors.add(node5);
        node4.neighbors.add(node6);
        undirectedGraphNode.neighbors.add(node2);
        undirectedGraphNode.neighbors.add(node3);
        undirectedGraphNode.neighbors.add(node4);
        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(undirectedGraphNode);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        Deque<UndirectedGraphNode> bfsQ = new LinkedList<>();
        bfsQ.add(node);
        HashMap<Integer,ArrayList<Integer>> labelNeighborMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        while(!bfsQ.isEmpty()){
            UndirectedGraphNode ugNode = bfsQ.remove();
            visited.add(ugNode.label);
            labelNeighborMap.put(ugNode.label,getNeighborLabel(ugNode));
            for(UndirectedGraphNode neighbor : ugNode.neighbors){
                if(visited.contains(neighbor.label)){
                    continue;
                }
                bfsQ.add(neighbor);
            }
        }
        HashMap<Integer,UndirectedGraphNode> labelNodeMap = new HashMap<>();
        for(int label : labelNeighborMap.keySet()){
            labelNodeMap.put(label,new UndirectedGraphNode(label));
        }
        UndirectedGraphNode root = null;
        for(int label : labelNodeMap.keySet()){
            for(int neighbor : labelNeighborMap.get(label)){
                labelNodeMap.get(label).neighbors.add(labelNodeMap.get(neighbor));
            }

            if(label == node.label){
                root = labelNodeMap.get(label);
            }
        }
        return root;
    }

    public ArrayList<Integer> getNeighborLabel(UndirectedGraphNode node){
        ArrayList<Integer> neighborLabel = new ArrayList<>();
        for(UndirectedGraphNode neighbor : node.neighbors){
            neighborLabel.add(neighbor.label);
        }
        return neighborLabel;
    }


}
