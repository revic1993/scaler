package dsa.scaler.trees.LCA;

import dsa.scaler.trees.structs.TreeNode;

import java.util.*;

public class CommonNodesInBST {
    public static void main(String[] args) {

    }

    public int solve(TreeNode A, TreeNode B) {
        FreqMap<Integer> commonNodes = new FreqMap<>();
        int sum = 0;
        int mod = (int) (Math.pow(10,9)+7);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(A);
        while(!nodeQueue.isEmpty()){
            TreeNode currentNode = nodeQueue.remove();
            commonNodes.add(currentNode.val);
            if(currentNode.left != null) nodeQueue.add(currentNode.left);
            if(currentNode.right != null) nodeQueue.add(currentNode.right);
        }

        nodeQueue.add(B);
        while (!nodeQueue.isEmpty()){
            TreeNode currentNode = nodeQueue.remove();
            if(commonNodes.containsKey(currentNode.val)){
                sum = ( sum % mod + currentNode.val % mod) % mod;
                commonNodes.remove(currentNode.val,0);
            }

            if(currentNode.left != null) nodeQueue.add(currentNode.left);
            if(currentNode.right != null) nodeQueue.add(currentNode.right);
        }
        return sum;
    }

    class FreqMap<T>{
        HashMap<T,Integer> freqMap;

        public FreqMap(){
            this.freqMap = new HashMap<>();
        }

        public HashMap<T,Integer> getMap(){
            return this.freqMap;
        }

        public void addAll(List<T> A){
            for(T a : A){
                this.add(a);
            }
        }

        public void add(T key){
            if(freqMap.containsKey(key)){
                freqMap.put(key,freqMap.get(key)+1);
                return;
            }
            freqMap.put(key,1);
        }

        public void remove(T key,int deleteVal){
            if(!freqMap.containsKey(key)){
                return;
            }

            if(freqMap.get(key)-1 == deleteVal){
                freqMap.remove(key);
                return;
            }
            freqMap.put(key, freqMap.get(key)-1);
        }

        public int getFreq(T key){
            if(!freqMap.containsKey(key)){
                return -1;
            }
            return freqMap.get(key);
        }

        public boolean containsKey(T key){
            return freqMap.containsKey(key);
        }

        public void remove(T key){
            if(!freqMap.containsKey(key)){
                return;
            }

            freqMap.put(key, freqMap.get(key)-1);
        }

    }
}
