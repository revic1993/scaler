package dsa.arrays;


import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] numberStr = s.split(" ");
        int[] numbers = new int[Integer.parseInt(numberStr[0])];
        for(int i=1;i<numberStr.length;i++){
            numbers[i-1] = Integer.parseInt(numberStr[i]);
        }

        int rotateBy = Integer.parseInt(scanner.nextLine());

        int startFrom = numbers.length - (rotateBy % numbers.length);
        StringBuilder result = new StringBuilder();

        for(int i=startFrom;i<numbers.length;i++){
            if(result.length() == 0){
                result.append(numbers[i]);
                continue;
            }
            result.append(" ");
            result.append(numbers[i]);
        }

        for(int i=0;i<startFrom;i++){
            if(result.length() == 0){
                result.append(numbers[i]);
                continue;
            }
            result.append(" ");
            result.append(numbers[i]);
        }

        System.out.println(result.toString());
    }
}
