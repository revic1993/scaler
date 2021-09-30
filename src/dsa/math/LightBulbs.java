package dsa.math;

public class LightBulbs {

    public static void main(String[] args) {
        System.out.println(bulbs(new int[]{1,1,1,1}));
        System.out.println(bulbs(new int[]{1,0,1,0}));
        System.out.println(bulbs(new int[]{1,0,0,0,1,1}));
    }
    public static int bulbs(int[] A) {
        int i=0;
        while(i<A.length && A[i]!=0){
            i++;
        }

        if(i == A.length){
            return 0;
        }

        int sum = 1;
        i++;
        while(i<A.length){
            if(sum % 2 == 0 && A[i] == 0 || sum%2 != 0 && A[i]==1){
                sum++;
            }
            i++;
        }
        return sum;
    }
}
