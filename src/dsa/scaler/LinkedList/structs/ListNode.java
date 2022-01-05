package dsa.scaler.LinkedList.structs;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x; next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ val = "+val);
        if(next!=null){
            sb.append(", next = ").append(next.val);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
