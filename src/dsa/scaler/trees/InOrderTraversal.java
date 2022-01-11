package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode newNode = new TreeNode(1);
        TreeNode root = newNode;
        newNode.right = new TreeNode(2);
        newNode = newNode.right;
        newNode.left = new TreeNode(3);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println(inOrderTraversal.inorderTraversal(root));
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> inOrderStack = new Stack<>();
        if(A == null){
            return result;
        }

        TreeNode current = A;
        inOrderStack.push(current);
        while(!inOrderStack.isEmpty() || current != null){
            if(current != null){
                inOrderStack.push(current.left);
                current = current.left;
                continue;
            }
            inOrderStack.pop(); //pop null node;
            if(inOrderStack.isEmpty()){
                break;
            }
            current = inOrderStack.pop();
            if(current == null){
                break;
            }
            result.add(current.val);
            current = current.right;
            inOrderStack.push(current);
        }
        return result;
    }
}
