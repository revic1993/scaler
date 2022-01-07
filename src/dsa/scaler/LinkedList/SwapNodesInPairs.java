package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode testData = Utils.populateLL(new int[]{1});
        SwapNodesInPairs snip = new SwapNodesInPairs();
        Utils.printLL(snip.swapPairs(testData));
    }

    public ListNode swapPairs(ListNode A) {
        if(A.next == null){
            return A;
        }
        ListNode current = A;
        ListNode firstPrev = null;
        ListNode secondPrev = null;
        int counter = 0;
        while(current!=null){
            counter++;
            ListNode next = current.next;
            if((counter & 1) == 0 ){
                secondPrev.next = next;
                current.next = secondPrev;
                if(firstPrev!=null){
                    firstPrev.next = current;
                }
                if(counter == 2){
                    A = current;
                }
            }else{
                firstPrev = secondPrev;
                secondPrev = current;
            }
            current = next;
        }
        return A;
    }
}
