package dsa.scaler.strings;

public class SmallestPrefix {
    public String smallestPrefix(String A, String B) {
        StringBuilder result = new StringBuilder();
        result.append(A.charAt(0));
        int aPointer=1,bPointer=0;
        while(aPointer < A.length() && A.charAt(aPointer) < B.charAt(bPointer)){
            result.append(A.charAt(aPointer));
            aPointer++;
        }
        result.append(B.charAt(bPointer));
        return result.toString();
    }
}
