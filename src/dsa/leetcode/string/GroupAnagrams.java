package dsa.leetcode.string;
/*
*
* https://leetcode.com/problems/group-anagrams/
*/

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class GroupAnagrams {
    public static void main(String[] args) {
            String[] testData = new String[]{"abbbbbbbbbbb","aaaaaaaaaaab"};
        GroupAnagrams ga = new GroupAnagrams();
        Utils.print(ga.groupAnagrams(testData));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagramMap = new HashMap<>();
        for(String str : strs){
            int[] charMap = new int[26];
            for(char c : str.toCharArray()){
                charMap[c-'a']++;
            }
            String key = getKey(charMap);
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key,new ArrayList<>());
            }
            anagramMap.get(key).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }

    public String getKey(int[] charMap){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charMap.length;i++){
            sb.append((char)('a'+i)).append(charMap[i]);
        }
        return sb.toString();
    }
}
