package dsa.scaler.heaps;

import dsa.scaler.heaps.structs.Heap;
import dsa.utils.Utils;

import java.util.*;


public class NMaxPairCombinations {
    public static void main(String[] args) {
        NMaxPairCombinations nmpc = new NMaxPairCombinations();
//        Utils.printSingleArr(nmpc.solve(new ArrayList<>(List.of(3,4)),
//                                        new ArrayList<>(List.of(3,4))));
        Utils.printSingleArr(nmpc.solve(new ArrayList<>(List.of(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28)),
                                        new ArrayList<>(List.of(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43))));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.num-o1.num);

        ArrayList<Integer> result = new ArrayList<>();
        A.sort(Comparator.comparingInt(Integer::intValue));
        B.sort(Comparator.comparingInt(Integer::intValue));
        HashSet<String> usedPairSet = new HashSet<>();

        maxHeap.add(new HeapNode(A.size()-1,A.size()-1,A.get(A.size()-1)+B.get(B.size()-1)));
        while(result.size() < A.size()){
            HeapNode currentNode = maxHeap.remove();
            if(!usedPairSet.contains(point(currentNode.getPoint()))){
                usedPairSet.add(point(currentNode.getPoint()));
                result.add(currentNode.num);
            }

            if(result.size() == A.size()){
                break;
            }
            int[] firstPair = new int[]{currentNode.i-1,currentNode.j};
            int[] secondPair = new int[]{currentNode.i,currentNode.j-1};

            if(firstPair[0] >=0 && !usedPairSet.contains(point(firstPair))){
                maxHeap.add(new HeapNode(firstPair,A.get(firstPair[0])+B.get(firstPair[1])));
            }
            if(secondPair[1] >=0 && !usedPairSet.contains(point(secondPair))){
                maxHeap.add(new HeapNode(secondPair,A.get(secondPair[0])+B.get(secondPair[1])));
            }
        }
        return result;
    }
    static String point(int[] pair){
        return "("+pair[0]+","+pair[1]+")";
    }




    static class HeapNode{
        int i;
        int j;
        int num;
        HeapNode(int i,int j,int num){
            this.i = i;
            this.j = j;
            this.num = num;
        }

        HeapNode(int[] pair,int num){
            this.i = pair[0];
            this.j = pair[1];
            this.num = num;
        }

        int[] getPoint(){
            return new int[]{this.i,this.j};
        }


        @Override
        public String toString() {
            return "{" +
                    "i:" + i +
                    ", j:" + j +
                    ", num:" + num +
                    '}';
        }
    }
}
/*
  int num;
        PriorityQueue<Integer> maxHeap;
        HeapNode(int num, PriorityQueue<Integer> maxHeap){
            this.num = num;
            this.maxHeap = new PriorityQueue<>(maxHeap);
        }

        public int getWeight(){
            return this.num + this.maxHeap.peek();
        }

        public boolean isEmpty(){
            return this.maxHeap.isEmpty();
        }

        public int removeWeight(){
            return this.num+this.maxHeap.remove();
        }
firstMaxHeap.addAll(A);
        secondMaxHeap.addAll(A);
        int[] bMax = firstAndSecondMax(B);
        int firstMax = bMax[0];
        int secondMax = bMax[1];
        //if theres no second max
        if(bMax[3] == 0){
            secondMax = firstMax;
            bMax[3] = (bMax[2] >> 1);
            bMax[2] = bMax[2]-bMax[3];
        }


        while(result.size()<A.size()){
            if(firstMaxHeap.isEmpty()){
                addFromHeap(result,secondMax+secondMax+secondMaxHeap.remove(),bMax[3],A.size()-result.size());
                continue;
            }

            if(secondMaxHeap.isEmpty()){
                addFromHeap(result,firstMax+firstMaxHeap.remove(),bMax[2],A.size()-result.size());
                continue;
            }

            if(firstMax + firstMaxHeap.peek() > secondMax + secondMaxHeap.peek()){
                 addFromHeap(result,firstMax+firstMaxHeap.remove(),bMax[2],A.size()-result.size());
            }else{
                 addFromHeap(result,secondMax+secondMaxHeap.remove(),bMax[3],A.size()-result.size());
            }
        }
  public void addFromHeap(ArrayList<Integer> result,int num,int freq,int maxItr){
        if(maxItr <= 0){
            return;
        }
        for(int j=0,i=0;j<Math.min(freq,maxItr);j++,i++){
            result.add(num);
        }

    }
* int[] firstAndSecondMax(ArrayList<Integer> arr){
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int a : arr){
            if(firstMax < a){
                secondMax = firstMax;
                firstMax = a;
            }else if(secondMax < a && firstMax > a){
                secondMax = a;
            }
        }
        int firstMaxFreq=0;
        int secondMaxFreq=0;
        for(int a : arr){
            if(firstMax == a){
                firstMaxFreq++;
            }else if(secondMax==a){
                secondMaxFreq++;
            }

        }

        return new int[]{firstMax,secondMax,firstMaxFreq,secondMaxFreq};
    }
* */