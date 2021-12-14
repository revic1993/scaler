package dsa.scaler.strings;

public class ReverseTheSentence {

    public static void main(String[] args) {
        String[] testSet = new String[]{
                "  the sky is   blue ",
                "this is Rujul Solanki ","a","av"
        };
        ReverseTheSentence rts = new ReverseTheSentence();
        for(String testData : testSet){
            System.out.println(testData + " reversed is : "+rts.solve(testData));
        }
    }

    public String solve(String A) {
        char[] charArr = A.trim().replaceAll("\\s{2,}"," ").toCharArray();
        this.reverse(charArr,0,charArr.length-1);
        int start = 0;

        while(start < charArr.length){
            int end = start;
            while(end < charArr.length && charArr[end] != ' '){
                end++;
            }
            this.reverse(charArr,start,end-1);
            start = end+1;
        }
        return String.valueOf(charArr);
    }

        public void reverse(char[] data, int start, int end){
            while(start<end){
                char temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                start++;
                end--;
            }
        }
}
