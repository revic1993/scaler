package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class ReorderList {
    public static void main(String[] args) {
        ListNode A = Utils.populateLL(new int[]{1,2,3,4,5});
        ReorderList rl = new ReorderList();
        Utils.printLL(rl.reorderList(A));
    }

    public ListNode reorderList(ListNode A) {
        if(A.next == null){
            return A;
        }
        ListNode mid = midElement(A);

        if(mid.next == null){
            return A;
        }

        ListNode midNext = mid.next;
        mid.next = null;
        midNext = reverseList(midNext);
        ListNode currentF = A;
        ListNode currentM = midNext;
        while(currentM != null){
            ListNode next = currentF.next;
            ListNode mNext = currentM.next;
            currentF.next = currentM;
            currentM.next = next;
            currentM = mNext;
            currentF = next;
        }
        return A;
    }

    public ListNode midElement(ListNode A){
        ListNode current = A;
        if( current.next == null){
            return current;
        }

        ListNode mid = A;
        int currentPos = 1;
        int midPos = 1;

        while(current.next!=null){
            current = current.next;
            currentPos++;
            int nextPos = (currentPos>>1)+1;
            if(nextPos > midPos){
                mid = mid.next;
                midPos++;
            }
        }
        return mid;
    }

    public ListNode reverseList(ListNode B){
        ListNode current = B;
        ListNode prev = null;

        if(current == null || current.next == null){
            return B;
        }

        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
