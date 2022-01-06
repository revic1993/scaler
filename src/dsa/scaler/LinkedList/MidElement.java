package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class MidElement {

    public static void main(String[] args) {
        ListNode A = Utils.populateLL(new int[]{1,2,3,4,5});
        MidElement me = new MidElement();
        System.out.println(me.solve(A));
    }

    public int solve(ListNode A){
        ListNode current = A;
        if( current.next == null){
            return current.val;
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
        return mid.val;
    }
}
