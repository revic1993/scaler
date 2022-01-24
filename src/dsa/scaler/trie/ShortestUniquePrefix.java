package dsa.scaler.trie;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        ShortestUniquePrefix sup = new ShortestUniquePrefix();
        System.out.println(Arrays.toString(sup.prefix(new String[]{"apple", "ball", "cat"})));
    }
    public String[] prefix(String[] A) {
        String[] prefixArr = new String[A.length];
        Trie trieTree = new Trie();
        for(String a : A){
            trieTree.addString(a);
        }
        int i=0;
        for(String a : A){
            prefixArr[i++] = trieTree.getUniquePrefix(a);
        }
        return prefixArr;
    }

    static class Trie{
        TrieNode root = new TrieNode();
        public void addString(String val){
           TrieNode current = root;
            for(char c : val.toCharArray()){
                int index = c-'a';
                if(current.children[index] != null){
                    current = current.children[index];
                    continue;
                }
                current.children[index] = new TrieNode();
                current.childCount++;
                current = current.children[index];
            }
        }

        public String getUniquePrefix(String val){
            TrieNode current = root; //dog duck dove
            Deque<TrieNode> charDQueue = new LinkedList<>();
            for(char c : val.toCharArray()){
                int index = c - 'a';
                charDQueue.addLast(current.children[index]);
                current = current.children[index];
            }
            while(!charDQueue.isEmpty() && charDQueue.peekLast().childCount <= 1){
                charDQueue.removeLast();
            }
            int size = charDQueue.size()+1;
            return size > val.length() ? val : val.substring(0,size);
        }

    }

    static class QueueNode{
        char c;
        int childCount;
         QueueNode(char c, int childCount){
             this.c = c;
             this.childCount = childCount;
         }

        @Override
        public String toString() {
            return "{" +
                    "val=" + c +
                    ", childCount=" + childCount +
                    '}';
        }
    }

    static class TrieNode{
        int childCount = 0;
        TrieNode[] children = new TrieNode[26];
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("| ");
            for(int i=0;i<26;i++){
                if(children[i] == null){
                    continue;
                }
                sb.append((char)(i+'a')).append(" | ");
            }
            if(sb.length() == 1){
                sb.append(" null").append("|");
            }
            return "{ childCount "+childCount+", children : "+sb.toString()+" }";
        }
    }
}
