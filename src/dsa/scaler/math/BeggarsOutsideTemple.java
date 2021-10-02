package dsa.scaler.math;

import java.util.Arrays;

public class BeggarsOutsideTemple {
  
  public static void main(String[] args) {
    BeggarsOutsideTemple bot = new BeggarsOutsideTemple();
    System.out.println(Arrays.toString(bot.solve(5, new int[][]{
      {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
    })));

    // System.out.println(Arrays.toString(bot.solve(10, new int[][]{
    //   {1, 3, 10},
    //   {6, 9, 2},
    //   {3, 5, 3},
    //   {2, 8, 4},
    //   {6, 7, 5}
    // })));

    // System.out.println(Arrays.toString(bot.solve(5, new int[][]{
    //   {1, 2, 100},
    //   {2, 5, 100},
    //   {3, 4, 100}
    // })));

    /** */
  }
  
  public int[] solve(int A, int[][] B) {
    int[] result = new int[A];
    int maxRangeVal = B[0][1];
    for (int i = 0; i < B.length; i++) {
      int indexToAdd = B[i][0] - 1;
      int indexToSub = B[i][1] - 1;
      result[indexToAdd] += B[i][2];
    
      if (maxRangeVal < B[i][1]) {
        maxRangeVal = B[i][1];
      }
    
      if ((indexToSub + 1) < A) result[indexToSub] -= B[i][2];      
    }
    result[A - 1] = result[A-1] < 0 ? 0 : result[A-1];
    for (int i = 1; i < maxRangeVal; i++) {
      result[i] = result[i] + result[i - 1];
    }
    return result;   
  }
}
