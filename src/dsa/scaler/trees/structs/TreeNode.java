package dsa.scaler.trees.structs;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ val : ").append(val);
        if(left != null){
            sb.append(", left : ").append(left.val);
        }

        if(right != null){
            sb.append(", right : ").append(right.val);
        }

        sb.append(" }");
        return sb.toString();
    }
}
