package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class KReverseList {
    public static void main(String[] args) {
        ListNode testData = Utils.populateLL(new int[]{1,2,3,4,5,6});
        KReverseList krl = new KReverseList();
        Utils.printLL(krl.reverseList(testData,2));
    }

    public ListNode reverseList(ListNode A, int B) {
        if(B == 1){
            return A;
        }
        //6 2
        //1->B, B+1->2B, 2B+1 -> 3B
        // 1->,4->6
        ListNode current = A;
        int counter = 0;
        while(current!=null){
            current = current.next;
            counter++;
        }
        for(int i=0;i<counter/B;i++){
            int b = i*B+1;
            int c = (i+1)*B;
            A = reverseBetween(A,b,c);
            System.out.println("b: "+b+" c:"+c);
            Utils.printLL(A);
        }
        return A;
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
