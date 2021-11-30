package dsa.scaler.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstAndLastPosition {

  public static void main(String[] args) {
    ArrayList<List<Integer>> testSet = new ArrayList<>();
    testSet.add(Arrays.asList(1,1,1,2,2,2,3));
    testSet.add(Arrays.asList(1,1,1,2,2,2,3));
    testSet.add(Arrays.asList(1,1,1,2,2,2,3));
    testSet.add(Arrays.asList(4,4,4,4));
    testSet.add(Arrays.asList(4,4,4,4));
    for(int i=0;i<testSet.size();i++){
      System.out.println(new FirstAndLastPosition().searchRange(testSet.get(i),i+1));
    }
  }

  public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
      ArrayList<Integer> result = new ArrayList<>(Arrays.asList(-1,-1));

      // first find the leftmost element
      int l = 0;
      int r = A.size()-1;
      int m = -1;
      while(l <= r){
        m = (r+l)>>1;
        int middleVal = A.get(m);
        if(middleVal == B && (m==0 || A.get(m-1)!= middleVal)){
          result.set(0,m);
          break;
        }

        if(middleVal == B){
          r = m-1;
          continue;
        }

        if(middleVal < B){
          l = m+1;
          continue;
        }
        r = m-1;
      }

    l = 0;
    r = A.size()-1;
    m = -1;
    while(l <= r){
      m = (r+l)>>1;
      int middleVal = A.get(m);
      if(middleVal == B && (m==A.size()-1 || A.get(m+1)!= middleVal)){
        result.set(1,m);
        break;
      }

      if(middleVal == B){
        l = m+1;
        continue;
      }


      if(middleVal < B){
        l = m+1;
        continue;
      }
      r = m-1;
    }

    return result;
  }
}
