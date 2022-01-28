package dsa.scaler.arrays.sort;

import dsa.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs2 {
    int totalInversions;

    public static void main(String[] args) {
        ReversePairs2 rp = new ReversePairs2();
        ArrayList<Integer> data = new ArrayList<>(List.of(2000000000, 2000000000, -2000000000));
        System.out.println(rp.solve(data));
        Utils.printSingleArr(data);
    }

    public int solve(ArrayList<Integer> A) {
        sort(A,0,A.size());
        return totalInversions;
    }

    public void sort(ArrayList<Integer> A, int start, int end){
        if(start+1 == end){
            return;
        }

        int mid = (start+end) >> 1;
        sort(A,start,mid);
        sort(A,mid,end);
        merge(A,start,mid,end);
    }

    public void merge(ArrayList<Integer> A, int start, int mid, int end){
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i=start;i<mid;i++){
            left.add(A.get(i));
        }

        for(int j=mid;j<end;j++){
            right.add(A.get(j));
        }

        int lp = 0;
        int rp = 0;

        for(int k=start;k<end;k++){
            if(lp >= left.size() || rp >= right.size()){
                break;
            }

            if(((left.get(lp)+1) >> 1) > right.get(rp)){
                rp++;
                totalInversions += (left.size() - lp);
            }else{
                lp++;
            }
        }

        lp = 0;
        rp=0;
        for(int k=start;k<end;k++){
            if(lp >= left.size()){
                A.set(k,right.get(rp++));
                continue;
            }

            if(rp >= right.size()){
                A.set(k,left.get(lp++));
                continue;
            }

            if( left.get(lp) > right.get(rp)){
                A.set(k,right.get(rp++));
            }else{
                A.set(k,left.get(lp++));
            }
        }

    }

}
/*
*
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
                totalInversions+= (left.size()-i);
                i++;
            }else{
                j++;
            }
        }

        i=0;j=0;

        while(i < left.size() && j < right.size()){
            if(left.get(i) > right.get(j)){
                A.set(k++,right.get(j++));
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
    }*/