package dsa.strings;

import lombok.Getter;

public class ZigZagConversion {
    public static void main(String[] args) {
        String testSet[] = {
          "PAYPALISHIRING",

        };
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(testSet[0]+" converted to 3 rows is "+zzc.convert(testSet[0],3));
        System.out.println(testSet[0]+" converted to 4 rows is "+zzc.convert(testSet[0],4));
    }

    public String convert(String s, int numRows) {
        if(numRows > s.length()){
            return s;
        }

        if(s.length() == 1 || numRows == 1){
            return s;
        }
        StringBuilder[] sbArr = new StringBuilder[numRows];
        int arrInd = 0;
        boolean add = true;
        for(int i=0;i<s.length();i++){
            if(sbArr[arrInd] == null){
                sbArr[arrInd] = new StringBuilder();
            }

            sbArr[arrInd].append(s.charAt(i));

            if(add && arrInd == numRows-1){
                add = false;
            }else if(!add && arrInd == 0){
                add = true;
            }

            if(add){
                arrInd++;
            }else{
                arrInd--;
            }
        }

        for(int i=1;i<numRows;i++){
            sbArr[0].append(sbArr[i]);
        }
        return sbArr[0].toString();
    }


}
