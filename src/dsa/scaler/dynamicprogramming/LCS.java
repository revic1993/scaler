package dsa.scaler.dynamicprogramming;

public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.solve("aaaaaa","ababab"));
    }

    public int solve(String A, String B) {
        int[][] LCS = new int[2][B.length()+1];
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                LCS[1][j] = Math.max(LCS[1][j-1],LCS[0][j-1]+(A.charAt(i-1) == B.charAt(j-1) ? 1 : 0));
            }
            LCS[0] = LCS[1];
            LCS[1] = new int[B.length()+1];
        }
        return LCS[0][B.length()];
    }
}
