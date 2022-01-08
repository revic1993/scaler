package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode firstList = Utils.populateLL(new int[]{5,8,20});
        ListNode secondList = Utils.populateLL(new int[]{4,11,15});
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        Utils.printLL(mtsl.mergeTwoLists(firstList,secondList));
    }


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null){
            return B;
        }

        if(B == null){
            return A;
        }

        ListNode head;
        ListNode secondaryList; // 14->15
        ListNode primaryList; // 4 -> 5 ->  8 -> 11 -> 20
        if(A.val > B.val){
            head = B;
            secondaryList = A;
        }else{
            head = A;
            secondaryList = B;
        }
        primaryList = head;
        while(secondaryList!=null){
            while(primaryList.next != null && primaryList.next.val < secondaryList.val){
                primaryList = primaryList.next;
            }

            if(primaryList.next == null){
                primaryList.next = secondaryList;
                return head;
            }
            ListNode pNext = primaryList.next;
            ListNode sNext = secondaryList.next;
            primaryList.next  = secondaryList;
            secondaryList.next = pNext;
            secondaryList = sNext;
            primaryList = primaryList.next;
        }


        return head;
    }
}
