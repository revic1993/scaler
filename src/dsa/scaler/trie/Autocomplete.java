package dsa.scaler.trie;

import javax.swing.text.Style;
import java.util.*;
import java.util.stream.Collectors;

public class Autocomplete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        /*
        *   6 3
            abcd aecd abaa abef acdcc acbcc
            2 1 3 4 6 5
            ab abc a
        * */

        for(int i=0;i<testCases;i++){
            sc.nextLine();
            String[] dataSet = sc.nextLine().split(" ");
            String[] weightArr = sc.nextLine().split(" ");
            HashMap<String,Integer> dataWeight = new HashMap<>();
            for(int k=0;k<dataSet.length;k++){
                dataWeight.put(dataSet[k],Integer.parseInt(weightArr[k]));
            }
            String[] querySet = sc.nextLine().split(" ");
            printSuggestions(dataWeight,querySet);
        }
    }

    static void printSuggestions(HashMap<String,Integer> dataWeight, String[] querySet){
        Trie trieTree = new Trie();
        for(String data : dataWeight.keySet()){
            trieTree.addString(data);
        }
        for(String query : querySet){
            ArrayList<String> suggestions = trieTree.getSuggestions(query);
            if(suggestions.size() == 0){
                System.out.println("-1 ");
                continue;
            }

            suggestions.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return dataWeight.get(o1) - dataWeight.get(o2);
                }
            });
            System.out.println(String.join(" ",suggestions)+" ");
        }
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

        public ArrayList<String> getSuggestions(String query){
            TrieNode prefix = check(query);
            ArrayList<String> result = new ArrayList<>();
            if(prefix == null || prefix.isWord){
                return result;
            }
            for(int i =0;i<26;i++){
                if(prefix.children[i+'a'] == null){
                    continue;
                }
                ArrayList<String> combinations = getCombinations(prefix, (char) ('a'+i));
            }
            return result;
        }

        private ArrayList<String> getCombinations(TrieNode prefix,char current) {
            ArrayList<String> result = new ArrayList<>();
            for(int i=0;i<26;i++){
                if(prefix.children[i+'a'] == null){
                    continue;
                }
                ArrayList<String> combinations = getCombinations(prefix.children[i+'a'], (char) ('a'+i));
                for(String com : combinations){
                    result.add(current+com);
                }
            }
            if(result.size() == 0 || prefix.isWord){
                result.add(current+"");
            }
            return result;
        }

        public TrieNode check(String val){
            TrieNode current = root;
            for(char c : val.toCharArray()){
                int index = c-'a';
                if(current.children[index] == null){
                    return null;
                }
                current = current.children[index];
            }
            return current;
        }

    }
    static class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}
