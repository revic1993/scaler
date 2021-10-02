package dsa.scaler.arrays;

public class PickFromBothSides {
  public static void main(String[] args) {
    int B[] = {
      16
    };

    int A[][] = {
        { 511, -798, -366, -728, -945, -672, -354, -638, -114, -125, -567, 869, -858, 844, 416, 881, 998, -678, -349, -979, 699, 557, -524, 892, -611, 75, -288, -400, -490, 3, -131, 861, -312, 401, 789, 255, -577, 2, -415, -818, -715, 88, 426, -383, 757, 832, -68, -831, -846, 721, 189, 976, 329, -632, -308, 425, -445, 434, -451, 441, 512, -855, -940, 718, 753, -861, -577, -721, 996, -313, -471, -451, 437, 866, -51, -807 }
    };

    for (int i = 0; i < A.length; i++) {      
      System.out.println(solve(A[i], B[i]));
    }
  }

  public static int solve(int[] A, int B) {
    int N = A.length-1; 
    
    if (N == 1) {
      return A[0];
    }

    if (B == 1) {
      return Math.max(A[0], A[N]);
    }
    
    int sum = 0;
    int start = 0,end = B-1;
    //finding initial sum
    for (int i = start; i <= end; i++) {
      sum += A[i];
    }

    start = N;
    int max = sum;
    //sliding the window till B values
    while (start > N - B) {
      int endVal = (end >= 0 ? A[end] : 0);
      sum = sum + A[start] -  endVal;
      max = Math.max(sum, max);
      end--;
      start--;      
    }
    
    return max;
  }
}
