package dsa.utils;

import dsa.scaler.LinkedList.structs.ListNode;
import dsa.scaler.trees.structs.TreeLinkNode;
import dsa.scaler.trees.structs.TreeNode;

import java.util.*;

public class Utils {

   public static <T> void  print(ArrayList<ArrayList<T>> data){
       ArrayList<ArrayList<T>> clonedData = getTwoDimArrListCopy(data);
       for(ArrayList<T> datum : clonedData){
           System.out.println("================================");
           System.out.println(" { ");
           System.out.println(datum);
           System.out.println(" } ");
           System.out.println("================================");
       }
   }

    public static <T> void  print(List<List<T>> data){
        for(List<T> datum : data){
            System.out.println("================================");
            System.out.println(" { ");
            System.out.println(datum);
            System.out.println(" } ");
            System.out.println("================================");
        }
    }

    public static <T> void  printSingleArr(ArrayList<T> data){
       System.out.println(data);
    }

    public static <T> ArrayList<ArrayList<T>> getTwoDimArrListCopy(ArrayList<ArrayList<T>> original){
        ArrayList<ArrayList<T>> copy = new ArrayList<>();

        for (ArrayList<T> arr: original){
            copy.add(new ArrayList<>(arr));
        }

        return copy;
    }

    public static void printIntArr(int[] data){
        System.out.println(Arrays.toString(data));
    }

    public static void printIntArr(int[] data,String message){
       System.out.println(message +" "+Arrays.toString(data));
    }

    public static void printIntArr(int[][] data,String message){
       System.out.println(message);
       for(int[] datum : data){
        System.out.println(Arrays.toString(datum));
       }
    }

    public static void printLL(ListNode A){
       ListNode current = A;
       while(current != null){
           System.out.print(current.val+" => ");
           current = current.next;
       }
        System.out.println("null");
    }

    public static ListNode populateLL(int[] testData){
        ListNode A = new ListNode(testData[0]);
        ListNode current = A;
        for(int i=1;i<testData.length;i++){
            current.next = new ListNode(testData[i]);
            current = current.next;
        }
        return A;
    }

    public static TreeLinkNode generateBinaryTree(ArrayList<Integer> A) {
        if(A.size() == 0){
            return null;
        }

        int nextPointer = 0;
        Queue<TreeLinkNode> nodeQueue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(A.get(0));
        nodeQueue.add(root);


        while(nextPointer < A.size() && !nodeQueue.isEmpty()){
            TreeLinkNode current = nodeQueue.remove();
            if(current == null){
                continue;
            }
            nextPointer++;
            TreeLinkNode leftNode = nextPointer < A.size() && A.get(nextPointer) != -1 ?  new TreeLinkNode(A.get(nextPointer)) : null;
            nextPointer++;
            TreeLinkNode rightNode = nextPointer < A.size() && A.get(nextPointer) != -1 ?  new TreeLinkNode(A.get(nextPointer)) : null;
            current.left = leftNode;
            current.right = rightNode;
            nodeQueue.add(leftNode);
            nodeQueue.add(rightNode);
        }
        return root;
    }

    @SafeVarargs
    public static <T> ArrayList<T> generateList(T...args){
       return new ArrayList<>(List.of(args));
    }
}
