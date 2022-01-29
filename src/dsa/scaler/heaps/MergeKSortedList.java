package dsa.scaler.heaps;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        ArrayList<ListNode> data = new ArrayList<>();
        data.add(Utils.populateLL(new int[]{10,12}));
        data.add(Utils.populateLL(new int[]{13}));
        data.add(Utils.populateLL(new int[]{5,6}));
        MergeKSortedList mksl = new MergeKSortedList();
        Utils.printLL(mksl.mergeKLists(data));
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.totalLen));

        for(ListNode l : a){
            HeapNode hp = new HeapNode(l);
            minHeap.add(hp);
        }

        while(minHeap.size() > 1){
            HeapNode firstMin = minHeap.remove();
            HeapNode secondMin = minHeap.remove();
            minHeap.add(mergeLL(firstMin,secondMin));
        }
        return minHeap.remove().lNode;
    }

    HeapNode mergeLL(HeapNode A,HeapNode B){
        ListNode merged = new ListNode(0);
        ListNode aNode = A.lNode;
        ListNode bNode = B.lNode;
        ListNode current = merged;
        while(aNode != null && bNode != null){
            if(aNode.val <= bNode.val){
                ListNode next = aNode.next;
                aNode.next = null;
                current.next = aNode;
                current = current.next;
                aNode = next;
            }else{
                ListNode next = bNode.next;
                bNode.next = null;
                current.next = bNode;
                current = current.next;
                bNode = next;
            }
        }
        if(aNode != null){
            current.next = aNode;
        }

        if(bNode != null){
            current.next = bNode;
        }

        merged = merged.next;
        return new HeapNode(merged,A.totalLen+B.totalLen);
    }

    static class HeapNode{
        ListNode lNode;
        int totalLen=0;
        public HeapNode(ListNode lNode){
            this.lNode = lNode;
            ListNode current = lNode;
            while(current!=null){
                current = current.next;
                totalLen++;
            }
        }

        public HeapNode(ListNode lNode,int totalLen){
            this.lNode = lNode;
            this.totalLen = totalLen;
        }
    }
}
