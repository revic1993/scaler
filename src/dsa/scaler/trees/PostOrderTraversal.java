package dsa.scaler.trees;

import com.sun.source.tree.Tree;
import dsa.scaler.trees.structs.TreeNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        TreeNode root = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,-1,6,-1,-1,7,-1,-1,-1)));

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        Utils.printSingleArr(postOrderTraversal.postorderTraversal(root));
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }

        Stack<TreeNode> postOrderStack = new Stack<>();
        TreeNode current = A;
        postOrderStack.push(A);
        TreeNode prev = null;

        while(!postOrderStack.isEmpty()){
            current = postOrderStack.peek();
            if(current == null){
                postOrderStack.pop();
                prev = null;
                continue;
            }

            if((current.left == null && current.right == null) || current.right == prev){
                postOrderStack.pop();
                result.add(current.val);
                prev = current;
                continue;
            }

            if(current.left == null || current.left == prev){
                postOrderStack.push(current.right);
                prev = current;
            }else{
                postOrderStack.push(current.left);
                prev = current;
            }
        }

        return result;
    }
}
