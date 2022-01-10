package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.List;

public class MergeSortList {

    public static void main(String[] args) {
        ListNode test = Utils.populateLL(new int[]{5,3,1,2,4});
        MergeSortList msl = new MergeSortList();
        Utils.printLL(msl.sortList(test));
    }


    public ListNode sortList(ListNode A){
        if(A.next == null){
            return A;
        }
        if(A.next.next == null){
            if(A.val > A.next.val){
                ListNode head = A.next;
                A.next = null;
                head.next = A;
                return head;
            }
            return A;
        }
        ListNode mid = findMid(A);
        ListNode nextMid = mid.next;
        mid.next = null;
        ListNode firstSorted = sortList(A);
        ListNode secondSorted = sortList(nextMid);
        return merge(firstSorted,secondSorted);
    }

    public ListNode merge(ListNode A,ListNode B){
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;

        while (A != null && B != null) {
            if (A.val <= B.val) {
                node.next = A;
                A = A.next;
            } else {
                node.next = B;
                B = B.next;
            }
            node = node.next;
        }

        if (A == null)
            node.next = B;
        else
            node.next = A;
        head = head.next;
        return head;
    }

    ListNode findMid(ListNode A){
        if(A == null || A.next == null){
            return A;
        }

        ListNode mid = A;
        ListNode current = A;
        int counter = 1;
        while(current != null){
            if(counter!= 1 && (counter & 1) != 0){
                mid = mid.next;
            }
            counter++;
            current = current.next;
        }
        return mid;
    }
}
