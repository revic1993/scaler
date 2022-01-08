package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.List;

public class PartitionList {
    public static void main(String[] args) {
        ListNode testData = Utils.populateLL(new int[]{384,183,363,31});
        PartitionList pl = new PartitionList();
        Utils.printLL(pl.partition(testData,77));
    }

    public ListNode partition(ListNode A, int B) {
        //handle case when first is > B

        ListNode firstHalf = null;
        ListNode secondHalf = null;
        ListNode current = A;
        ListNode fp;
        ListNode sp;
        if(current.val >= B){
            secondHalf = A;
            sp = secondHalf;
            while(secondHalf.next!=null && secondHalf.next.val >= B){
                secondHalf = secondHalf.next;
            }
            firstHalf = secondHalf.next;
            if(firstHalf == null){
                return A;
            }
            A = firstHalf;
            fp = firstHalf;
            secondHalf.next = null;
            if(firstHalf.next == null){
                firstHalf.next = sp;
                return firstHalf;
            }
            current = firstHalf.next;
            firstHalf.next = null;
        }else{
            firstHalf = A;
            fp = A;
            while(firstHalf.next!=null && firstHalf.next.val < B){
                firstHalf = firstHalf.next;
            }
            secondHalf = firstHalf.next;
            sp = secondHalf;
            if(secondHalf == null){
                return A;
            }
            firstHalf.next = null;
            if(secondHalf.next == null){
                firstHalf.next = sp;
                return fp;
            }
            current = secondHalf.next;
            secondHalf.next = null;
        }

        while(current!=null){
            ListNode next = current.next;
            if(current.val >= B){
                secondHalf.next = current;
                secondHalf = secondHalf.next;
                secondHalf.next = null;
            }else{
                firstHalf.next = current;
                firstHalf = firstHalf.next;
                firstHalf.next = null;
            }
            current = next;
        }

        firstHalf.next = sp;
        return A;
    }
}
