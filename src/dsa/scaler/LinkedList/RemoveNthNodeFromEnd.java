package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.List;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode test = Utils.populateLL(new int[]{1,2,3,4,5});
        RemoveNthNodeFromEnd rnfe = new RemoveNthNodeFromEnd();
        Utils.printLL(rnfe.removeNthFromEnd(test,5));
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null){
            return null;
        }
        ListNode nthFromBack = null;
        ListNode current = A;
        int i=0;
        int total = 0;
        while(current!=null){
            if(i == B){
                if(nthFromBack == null){
                    nthFromBack = A;
                }else{
                    nthFromBack = nthFromBack.next;
                }
            }else{
                i++;
            }
            current = current.next;
            total++;
        }
        if(total == B){
            A = A.next;
            return A;
        }
        if(nthFromBack != null){
            nthFromBack.next = nthFromBack.next == null ? null : nthFromBack.next.next;
        }
        return A;
    }
}
