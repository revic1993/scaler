package dsa.scaler.trees.LCA;

import com.sun.source.tree.Tree;
import dsa.scaler.trees.DeserializeBinaryTree;
import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLCA {

    public static void main(String[] args) {
        TreeNode test = null;
        DeserializeBinaryTree dbt = new DeserializeBinaryTree();
        test = dbt.solve(new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
        FindLCA flca = new FindLCA();
        System.out.println(flca.lca(test,10,11));
    }
    int timer = 0;
    HashMap<Integer,Integer> inTime = new HashMap<>();
    HashMap<Integer,Integer> outTime = new HashMap<>();
    public int lca(TreeNode A, int B, int C) {
        postInOrder(A);
        if(!inTime.containsKey(B) || !inTime.containsKey(C) ){
            return -1;
        }
        TreeNode lca = findLCA(A,Math.min(inTime.get(B),inTime.get(C)),Math.max(outTime.get(B),outTime.get(C)));
        return lca.val;
    }

    private TreeNode findLCA(TreeNode a, int in,int out) {
        if(a.left != null && inTime.get(a.left.val) <= in && outTime.get(a.left.val) >= out){
            return findLCA(a.left,in,out);
        }
        if(a.right != null && inTime.get(a.right.val) <= in && outTime.get(a.right.val) >= out){
            return findLCA(a.right,in,out);
        }
        return a;
    }

    public void postInOrder(TreeNode node){
        if(node == null){
            return;
        }
        inTime.put(node.val,timer++);
        postInOrder(node.left);
        postInOrder(node.right);
        outTime.put(node.val,timer++);
    }
}
