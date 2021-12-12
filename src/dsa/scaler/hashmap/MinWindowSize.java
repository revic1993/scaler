package dsa.scaler.hashmap;

import java.util.HashMap;

public class MinWindowSize {
    public static void main(String[] args) {

    }

    public int minWindowSize(String A,String B){

        if(A.length() < B.length()){
            return 0;
        }

        if(A.equals(B)){
            return 1;
        }

        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char c: B.toCharArray()){
            if(!freqMap.containsKey(c)){
                freqMap.put(c,0);
            }
            freqMap.put(c,freqMap.get(c)+1);
        }
        int head = 0,tail = 0, total = 0, bLen = B.length(),start = 0;
        while(tail < A.length()){
            char currentChar = A.charAt(tail);
            if(!freqMap.containsKey(currentChar)){
                tail++;
                continue;
            }
            freqMap.put(currentChar,freqMap.get(currentChar)-1);
            if(freqMap.get(currentChar) >=0){
                total++;
            }
            if(total == B.length()){
                while(freqMap.containsKey(A.charAt(head)) || freqMap.get(A.charAt(head)) < 0){
                    if(!freqMap.containsKey(A.charAt(head))){
                        freqMap.put(A.charAt(head),1+freqMap.get(A.charAt(head)));
                    }
                    head++;
                }

                start = head;
            }
            tail++;
        }
        return 0;
    }
}
