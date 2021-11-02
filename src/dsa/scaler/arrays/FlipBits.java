package dsa.scaler.arrays;

/*
* Source : https://www.scaler.com/academy/mentee-dashboard/classroom/multidimensional-arrays-c25633a4-d486-4265-bf0c-5e2d262589b0/#assignment%2F329
* */
public class FlipBits {
    public static void main(String[] args) {

    }

    public int[] solve(String A){
        int[] pfSumArr = new int[A.length()];
        int j=0;

        for(char a : A.toCharArray()){
            pfSumArr[j] = a == '1' ? -1 : 1;
            j++;
        }



        return new int[]{};
    }
}
