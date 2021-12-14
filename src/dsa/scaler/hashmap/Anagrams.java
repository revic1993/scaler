package dsa.scaler.hashmap;

import dsa.utils.JSONConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        Anagrams anagram = new Anagrams();
//        JSONConverter.print(anagram.anagrams(List.of( "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb")));
        JSONConverter.print(anagram.anagrams(List.of("cde", "bee")));
    }
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String,ArrayList<Integer>> anagramMap = new HashMap<>();
        int i=0;
        for(String a : A){
            String key = getSortedString(a);
            if(!anagramMap.containsKey(key)){
                ArrayList<Integer> first = new ArrayList<>();
                first.add(++i);
                anagramMap.put(key,first);
                continue;
            }
            anagramMap.get(key).add(++i);
        }

        return new ArrayList<>(anagramMap.values());
    }

    String getSortedString(String value){
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(char c : value.toCharArray()){
            if(!freqMap.containsKey(c)){
                freqMap.put(c,1);
                continue;
            }
            freqMap.put(c,freqMap.get(c)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i='a';i<='z';i++){
            if(!freqMap.containsKey((char)i)){
                continue;
            }
            for(int j =0;j<freqMap.get((char)i);j++){
                sb.append((char)i);
            }
        }

        return sb.toString();
    }
}
