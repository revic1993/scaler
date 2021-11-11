package dsa.scaler.math.prime;
/*
* src : https://www.scaler.com/academy/mentee-dashboard/class/12422/assignment/problems/4106?navref=cl_tt_lst_sl
* */
public class OpenDoors {
    public static void main(String[] args) {
        int[] testSet = {};
        for(int testData : testSet) {
            System.out.println("Number of open doors for "+testData+" are "+solve(testData));
        }
    }

    public static int solve(int A) {
        int result = 0 ;
        /*
        * if the factors are even - door stay closed
        * if the factors are odd - door stays open
        * factors are odd only in case of perfect squares
        * */
        int perfectSquare = 1;
        int i=2;
        while(perfectSquare <= A){
            result++;
            perfectSquare = i*i;
            i++;
        }

        return result;
    }


}
