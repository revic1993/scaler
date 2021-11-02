package dsa.scaler.math.modulo;

public class InverseModulo {
    public static void main(String[] args) {
        int[][] testSet = {
                {12,55557209}
        };
        for(int[] testData : testSet){
            System.out.println(solve(testData[0],testData[1]));
        }
    }

    public static int solve(int A, int B) {
        int p = B-2;
        long ans = 1;
        long a = A;
        while(p > 0){
            if(p%2 == 0){
                a = (a%B*a%B)%B;
                p = p/2;
            }else{
                ans = (ans%B*a%B)%B;
                a = (a%B*a%B)%B;
                p = (p-1)/2;
            }
        }
        return (int) ans;
    }
    
}
