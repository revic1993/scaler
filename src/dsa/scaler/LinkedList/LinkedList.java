package dsa.scaler.LinkedList;

public class LinkedList {
    static Node head;

    public static void main(String[] args) {
        insert_node(1,24);
        insert_node(2,23);
        insert_node(3,22);
        insert_node(4,21);
        insert_node(5,20);
        print_ll();
        System.out.println();
        delete_node(3);
        System.out.println("After deleting index at 3");
        print_ll();
        delete_node(1);
        System.out.println("After deleting index at 1");
        print_ll();
        delete_node(3);
        System.out.println("After deleting index at 3");
        print_ll();
        insert_node(3,24);
        System.out.println("After inserting index at 3");
        print_ll();
    }
    public static void insert_node(int position, int value) {
        if(head == null && position != 1){
            return;
        }

        if(head == null){
            head = new Node(value);
            return;
        }
        Node current = head;
        for(int i=1;i<position-1;i++){
            if(current == null){
                return;
            }
            current = current.next;
        }
        current.next = new Node(value);
    }

    public static void delete_node(int position) {
        if(head == null){
            return;
        }

        if(position == 1 && head.next == null ){
            return;
        }

        if(position == 1){
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
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
        Node current = head;
        while(current != null){
            System.out.print(""+current.data+" ");
            current = current.next;
        }
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}
