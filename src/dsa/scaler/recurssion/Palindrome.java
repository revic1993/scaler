package dsa.scaler.recurssion;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String[] testSet = new String[]{ "abba","abcba","abcd","abcde","abcda","a"};
        for(String testData : testSet){
            System.out.println(testData +" is palindrome : "+palindrome.solve(testData));
        }
    }

    public int solve(String A) {
        return this.isPalindrome(A, 0,A.length()-1);
    }

    public int isPalindrome(String A,int start, int end){
        if(start >= end){
            return 1;
        }

        if(A.charAt(start) != A.charAt(end)){
            return 0;
        }

        return this.isPalindrome(A,++start,--end);
    }
}
