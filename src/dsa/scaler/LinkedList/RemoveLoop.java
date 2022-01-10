package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class RemoveLoop {
    public static void main(String[] args) {
        ListNode testData = Utils.populateLL(new int[]{3,2,4,5,6});
        ListNode randomNode = null;
        ListNode current = testData;
        for(int i=0;i<3;i++){
            current = current.next;
        }
        randomNode = current;
        while(current.next!=null){
            current = current.next;
        }
        current.next = randomNode;
        RemoveLoop rl = new RemoveLoop();
        Utils.printLL(rl.solve(testData));
    }

    public ListNode solve(ListNode A) {
        if(A.next == null){
            return A;
        }

        ListNode slowPointer = A;
        ListNode fastPointer = A;
        ListNode x = A;
        ListNode y = null;
        slowPointer = A.next;
        fastPointer = A.next.next;
        while(slowPointer != fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        y = slowPointer;
        while(x != y){
            x = x.next;
            y = y.next;
        }
        ListNode head = y;
        ListNode current = head;
        while(current.next != head){
            current = current.next;
        }
        current.next = null;
        return A;
    }

}
