package dsa.scaler.trie;

import dsa.utils.Utils;

import java.util.Arrays;

public class SpellChecker {
    public static void main(String[] args) {
        SpellChecker sc = new SpellChecker();
        Utils.printIntArr(sc.solve(new String[]{"hat", "cat", "rat"}, new String[]{"cat", "ball"}));
    }
    public int[] solve(String[] A, String[] B) {
        int[] result = new int[B.length];
        Trie trieTree = new Trie();
        for(String a : A){
            trieTree.addString(a);
        }
        int i=0;
        for(String b : B){
            result[i++] = trieTree.check(b) ? 1 : 0;
        }
        return result;
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
                current = current.children[index];
            }
            current.isWord = true;
        }

        public boolean check(String val){
            TrieNode current = root;
            for(char c : val.toCharArray()){
                int index = c-'a';
                if(current.children[index] == null){
                    return false;
                }
                current = current.children[index];
            }
            return current.isWord;
        }
    }

    static class TrieNode{
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
           for(int i=0;i<26;i++){
               if(children[i] == null){
                   continue;
               }
               sb.append((char)(i+'a')).append(" | ");
           }
           if(sb.length() == 1){
               sb.append("null").append(" |");
           }
           return "{ isWord "+isWord+", children : "+sb.toString()+" }";
        }
    }
}
