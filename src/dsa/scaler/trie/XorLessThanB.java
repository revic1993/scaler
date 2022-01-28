package dsa.scaler.trie;

import java.util.ArrayList;
import java.util.List;

public class XorLessThanB {
    public static void main(String[] args) {
        XorLessThanB xltb = new XorLessThanB();
        System.out.println(xltb.solve(new ArrayList<>(List.of(9, 4, 3, 11)),7));
    }

    static int mod = (int)(Math.pow(10,9)+7);
    public int solve(ArrayList<Integer> A,int B) {
        int xorCount = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int a :A){
            maxVal = Math.max(a,maxVal);
        }
        if(maxVal == 0){
            return 0;
        }
        int counter = 31;
        int num = 1 << counter;

        while((num & maxVal) != num){
            counter--;
            num = 1 << counter;
        }
        Trie trieTree = new Trie();
        trieTree.maxLevel = counter;
        int maxNum = B-1;
        int prefixXor = 0;
        for(int a : A){
            prefixXor = prefixXor^a;
            int addCurrent = prefixXor < B ? 1 : 0;
            int totalPossibilities = trieTree.totalPossibilities(prefixXor,maxNum);
            xorCount = (xorCount%mod+totalPossibilities%mod+addCurrent)%mod;

            trieTree.addChild(prefixXor);
        }
        return xorCount;
    }


    static class Trie{
        TrieNode root = new TrieNode();
        int maxLevel = 31;
        void addChild(int num){
            TrieNode current = root;
            int compare = 1 << maxLevel;
            while(compare != 0){
                boolean isLeft = (compare & num) == 0;
                if(isLeft){
                    if(current.left == null){
                        current.left = new TrieNode();
                    }
                    current = current.left;
                    current.totalChild++;

                }else{
                    if(current.right == null){
                        current.right = new TrieNode();
                    }
                    current = current.right;
                    current.totalChild++;
                }
                compare = compare >> 1;
            }
            current.isNum = true;
        }
        int totalPossibilities(int a,int maxNum){
            if(root.left == null && root.right == null){
                return a <= maxNum+1 ? 1 : 0;
            }
            int currentTotal = 0;
            int currentLevel = maxLevel;
            TrieNode current = root;
            while(current!= null){
                int levelNum=(1 << currentLevel);
                boolean isNextZero = ( levelNum & maxNum) == 0;
                boolean isCurrentZero = (levelNum & a) == 0;
                currentLevel--;
                if(current.isNum){
                    currentTotal =  (currentTotal%mod + current.totalChild%mod)%mod;
                    current = null;
                    continue;
                }
                if(isNextZero && isCurrentZero){
                    //move left
                    current = current.left;
                }else if(isNextZero){
                    current = current.right;
                }else if(isCurrentZero){
                    //move right and add left children
                    int leftChild = current.left!= null ? current.left.totalChild : 0;
                    current = current.right;
                    currentTotal = (currentTotal%mod + leftChild%mod)%mod;
                }else{
                    int rightChild = current.right!= null ? current.right.totalChild : 0;
                    current = current.left;
                    currentTotal = (currentTotal%mod + rightChild%mod)%mod;
                }
            }
            return currentTotal;
        }
    }

    static class TrieNode{
        TrieNode left;//0
        TrieNode right;//1
        boolean isNum;
        int totalChild = 0;

        @Override
        public String toString() {
            return "{" +
                    "left:" + (left == null ? "null" : "present") +
                    ", right:" + (right == null ? "null" : "present") +
                    ", isNum:" + isNum +
                    ", totalChild:" + totalChild +
                    '}';
        }
    }
}