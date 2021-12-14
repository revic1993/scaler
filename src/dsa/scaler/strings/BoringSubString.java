package dsa.scaler.strings;

public class BoringSubString {

    public static void main(String[] args) {
        BoringSubString bss = new BoringSubString();
        System.out.println(bss.solve("abcd"));
        System.out.println(bss.solve("aab"));
    }

    public int solve(String A){
        char[] charArr = A.toCharArray();
        int oddMax = Integer.MIN_VALUE;
        int evenMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;
        if(charArr.length == 0){
            return 0;
        }
        for(char c : charArr){
            if(c % 2 == 0){
                evenMax = Math.max(evenMax,c);
                evenMin = Math.min(evenMin,c);
            }else{
                oddMax = Math.max(oddMax,c);
                oddMin = Math.min(oddMin,c);
            }
        }

        // either of string is empty
        if(evenMax == Integer.MIN_VALUE || oddMin == Integer.MAX_VALUE){
            return 1;
        }

        if((oddMax+1==evenMin || oddMax-1 == evenMin) && (oddMin+1 == evenMax || oddMin-1 == evenMax)){
            return 0;
        }

        return 1;
    }
}
