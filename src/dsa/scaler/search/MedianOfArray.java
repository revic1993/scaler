package dsa.scaler.search;

import java.util.List;

public class MedianOfArray {
    public static void main(String[] args) {
        MedianOfArray moa = new MedianOfArray();
        System.out.println(moa.findMedianSortedArrays(List.of(-50, -42, -38, 1, 4, 9, 16, 33, 47 ),List.of(-44 )));
    }

    public double findMedianSortedArrays(final List<Integer> first, final List<Integer> second) {
        double median = 0;

        List<Integer> a = first.size() >= second.size() ? first : second;
        List<Integer> b = first.size() < second.size() ? first : second;

        if(b.size() == 0){
            int mid = a.size() >> 1;
            if((a.size() & 1 ) == 1){
                return a.get(mid);
            }else{
                return (a.get(mid)+a.get(mid-1))/2.0;
            }
        }

        int fLow = 0;
        int fHigh = a.size()-1;
        int lpSize = (a.size()+b.size()) >> 1;
        boolean isOdd = (( a.size() + b.size() ) & 1) == 1;
        while(fLow <= fHigh){
            int mid = (fHigh + fLow) >> 1;
            if(mid >= lpSize){
                fHigh = mid-1;
                continue;
            }
            int sHigh = lpSize - (mid + 1);
            if(sHigh > b.size()){
                fLow = mid+1;
                continue;
            }
            int maxLeft = Math.max(a.get(mid),sHigh == 0 ? Integer.MIN_VALUE : b.get(sHigh-1));
            int minRight = Math.min(a.get(mid+1),sHigh >= b.size() ? Integer.MAX_VALUE : b.get(sHigh));
            if(maxLeft <= minRight){
                if(isOdd){
                    return minRight;
                }
                return ((maxLeft+minRight) / 2.0);
            }
            //if a is contributing to highest value
            if(maxLeft == a.get(mid)){
                fHigh = mid-1;
            }else{
                fLow = mid+1;
            }
        }
        return median;
    }

}
