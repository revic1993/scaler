package dsa.scaler.dynamicprogramming;

public class MinDistance {
    public static void main(String[] args) {
        MinDistance md = new MinDistance();
        System.out.println(md.minDistance("abad","abac"));
    }

    public int minDistance(String A, String B) {
        int[][] cost = new int[A.length()+1][B.length()+1];

        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i==0 || j==0){
                    cost[i][j] = i+j;
                    continue;
                }
                if(A.charAt(i-1) == B.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1];
                    continue;
                }
                cost[i][j]=Math.min(cost[i][j-1]+1,cost[i-1][j]+1);
                cost[i][j] =  Math.min(cost[i][j],cost[i-1][j-1]+1);
            }
        }
        return cost[A.length()][B.length()];
    }
}
