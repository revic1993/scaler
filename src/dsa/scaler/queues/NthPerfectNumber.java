package dsa.scaler.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class NthPerfectNumber {
    public static void main(String[] args) {
        NthPerfectNumber npn = new NthPerfectNumber();
        System.out.println(npn.solve(13));
    }

    public String solve(int A) {
        Deque<String> deque = new LinkedList<>();
        if(A == 1){
            return "11";
        }else if(A == 2){
            return "22";
        }

        deque.addFirst("2");
        deque.addFirst("1");
        int total = 2;
        while(total < A){
            String current = deque.removeFirst();
            StringBuilder sb = new StringBuilder();
            sb.append(current);
            sb.append("1");
            deque.addLast(sb.toString());
            sb.replace(sb.length()-1,sb.length(),"2");
            deque.addLast(sb.toString());
            total+=2;
        }

        if((A&1)!=0){
            deque.removeLast();
        }

        StringBuilder result = new StringBuilder(deque.getLast());
        StringBuilder reverse = new StringBuilder(result.toString());
        result.append(reverse.reverse());
        return result.toString();
    }
}
