package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(92 ,82 ,85 ,81 ,83 ,-1 ,88 ,70 ,-1 ,-1 ,-1 ,86 ,91 ,69 ,78 ,-1 ,87 ,89 ,84 ,-1 ,-1 ,76 ,80 ,-1 ,-1 ,-1 ,90 ,-1 ,96 ,75 ,77 ,79 ,-1 ,-1 ,-1 ,95 ,-1 ,74 ,-1 ,-1 ,-1 ,-1 ,-1 ,93 ,-1 ,72 ,-1 ,-1 ,94 ,71 ,73 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1)));
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
