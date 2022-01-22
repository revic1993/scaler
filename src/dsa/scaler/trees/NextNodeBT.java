package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeLinkNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextNodeBT {
    public static void main(String[] args) {
        TreeLinkNode linkNode = Utils.generateBinaryTree(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1)));
        NextNodeBT nnbt = new NextNodeBT();
        nnbt.connect(linkNode);
    }
    public void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        TreeLinkNode last = root;
        while(!nodeQueue.isEmpty()){
            TreeLinkNode current = nodeQueue.remove();
            TreeLinkNode top = nodeQueue.isEmpty() ? null : nodeQueue.peek();
            current.next = current == last ? null : top;
            boolean isCurrentLast = current == last;
            if(current.left != null){
                last = isCurrentLast ? current.left : last;
                nodeQueue.add(current.left);
            }
            if(current.right != null){
                last = isCurrentLast ? current.right : last;
                nodeQueue.add(current.right);
            }
        }
    }
}
