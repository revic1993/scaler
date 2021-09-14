package dsa.math.modulo;

public class ColumnTitleToNumber {

    public static void main(String[] args) {
        String[] testSet = new String[]{
                "A",
                "AA",
                "ZZ",
                "AAAAA",
                "ZZZZZ",
                "ABCDE"
        };
        ColumnTitleToNumber ctn = new ColumnTitleToNumber();
        for(String testData : testSet){
            System.out.println(testData+" to num is "+ctn.titleToNumber(testData));
        }
    }

    public int titleToNumber(String A) {
        int MOD = 64;
        int i = A.length()-1;
        int sum = 0;
        int power = 0;
        while(i >=0){
            int remainder = A.charAt(i) % MOD;
            sum += (int)(remainder * Math.pow(26,power));
            power++;
            i--;
        }
        return sum;
    }
}
