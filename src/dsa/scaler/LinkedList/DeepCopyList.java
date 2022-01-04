package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.RandomListNode;

import java.util.Random;

public class DeepCopyList {
    public static void main(String[] args) {
        int[] testData = {1,2,3,4,5,6};
        RandomListNode rln = new RandomListNode(testData[0]);
        RandomListNode current = rln;
        for(int i=1;i<testData.length;i++){
            current.next = new RandomListNode(testData[i]);
            current = current.next;
        }
        current = rln;
        Random random = new Random();
        for(int i=0;i<testData.length;i++){
            int randomIndex = random.nextInt(testData.length);
            current.random = getRandomNode(randomIndex,rln);
            current = current.next;
        }
        RandomListNode.print(rln);
        DeepCopyList dcl = new DeepCopyList();
        RandomListNode.print(dcl.copyRandomList(rln));
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        head = injectDupNodes(head);
        head = assignRandomNodes(head);
        return separateNodes(head);
    }

    private RandomListNode separateNodes(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode originalNode = head;
        RandomListNode newNode = head.next;
        RandomListNode newNodeHead = head.next;
        while( newNode != null && newNode.next != null){
            originalNode.next = newNode.next;
            originalNode = originalNode.next;
            newNode.next = originalNode.next;
            newNode = newNode.next;
        }
        return newNodeHead;
    }

    public RandomListNode assignRandomNodes(RandomListNode head){
        if(head == null){
            return null;
        }

        RandomListNode current = head;
        while(current.next.next != null){
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }
        current.next.random = current.random != null ? current.random.next : null;
        return head;
    }

    public RandomListNode injectDupNodes(RandomListNode head){
        RandomListNode current = head;
        while(current != null){
            RandomListNode newNode = new RandomListNode(current.label);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        return head;
    }

    public static RandomListNode getRandomNode(int position,RandomListNode node){
        RandomListNode current = node;
        int i=0;
        while(current!=null && i < position){
            current = current.next;
            i++;
        }
        return current;
    }
}
