package dsa.scaler.strings;

public class ClosetPalindrome {
    public static void main(String[] args) {

    }
    public String solve(String A) {
        boolean isChanceUsed = false;
        int mid = A.length() >> 1;
        for(int i=0;i<mid;i++){
            int end = A.length() - i - 1;
            if(A.charAt(i) == A.charAt(end)){
                continue;
            }
            if(!isChanceUsed){
                isChanceUsed = true;
                continue;
            }
            return "NO";
        }
        if(!isChanceUsed && A.length()%2 != 0){
            return "YES";
        }
        return isChanceUsed ? "YES" : "NO";
    }
}
