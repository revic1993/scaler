package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.ArrayList;

public class AddTwoNumbersAsList {
    public static void main(String[] args) {
        ListNode A = Utils.populateLL(new int[]{9,9});
        ListNode B = Utils.populateLL(new int[]{1});
        AddTwoNumbersAsList atal = new AddTwoNumbersAsList();
        Utils.printLL(atal.addTwoNumbers(A,B));
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
            ListNode currentA = A;
            ListNode currentB = B;
            ListNode result = null;
            ListNode resTail = null;

            int carry = 0;

            while(currentA != null || currentB!=null){
                int a = currentA == null ? 0 : currentA.val;
                int b = currentB == null ? 0 : currentB.val;
                int total = a+b+carry;
                carry = total/10;
                int num = total%10;
                if(result == null){
                    result = insertAtEnd(resTail,num);
                    resTail = result;
                }else{
                    resTail = insertAtEnd(resTail,num);
                }
                if(currentA!=null){
                    currentA = currentA.next;
                }
                if(currentB!=null){
                    currentB = currentB.next;
                }
            }
            if(carry != 0){
                resTail = insertAtEnd(resTail,carry);
            }
            return result;
    }

    ListNode insertAtEnd(ListNode tail,int num){
        if(tail == null){
            return new ListNode(num);
        }
        tail.next = new ListNode(num);
        tail = tail.next;
        return tail;
    }
}
