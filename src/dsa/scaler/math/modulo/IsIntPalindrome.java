package dsa.scaler.math.modulo;

public class IsIntPalindrome {

    public static void main(String[] args) {
        int[] testSet = new int[]{
              1234,
              1221,
              12321,
              1001,
              10,
              1,
              0,
            -121
        };
        IsIntPalindrome isIntPalindrome = new IsIntPalindrome();
        for(int testData : testSet){
            System.out.println(testData +" is a plaindrome : "+isIntPalindrome.isPalindrome(testData));
        }
    }

    public int isPalindrome(int A) {
        if(A < 0) return 0;
        if(A < 10){
            return 1;
        }

        int divisor = A;
        int power = 1;

        while(divisor != 0){
            divisor = (int) Math.floor(divisor/10);
            power++;
        }
        power--;

        int i = 1, sum = 0;
        while(i <= power){
            sum += Math.pow(10,power-i) * (Math.floor(A % Math.pow(10,i)/Math.pow(10,i-1)));
            i++;
        }
        return sum == A ? 1 : 0;
    }
}
