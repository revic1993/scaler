package dsa.scaler.dynamicprogramming;

public class RegexMatch {
    public static void main(String[] args) {
        RegexMatch regexMatch = new RegexMatch();
        System.out.println(regexMatch.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","a**************************************************************************************"));
    }
    public int isMatch(final String S, final String RegEx) {
       boolean[][] isMatch = new boolean[2][S.length()+1];
       isMatch[0][0] = true;
       for(int i=1;i<=RegEx.length();i++){
           for(int j=0;j<=S.length();j++){
               if(RegEx.charAt(i-1) == '?'){
                   isMatch[1][j] = j != 0 && isMatch[0][j - 1];
                   continue;
               }
               if (RegEx.charAt(i - 1) == '*') {
                   isMatch[1][j] = isMatch[0][j] || (j != 0 && (isMatch[1][j-1] || isMatch[0][j-1]));
                   continue;
               }
               isMatch[1][j] = j > 0 && RegEx.charAt(i-1) == S.charAt(j-1) && isMatch[0][j-1];
           }
           isMatch[0] = isMatch[1];
           isMatch[1] = new boolean[S.length()+1];
       }
       return isMatch[0][S.length()] ? 1 : 0;
    }
}
