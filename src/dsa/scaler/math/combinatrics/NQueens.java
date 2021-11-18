package dsa.scaler.math.combinatrics;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    static ArrayList<String[]> resultSet = new ArrayList<>();

    public static void main(String[] args) {
        int[] testSet = {4};
        for(int testData : testSet){
            String[][] values = solveNQueens(testData);
            System.out.println("A : "+testData+" [");
            for(String[] value : values){
                System.out.println(Arrays.toString(value));
            }
            System.out.println(" ]");
        }
    }
    public static String[][] solveNQueens(int A) {
        resultSet = new ArrayList<>();
        int[] columns = new int[A];
        Arrays.fill(columns,-1);
        generatePositions(columns,0,0);
        int i=0;
        if(resultSet.size() == 0){
            return new String[][]{};
        }
        String[][] result = new String[resultSet.size()][A];
        for(String[] resData : resultSet){
            result[i++] = resData;
        }
        return result;
    }

    public static void generatePositions(int[] columns,int row,int column){
        if(row == columns.length){
            addColumnsAsResult(columns);
            return;
        }

        for(int i=0;i<columns.length;i++){
            if(isValid(columns,row,i)){
                columns[row] = i;
                generatePositions(columns,row+1,column);
                columns[row]=-1;
            }
        }
    }

    public static boolean isValid(int[] columns, int r, int c){
        for(int i=0;i<r;i++){
            if(c == columns[i] || (r+c) == (i+columns[i]) || (r-i) == (c-columns[i])){
                return false;
            }
        }
        return true;
    }

    public static void addColumnsAsResult(int[] columns){
        String[] result = new String[columns.length];
        for(int i=0;i<columns.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<columns.length;j++){
                if(columns[i] == j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            result[i] = sb.toString();
        }
        resultSet.add(result);
    }
}
