package dsa.scaler.trie;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ContactFinder {
    public static void main(String[] args) {
        ContactFinder cf = new ContactFinder();
        Utils.printSingleArr(cf.solve(new ArrayList<>(List.of(0,0,1,1)),new ArrayList<>(List.of("hack","hacker","hac","hak"))));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Trie trieTree = new Trie();
        for(int i=0;i<A.size();i++){
            switch (A.get(i)){
                case 0 :    trieTree.addString(B.get(i));
                            break;
                case 1 :    result.add(trieTree.findContacts(B.get(i)));
                            break;
            }
        }
        return result;
    }

    static class Trie{
        TrieNode root = new TrieNode();
        public void addString(String data){
            TrieNode current = root;
            for(char c : data.toCharArray()){
                int index = c - 'a';
                if(current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current.children[index].wordCount++;
                current = current.children[index];
            }
            current.isWord = true;
        }

        public int findContacts(String prefix){
            TrieNode current = root;
            for(char c : prefix.toCharArray()){
                int index = c - 'a';
                if(current.children[index] == null){
                    return 0;
                }
                current = current.children[index];
            }
            return current.wordCount;
        }
    }

    static class TrieNode{
        int wordCount;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}
