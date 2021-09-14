package dsa.arrays;

public class MinimumDistance {
    public static void main(String[] args){
        String[] testSet = new String[]{"x...o.x...o","xxx...xxx"};
        for(int i=0;i< testSet.length;i++){
            System.out.println("string: "+testSet[i]+ " distance: " + solve(testSet[i]));
        }
    }

    public static int solve(String A){
        char[] charArr = A.toCharArray();
        int     LATEST_X_INDEX = -1,
                LATEST_O_INDEX=-1;
        int minDiff = -1;
        for(int i=0;i<charArr.length;i++){
            if(charArr[i] == '.'){
                continue;
            }

            if(charArr[i] == 'x'){
                LATEST_X_INDEX = i;
            }

            if(charArr[i] == 'o'){
                LATEST_O_INDEX = i;
            }

            if(LATEST_O_INDEX == -1 || LATEST_X_INDEX == -1){
                continue;
            }

            int absDiff = Math.abs(LATEST_X_INDEX - LATEST_O_INDEX);

            if(minDiff == -1){
                minDiff = absDiff;
                continue;
            }


            minDiff = minDiff > absDiff ? absDiff : minDiff;
        }
        return minDiff;
    }
}
