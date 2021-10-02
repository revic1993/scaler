package dsa.scaler.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class ParseDate {

    public static void main(String[] args){
        String[] dataSet = new String[]{"16th Mar 2068","1th Apr 2020","22nd Mar 1993"};
        ParseDate pd = new ParseDate();
        for(String data : dataSet){
            System.out.println(pd.solve(data));
        }
    }

    public String solve(String A) {
        String[] dateStr = A.split(" ");
        HashMap<String,String> day = new HashMap<>();


        HashMap<String,String> month = new HashMap<>();
        month.put("Jan","01");
        month.put("Feb","02");
        month.put("Mar","03");
        month.put("Apr","04");
        month.put("May","05");
        month.put("Jun","06");
        month.put("Jul","07");
        month.put("Aug","08");
        month.put("Sep","09");
        month.put("Oct","10");
        month.put("Nov","11");
        month.put("Dec","12");

        return dateStr[2]+"-"+month.get(dateStr[1])+"-"+this.getDate(dateStr[0]);
    }

    private String getDate(String dateVal){
        char[] chars = dateVal.toCharArray();
        HashSet<Character> numbers = new HashSet<Character>();
        numbers.add('0');
        numbers.add('1');
        numbers.add('2');
        numbers.add('3');
        numbers.add('4');
        numbers.add('5');
        numbers.add('6');
        numbers.add('7');
        numbers.add('8');
        numbers.add('9');
        String numberStr = "";
        for(int i=0;i<chars.length;i++){
            if(!numbers.contains(chars[i])){
                continue;
            }
            numberStr += chars[i];
        }
        int number = Integer.parseInt(numberStr);
        return number > 9 ? number+"" : "0"+number;
    }

}
