package dsa.strings;

public class RotateString {

    public static void main(String[] args) {
        TestData[] testSet = new TestData[]{
                new TestData(1,"scaler"),
                new TestData(2,"scaler"),
                new TestData(3,"scaler"),
                new TestData(4,"scaler"),
                new TestData(5,"scaler"),
                new TestData(6,"scaler"),
                new TestData(7,"scaler")
        };
        RotateString rs = new RotateString();
        for (TestData testData : testSet){
            System.out.println("String rotated "+testData.getB() +" times is: "+rs.solve(testData.getA(), testData.getB()));
        }
    }

    public String solve(String A, int B) {
        int start = A.length() - (B % A.length());

        if(start == 0){
            return A;
        }

        char[] charArr = new char[A.length()];
        int j=0;
        for(int i = start;i<A.length();i++,j++){
            charArr[j] = A.charAt(i);
        }

        for(int i = 0;i<start;i++){
            charArr[i+j] = A.charAt(i);
        }

        return String.valueOf(charArr);
    }

    private static class TestData{
        private int B;
        private String A;
        TestData(int B,String A){
            this.B = B;
            this.A = A;
        }

        public int getB() {
            return this.B;
        }

        public String getA() {
            return this.A;
        }
    }
}
