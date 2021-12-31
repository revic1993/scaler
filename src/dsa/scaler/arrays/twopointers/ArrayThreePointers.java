package dsa.scaler.arrays.twopointers;

import java.util.List;

public class ArrayThreePointers {
    public static void main(String[] args) {
        ArrayThreePointers atp = new ArrayThreePointers();
        System.out.println(atp.minimize(List.of(1, 4, 10),List.of(2,15,20),List.of(10, 12)));
        System.out.println(atp.minimize(List.of(3,5,6),List.of(2),List.of(3,4)));
    }

    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int min = Integer.MAX_VALUE;
        int total = A.size()+B.size()+C.size();
        int aP=0,bP=0,cP=0;
        for(int i=0;i<total;i++){
            int a = A.get(aP);
            int b = B.get(bP);
            int c = C.get(cP);
            int ab = Math.abs(a-b);
            int bc = Math.abs(b-c);
            int ca = Math.abs(c-a);
            int max = Math.max(ab,bc);
            max = Math.max(max,ca);
            min = Math.min(max,min);
            boolean isASmallest = a <= b && a <= c;
            boolean isBSmallest = b <= c && b <= a;
            boolean isCSmallest = c <= a && c <= b;
            if(isASmallest && aP < A.size()-1){
                aP++;
                continue;
            }

            if(isBSmallest && bP < B.size()-1){
                bP++;
                continue;
            }

            if(isCSmallest && cP < C.size()-1){
                cP++;
                continue;
            }

            if(aP == A.size()-1){
                if(b <= c && bP < B.size()-1){
                    bP++;
                    continue;
                }
                if(c <= b && cP < C.size()-1){
                    cP++;
                    continue;
                }
            }

            if(bP == A.size()){
                if(a <= c && aP < A.size()-1){
                    aP++;
                    continue;
                }
                if(c <= a && cP < C.size()-1){
                    cP++;
                    continue;
                }
            }

            if(cP == A.size()){
                if(a <= b && aP < A.size()-1){
                    aP++;
                    continue;
                }
                if(b <= a && bP < B.size()-1){
                    bP++;
                }
            }

        }

        return min;
    }
}
