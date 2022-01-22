package dsa.scaler.trees.structs;

public class TreeLinkNode {
    public TreeLinkNode next;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public int val;
    public TreeLinkNode(int x) {
        val = x;
        next = null;
        left = null;
        right = null;
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

        if(next != null){
            sb.append(", next : ").append(next.val);
        }

        sb.append(" }");
        return sb.toString();
    }
}
