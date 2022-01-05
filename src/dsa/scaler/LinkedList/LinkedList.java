package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class LinkedList {
    static ListNode head;

    public static void main(String[] args) {
       int[] insertArr = {1,2,3,4,5,6,7};
       for(int i=1;i<=insertArr.length;i++){
           insert_node(i,insertArr[i-1]);
       }
       print_ll();
       delete_node(3);
       print_ll();
       delete_node(6);
       print_ll();
       delete_node(1);
       print_ll();
       insert_node(1,15);
       print_ll();
       insert_node(6,20);
        print_ll();
//       delete_node(25);
//       print_ll();
//       delete_node(53);
//       print_ll();
//       delete_node(12);
//       delete_node(53);
//        print_ll();
//        print_ll();
//        print_ll();
//        print_ll();
//        print_ll();
//        delete_node(39);
//        delete_node(42);
//        print_ll();
//        delete_node(47);
//        delete_node(45);
//        delete_node(35);
//        print_ll();
//        delete_node(13);
//        print_ll();
//        delete_node(18);
//        delete_node(59);
//        delete_node(47);
//        delete_node(43);
//        delete_node(38);
//        print_ll();
//        print_ll();
//        print_ll();
//        print_ll();
//        print_ll();
//        print_ll();
//        delete_node(8);
//        print_ll();
//        delete_node(8);
//        print_ll();
//        delete_node(39);
//        delete_node(60);
//        delete_node(16);
//        print_ll();
//        print_ll();
    }
    public static void insert_node(int position, int value) {
        if(head == null){
            head = new ListNode(value);
            return;
        }

        if(position == 1){
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head;
        for(int i=1;i<position-1;i++){
            if(current == null){
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    public static void delete_node(int position) {
        if(head == null){
            return;
        }

        if(position == 1){
            head = head.next;
            return;
        }

        ListNode current = head;
        ListNode prev = null;
        for(int i=1;i<position;i++){
            if(current.next == null){
                return;
            }
            prev = current;
            current = current.next;
        }

        if(prev != null){
            prev.next = current.next;
        }
    }

    public static void print_ll() {
        ListNode current = head;
        System.out.println();
        while(current != null){
            System.out.print(""+current.val+" ");
            current = current.next;
        }
    }

}
