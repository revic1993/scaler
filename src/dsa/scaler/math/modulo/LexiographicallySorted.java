package dsa.scaler.math.modulo;

public class LexiographicallySorted {
    public static void main(String[] args) {
        String testSet[] = {
                "abc","acb","bac","bca","cab","cba",
                "random","rujl","char","rain","lexiographc"
        };
        for (String testData: testSet) {
            System.out.println(testData+" is ranked "+findRank(testData));
        }
    }

    public static int findRank(String A) {
        int rank = 1;
        int MOD = 1000003;
        if(A.length() == 1){
            return rank;
        }

        int multiplier = 1;
        int prevNum = 1;
        for(int i=A.length()-2;i>=0;i--){
            int totalSmallerChars = 0;
            for(int j = i+1;j < A.length();j++){
                if(A.charAt(i) > A.charAt(j)){
                    totalSmallerChars++;
                }
            }

            int sum = (((totalSmallerChars % MOD) * (multiplier%MOD))%MOD);
            rank = ((rank%MOD) + (sum%MOD))%MOD;


            int newMul = (prevNum%MOD+1)%MOD;
            multiplier = ((multiplier%MOD) * (newMul%MOD))%MOD;
            prevNum++;
        }
        return rank;
    }
}
