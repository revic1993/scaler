package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode A = Utils.populateLL(new int[]{1,2});
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.lPalin(A));
    }

    public int lPalin(ListNode A) {
        if(A.next == null){
            return 1;
        }
        ListNode D = cloneList(A);
        ListNode B = reverseList(A);
        ListNode currentA = D;
        ListNode currentB = B;
        while(currentA != null && currentB!=null && currentB.val == currentA.val){
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentA==null || currentA.val == currentB.val ? 1 : 0;

    }

    public ListNode cloneList(ListNode A){
        ListNode current = A;
        ListNode head = new ListNode(current.val);
        ListNode cloneCurr = head;
        current = current.next;
        while(current != null){
            cloneCurr.next = new ListNode(current.val);
            current = current.next;
            cloneCurr = cloneCurr.next;
        }
        return head;
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
