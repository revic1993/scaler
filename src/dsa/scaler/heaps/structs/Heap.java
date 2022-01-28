package dsa.scaler.heaps.structs;

import java.util.ArrayList;

public class Heap {

        public static void buildHeap(ArrayList<Integer> A){
            int leafNodeStart = (A.size()+1) >> 1;
            for(int i = leafNodeStart-1;i>=0;i--){
                int current = i;
                while(current < leafNodeStart){
                    int[] leftRight = getChildren(A,current);
                    if(A.get(current) <= leftRight[2] && A.get(current) <= leftRight[3]){
                        break;
                    }
                    int temp = A.get(current);
                    if(leftRight[2] < A.get(current) && leftRight[2] < leftRight[3]){
                        A.set(current,leftRight[2]);
                        A.set(leftRight[0],temp);
                        current = leftRight[0];
                    }else{
                        A.set(current,leftRight[3]);
                        A.set(leftRight[1],temp);
                        current = leftRight[1];
                    }
                }
            }
        }

        public static int getMin(ArrayList<Integer> A){
            if(A.size() == 0){
                return Integer.MAX_VALUE;
            }
            int min = A.get(0);
            A.set(0,A.get(A.size()-1));
            A.remove(A.size()-1);

            int current = 0;
            while(current < A.size()){
                int[] leftRight = getChildren(A,current);
                if(A.get(current) <= leftRight[2] && A.get(current) <= leftRight[3]){
                    break;
                }
                int temp = A.get(current);
                if(leftRight[2] < A.get(current) && leftRight[2] < leftRight[3]){
                    A.set(current,leftRight[2]);
                    A.set(leftRight[0],temp);
                    current = leftRight[0];
                }else{
                    A.set(current,leftRight[3]);
                    A.set(leftRight[1],temp);
                    current = leftRight[1];
                }
            }
            return min;
        }

        public static void addToHeap(ArrayList<Integer> A,int a){
            A.add(a);
            int current = (A.size()-1) >> 1;
            while(current >= 0 && current < A.size()){
                int[] leftRight = getChildren(A,current);
                if(A.get(current) <= leftRight[2] && A.get(current) <= leftRight[3]){
                    break;
                }
                int temp = A.get(current);
                if(leftRight[2] < A.get(current) && leftRight[2] < leftRight[3]){
                    A.set(current,leftRight[2]);
                    A.set(leftRight[0],temp);
                }else{
                    A.set(current,leftRight[3]);
                    A.set(leftRight[1],temp);
                }
                current = (current-1)>>1;
            }
        }



        public static int[] getChildren(ArrayList<Integer> A,int parent){
            int[] leftRight = new int[4];
            leftRight[0] = 2*parent+1;
            leftRight[1] = leftRight[0]+1;

            leftRight[2] = leftRight[0] < A.size() ? A.get(leftRight[0]) : Integer.MAX_VALUE;
            leftRight[3] = leftRight[1] < A.size() ? A.get(leftRight[1]) : Integer.MAX_VALUE;
            return leftRight;
        }
}
