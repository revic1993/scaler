package dsa.leetcode.binarysearch;

public class MaxClosestDistance {
    public static void main(String[] args) {
        MaxClosestDistance mcd = new MaxClosestDistance();
        System.out.println(mcd.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
    public int maxDistToClosest(int[] seats) {
        int maxZeros = Integer.MIN_VALUE;
        int currentZeros = 0;
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 0){
                currentZeros++;
            }else{
                maxZeros = Math.max(currentZeros,maxZeros);
                currentZeros = 0;
            }
        }
        return ( maxZeros + 1 ) >> 1;
    }
}
