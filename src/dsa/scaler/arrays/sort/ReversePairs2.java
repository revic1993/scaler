package dsa.scaler.arrays.sort;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs2 {


    int totalInversions;

    public static void main(String[] args) {
        ReversePairs2 rp = new ReversePairs2();
        System.out.println(rp.solve(new ArrayList<>(List.of(1,3,2,3,1))));
    }

    public int solve(ArrayList<Integer> A) {
        int mid = findMid(0,A.size()-1);
        sort(A,0,mid);
        sort(A,mid+1,A.size()-1);
        merge(A,0,mid,A.size()-1);
        return totalInversions;
    }

    public void sort(ArrayList<Integer> A,int start,int end){
        if(start == end){
            return;
        }

        int mid = findMid(start,end);
        sort(A,start,mid);
        sort(A,mid+1,end);
        merge(A,start,mid,end);

    }

    public void merge(ArrayList<Integer> A,int start,int mid,int end){
        int i=0;
        int j = 0;
        int k = start;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for( int p = start;p<=mid;p++){
            left.add(A.get(p));
        }

        for( int p = mid+1;p<=end;p++){
            right.add(A.get(p));
        }

        while(i < left.size() && j < right.size()){
            if(left.get(i) > 2*right.get(j)){
                A.set(k++,right.get(j++));
                totalInversions+= (left.size()-i);
            }else{
                A.set(k++,left.get(i++));
            }
        }

        if(i<left.size()){
            while(i<left.size()){
                A.set(k++,left.get(i++));
            }
        }

        if(j<right.size()){
            while(j<right.size()){
                A.set(k++,right.get(j++));
            }
        }
    }

    public int findMid(int left,int right){
        int rMinusL = (right-left)>>1;
        return left+rMinusL;
    }
}
