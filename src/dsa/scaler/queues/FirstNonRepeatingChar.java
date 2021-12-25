package dsa.scaler.queues;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        FirstNonRepeatingChar fnrc = new FirstNonRepeatingChar();
        System.out.println(fnrc.solve("abcabc"));
    }
    public String solve(String A) {
        HashSet<Character> firstOccurrence = new HashSet<>();
        HashSet<Character> frequentOccurrence = new HashSet<>();
        Deque<Character> characterQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : A.toCharArray()){
            addToHash(firstOccurrence,frequentOccurrence,characterQueue,c);
            sb.append(characterQueue.isEmpty() ? '#' : characterQueue.getFirst());
        }
        return sb.toString();
    }

    public void addToHash(HashSet<Character> firstOccurrence,HashSet<Character> frequentOccurrence,Deque<Character> characterQueue, char c){
        if(!firstOccurrence.contains(c)){
            firstOccurrence.add(c);
            characterQueue.addLast(c);
            return;
        }

        firstOccurrence.remove(c);
        frequentOccurrence.add(c);
        while(!characterQueue.isEmpty() && frequentOccurrence.contains(characterQueue.getFirst())){
            characterQueue.removeFirst();
        }
    }
}
