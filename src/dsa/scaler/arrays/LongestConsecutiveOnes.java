package dsa.scaler.arrays;

import dsa.utils.Utils;

import java.util.ArrayList;

public class LongestConsecutiveOnes {

    public static void main(String[] args) {
        LongestConsecutiveOnes lco = new LongestConsecutiveOnes();
        System.out.println(lco.solve("0111110110")); // 3 0 0 3 0 1
    }

    public int solve(String A) {
        int counter = 0;
        ArrayList<Integer> intArr = new ArrayList<>();
        int totalPosGroups = 0;

        if(A.length() == 1){
            return A.charAt(0) == '1' ? 1 : 0;
        }

        for(char c : A.toCharArray()){
            if(c == '1'){
                counter++;
                continue;
            }
            if(counter > 0){
                totalPosGroups++;
                intArr.add(counter);
            }
            counter = 0;
            intArr.add(0);
        }

        if(counter > 0){
            totalPosGroups++;
            intArr.add(counter);
        }


        int[] groups = intArr.stream().mapToInt(Integer::intValue).toArray();
        if(totalPosGroups == 1){
            for (int group : groups) {
                if (group > 0) {
                    return group;
                }
            }
        }

        if(groups.length < 3){
            return groups[0] + groups[1];
        }

        int windowSum = 0;
        int windowPos = 0;


        for(int i=0;i<groups.length-2;i++){
            windowPos=0;
            int currWindowSum = groups[i]+groups[i+1]+groups[i+2];
            if(groups[i] > 0){
                windowPos++;
            }

            if(groups[i+1] > 0){
                windowPos++;
            }

            if(groups[i+2] > 0){
                windowPos++;
            }

            if(windowPos > 0 && totalPosGroups > windowPos ){
                currWindowSum++;
            }
            windowSum = Math.max(windowSum,currWindowSum);
        }


        return windowSum;
    }

}
