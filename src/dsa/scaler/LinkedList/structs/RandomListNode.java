package dsa.scaler.LinkedList.structs;


public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }
    public static void print(RandomListNode randomListNode){
        RandomListNode current = randomListNode;
        System.out.println();
        while(current!=null){
            System.out.print(current.toString());
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ label = "+this.label);
        if(next!=null){
            sb.append(", next = ").append(next.label);
        }
        if(random!=null){
            sb.append(", random = ").append(random.label);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
