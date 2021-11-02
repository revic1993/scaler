package dsa.scaler.math;

public class MagicNumber5 {

    public static void main(String[] args) {
        int[] testSet = {3,4,5,6,7,8};
        for(int testData : testSet){
            System.out.println("Magic number of "+testData + " is "+solve(testData));
        }
    }

    public static int solve(int A) {
        String numBase2 = Integer.toBinaryString(A);
        int pow = 1;
        int result = 0;
        for(int i=numBase2.length()-1;i>=0;i--){
            if(numBase2.charAt(i) =='1'){
                result += Math.pow(5,pow);
            }
            pow++;
        }
        return result;
    }
}
