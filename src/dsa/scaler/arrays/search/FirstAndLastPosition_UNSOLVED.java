package dsa.scaler.arrays.search;

public class FirstAndLastPosition_UNSOLVED {

  public static void main(String[] args) {
    /* 0 1 2 3 4 5 
      [..x,8,....,8,y....]
     -> 

    */
  }
  
  public int[] searchRange(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int range[] = {-1,-1};
    while (start < end) {
      int mid = (start + end) >> 2;
      if (nums[mid] == target) {        
        break;
      }
    }

    return range;
  }
}
