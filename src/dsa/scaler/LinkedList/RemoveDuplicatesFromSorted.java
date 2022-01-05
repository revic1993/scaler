package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class RemoveDuplicatesFromSorted {
    public static void main(String[] args) {
        int[] testData = {1,1,2,2,3,3,3,4,5,6,6,7};
        ListNode A = new ListNode(testData[0]);
        ListNode current = A;
        for(int i=1;i<testData.length;i++){
            current.next = new ListNode(testData[i]);
            current = current.next;
        }
        Utils.printLL(A);
        RemoveDuplicatesFromSorted rdfs = new RemoveDuplicatesFromSorted();
        ListNode sanitized = rdfs.deleteDuplicates(A);
        Utils.printLL(sanitized);
    }

    public ListNode deleteDuplicates(ListNode A) {
        if(A == null){
            return null;
        }

        ListNode current = A;
        while(current!=null){
            while(current.next!=null && current.next.val == current.val){
                current.next = current.next.next;
            }
            current = current.next;
        }
        return A;
    }
}
