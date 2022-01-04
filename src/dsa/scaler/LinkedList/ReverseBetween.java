package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class ReverseBetween {
    public static void main(String[] args) {
        int[] testData = {97,63,89,34,82,95 , 4 , 70 , 14 , 41 , 38 , 83 , 49,32,68 , 56 , 99 , 52 , 33 , 54 };
        ListNode A = new ListNode(testData[0]);
        ListNode current = A;
        for(int i=1;i<testData.length;i++){
            current.next = new ListNode(testData[i]);
            current = current.next;
        }
        Utils.printLL(A);
        ReverseBetween ll = new ReverseBetween();
        ListNode reversed = ll.reverseBetween(A,13,15);
        Utils.printLL(reversed);
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode current = A;
        if(current == null || current.next == null){
            return A;
        }
        ListNode firstTail = null;
        ListNode secondHead = null;
        int i = 1;
        while(current != null && i < B){
            firstTail = current;
            current = current.next;
            i++;
        }

        if(current == null){
            return A;
        }

        secondHead = current;

        ListNode prev = null;
        ListNode next = current.next;
        int j = i;
        while(j < C){
            if(B==1){
                A = current.next;
            }
            current.next = prev;
            prev = current;
            current = next;
            if(current==null){
                break;
            }
            next = current.next;
            j++;
        }
        if(current == null){
            return A;
        }

        current.next = prev;

        if(firstTail != null){
            firstTail.next = current;
        }
        secondHead.next = next;
        return A;
    }

}
