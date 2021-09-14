package dsa.math.modulo;

public class NumberToColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(943566));
    }
    public static String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        int divisor = A;

        while(divisor > 26){
            int remainder = divisor % 26;
            if(remainder == 0){
                remainder = 26;
            }
            divisor = (divisor - remainder)/26;
            sb.insert(0,(char)(64+remainder));
        }
        if(divisor == 0){
            divisor = 26;
        }
        sb.insert(0,(char)(64+divisor));
        return sb.toString();
    }
}
