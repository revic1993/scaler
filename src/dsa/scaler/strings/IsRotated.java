package dsa.scaler.strings;

import java.util.ArrayList;

public class IsRotated {

    public static void main(String[] args) {
        IsRotated isr = new IsRotated();
        System.out.println(isr.isRotated("ashish","ahisha"));
    }
    boolean isRotated(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        //assuming s1=Ashish and s2=Shisha
        // find set of matching first characters
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i) != s1.charAt(0)){
                continue;
            }
            int j = i;
            int k = 0;
            while(k < s1.length() && s1.charAt(k) == s2.charAt(j%s2.length())){
                k++;
                j++;
            }
            if(k == s1.length()){
                return true;
            }
        }
        return false;
    }
}
