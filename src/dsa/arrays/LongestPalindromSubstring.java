package dsa.arrays;

public class LongestPalindromSubstring {

    public static void main(String[] A){
        String[] testSet = new String[]{
                "babad",
                "cbbd",
                "ac",
                "a",
                "abbdbbe",
                "abcde",
                "abb",
                "bbbbbb",
                "bbbbb"
        };
        LongestPalindromSubstring lps = new LongestPalindromSubstring();
        for(String testCase : testSet){
            System.out.println("Testcase "+testCase+ " has longest substring as : "+lps.solve(testCase));
        }
    }

    public String solve(String s){
        char[] a = s.toCharArray();

        String maxPalindrome = ""+a[0];

        for(int i=0;i<a.length-1;i++){
            String evenPalindrome = "", oddPalindrome = "";

            if(a[i] == a[i+1]){
                evenPalindrome = this.getPossibleLongestPalindrome(-1,i,i+1,a);
            }

            if(i!=0 && a[i-1] == a[i+1]){
                oddPalindrome = this.getPossibleLongestPalindrome(i,i-1,i+1,a);
            }


            if(oddPalindrome.length()==0 && evenPalindrome.length()==0){
                continue;
            }

            if(oddPalindrome.length() > 0){
                maxPalindrome = maxPalindrome.length() < oddPalindrome.length() ? oddPalindrome : maxPalindrome;
            }

            if(evenPalindrome.length() > 0){
                maxPalindrome = maxPalindrome.length() < evenPalindrome.length() ? evenPalindrome : maxPalindrome;
            }
        }
        return maxPalindrome;
    }

    public String getPossibleLongestPalindrome( int initialIndex, int j, int k,char[] a){
        StringBuilder sb = new StringBuilder();
        if(initialIndex!=-1){
            sb.append(a[initialIndex]);
        }
        while(j >= 0 && k < a.length && a[j] == a[k]){
                sb.insert(0,a[j]);
                sb.append(a[k]);
                j--;
                k++;
            }
        return sb.toString();
    }
}
