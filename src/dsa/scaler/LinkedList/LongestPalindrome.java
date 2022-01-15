package dsa.scaler.LinkedList;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.utils.Utils;

public class LongestPalindrome {

    public static void main(String[] args) {
        ListNode head = Utils.populateLL(new int[]{6,3,2,2,3,1});
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.solve(head));
    }

    public int solve(ListNode A) {
        int maxLen = 1;
        if(A == null){
            return maxLen;
        }

        // first reverse list for odd length
        ListNode prev = null;
        ListNode current = A;

        while(current!=null){
            ListNode next = current.next;
            int l = getLongestLength(prev,next);
            maxLen = Math.max(2*l+1,maxLen);
            current.next = prev;
            prev = current;
            current = next;
        }
        // restore current to prev head
        current = prev;
        prev = null;
        while(current != null){
            ListNode next = current.next;
            if(next != null && current.val == next.val){
                int l = getLongestLength(prev,next.next);
                maxLen = Math.max(2*l+2,maxLen);
            }
            current.next = prev;
            prev = current;
            current = next;
        }

        return maxLen;
    }

    public int getLongestLength(ListNode first, ListNode second){
        int longestCommon = 0;
        while(first!=null && second!=null && first.val == second.val){
            first = first.next;
            second = second.next;
            longestCommon++;
        }
        return longestCommon;
    }
}
