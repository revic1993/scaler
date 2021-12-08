package dsa.scaler.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new ArrayList<>(List.of(2,1))));
    }

    public int longestConsecutive(final List<Integer> A) {
        int longestSequence = Integer.MIN_VALUE;
        HashSet<Integer> numSet = new HashSet<>(A);
        int size = numSet.size();
        while(size>0){
            int currentSequence = 1;
            Iterator<Integer> numIterator = numSet.iterator();
            int currentNum = numIterator.next();
            numIterator.remove();
            size--;
            int nextNum = currentNum+1;
            while(size> 0 && numSet.contains(nextNum)){
                numSet.remove(nextNum);
                size--;
                nextNum++;
                currentSequence++;
            }
            int previousNum = currentNum-1;
            while(size> 0 && numSet.contains(previousNum)){
                numSet.remove(previousNum);
                size--;
                previousNum--;
                currentSequence++;
            }
            longestSequence = Math.max(currentSequence,longestSequence);
        }
        return longestSequence;
    }
}
