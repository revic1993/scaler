package dsa.scaler.bitmanipulation;

public class StrangeEquality {
    public static void main(String[] args) {
        int[] testSet = {10,5,13,2};
        for(int testData : testSet){
            System.out.println(testData +" => "+solve(testData));
        }
    }

    public static int solve(int A){
        int x = 0;
        int y = 1;
        while(y < A){
            if((y&A) != y){
                x+=y;
            }
            y = y<<1;
        }
        return x^y;
    }
}
