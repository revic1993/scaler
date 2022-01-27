package dsa.scaler.trie;

import java.util.ArrayList;
import java.util.List;

public class MaxXORSubarray {
    public static void main(String[] args) {
        MaxXORSubarray mxs = new MaxXORSubarray();
        System.out.println(mxs.solve(new ArrayList<>(List.of(28, 31, 13, 22, 17, 22))));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int maxXor = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        int maxVal = Integer.MIN_VALUE;
        System.out.println(A.size());
        for(int a :A){
            maxVal = Math.max(a,maxVal);
        }
        if(maxVal == 0){
            result.set(0,A.size());
            result.set(0,A.size()-1);
            return result;
        }
        int counter = 31;
        int num = 1 << counter;

        while((num & maxVal) != num){
            counter--;
            num = 1 << counter;
        }
        Trie trieTree = new Trie();
        trieTree.maxLevel = counter;
        int p = 0;
        trieTree.addChild(0,0);
        for(int i=0;i<A.size();i++){
            int a = A.get(i);
            p = p^a;
            TrieNode maxNumNode = trieTree.getMaxXorNum(p);
            int currentMax = maxNumNode.num ^ p;
            if(maxXor <= currentMax){
                if(maxXor == currentMax){
                    int resSubArrLen = result.get(0) == -1 ? Integer.MAX_VALUE  : result.get(1) - result.get(0);
                    int currentSubArrLen = i-maxNumNode.data;
                    if(resSubArrLen > currentSubArrLen){
                        result.set(0,maxNumNode.data+1);
                        result.set(1,i+1);
                    }else if(resSubArrLen == currentSubArrLen && maxNumNode.data < result.get(0)){
                        result.set(0,maxNumNode.data+1);
                        result.set(1,i+1);
                    }
                }else{
                    result.set(0,maxNumNode.data+1);
                    result.set(1,i+1);
                }

                maxXor = currentMax;
            }
            trieTree.addChild(p,i+1);
        }
        return result;
    }

    public static class Trie{
        TrieNode root = new TrieNode();
        int maxLevel = 31;
        void addChild(int num,int data){
            TrieNode current = root;
            int compare = 1 << maxLevel;
            while(compare != 0){
                boolean isLeft = (compare & num) == 0;
                if(isLeft){
                    if(current.left == null){
                        current.left = new TrieNode();
                    }
                    current = current.left;

                }else{
                    if(current.right == null){
                        current.right = new TrieNode();
                    }

                    current = current.right;
                }
                compare = compare >> 1;
            }
            current.data = data;
            current.num = num;
        }

        TrieNode getMaxXorNum(int a){
            if(root.left == null && root.right == null){
                return null;
            }
            TrieNode current = root;
            int compare = 1 << maxLevel;
            while(compare != 0){
                if(current == null){
                    return null;
                }
                int bitRequired = ((compare & a) == 0) ? 1 : 0;
                if(bitRequired == 0 && current.left != null){
                    current = current.left;
                }else if(bitRequired == 1 && current.right != null){
                    current = current.right;
                }else{
                    current = current.left == null ? current.right : current.left;
                }
                compare = compare >> 1;
            }
            return current;
        }
    }

    static class TrieNode{
        TrieNode left;//0
        TrieNode right;//1
        int data;
        int num;
    }
}
