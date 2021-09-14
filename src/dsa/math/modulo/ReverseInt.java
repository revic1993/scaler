package dsa.math.modulo;

public class ReverseInt {

    public static void main(String[] args) {
        int testSet[] = {
                -1170064042,
                -1146467285
        };

        for(int testData : testSet){
            System.out.println(solution(testData));
        }
    }

    public static int solution(int A){
        boolean isNeg = false;


        if(A < 0){
            A = A*-1;
            isNeg = true;
        }

        int divisor = A;
        int power = 1;

        while(divisor != 0){
            divisor = (int) Math.floor(divisor/10);
            power++;
        }
        power--;

        if(power > 10){
            return 0;
        }

        int i = 1, sum = 0;
        while(i <= power){

            int digit = (int)Math.floor((A%Math.pow(10,i))/Math.pow(10,i-1));
            if(digit > 2 && (power-i) >=9){
                return 0;
            }
            int currentSum = (int) (Math.pow(10,power-i) * digit);
            int currentMax = Integer.MAX_VALUE - sum;
            if(currentSum > currentMax){
                return 0;
            }
            sum += currentSum;
            i++;
        }
        return isNeg ? sum*-1 : sum;
    }
}
