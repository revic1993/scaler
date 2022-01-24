package dsa.scaler.trie;

import java.util.*;

public class ModifiedSearch {
    public static void main(String[] args) {
        ModifiedSearch ms = new ModifiedSearch();
        System.out.println(ms.solve(new ArrayList<>(List.of("date","circle","cricket")),new ArrayList<>(List.of("data","date","dircle","circl"))));
    }
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        StringBuilder result = new StringBuilder();
        Trie trieTree = new Trie();
        for(String a: A){
            trieTree.addString(a);
        }

        for(String b : B){
            if(trieTree.search(b,0,0, trieTree.root)){
                result.append("1");
            }else{
                result.append("0");
            }
        }

        return result.toString();
    }

    static class Trie{
        TrieNode root = new TrieNode();
        public void addString(String data){
            TrieNode current = root;
            for(int i=0;i<data.length();i++){
                int index = data.charAt(i)-'a';
                current.addChildren(data.charAt(i));
                current = current.children[index];
            }
            current.isWord = true;
        }

        public boolean search(String val,int nextMatchAt,int chancesUsed,TrieNode current){
            if(chancesUsed > 1){
                return false;
            }

            if(val.length() == nextMatchAt){
                return chancesUsed==1 && current!=null && current.isWord;
            }

            int nextLen = val.length()-nextMatchAt;
            for(int i=0;i<26;i++){
                if(current.children[i] == null){
                    continue;
                }
                int currentChar = i+'a';
                if(search(val,nextMatchAt+1,currentChar == val.charAt(nextMatchAt) ? chancesUsed : chancesUsed+1,current.children[i])){
                    return true;
                }
            }
            return false;
        }

    }

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
        public void addChildren(char c){
            if(children[c-'a'] == null){
                children[c-'a'] = new TrieNode();
            }
        }

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
            return "{children : "+sb.toString()+ ", isWord: "+isWord +" }";
        }
    }
}
