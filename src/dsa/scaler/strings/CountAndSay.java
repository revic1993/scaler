package dsa.scaler.strings;

public class CountAndSay {

    public static void main(String[] args) {
        int[] testSet = new int[]{ 0,11, 1, 10,123,112233,123321};
        for(int testData : testSet){
            System.out.println(testData+" says "+countAndSay(testData));
        }
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("");
        String number = n+"";
        char[] digits = number.toCharArray();
        int i=0;
        char prev = digits[0];
        while(i < digits.length){
            int counter = 0;
            while(prev == digits[i]){
                counter++;
                i++;
                if(i == digits.length){
                    break;
                }
            }
            sb.append(counter).append(prev);
            if(i != digits.length){
                prev = digits[i];
            }
        }
        return sb.toString();
    }
}
