package dsa.scaler.trees;

import dsa.scaler.trees.structs.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElement {
    static int k = 0;
    public int kthsmallest(TreeNode A, int B) {
        k = B;
        return find(A);
    }

    public static int find(TreeNode root) {
        if (root == null)
            return -1;
        // We do an inorder traversal here.
        int k1 = find(root.left);
        if (k == 0)
            return k1; // left subtree has k or more elements.
        k--;
        if (k == 0)
            return root.val; // root is the kth element.
        return find(root.right); // answer lies in the right node.
    }
}
