package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class LongestContainedInterval {
  @EpiTest(testDataFile = "longest_contained_interval.tsv")

  public static int longestContainedRange(List<Integer> A) {
    //Brute force T O(NlogN)  S O(N)
//    List<Integer> uA = new ArrayList<>(new HashSet<>(A));
//    if(uA.size() <= 1) {
//      return uA.size();
//    }
//    Collections.sort(uA);
//    int rt = 0, len = uA.size();
//    for(int i = 1; i < len; i++) {
//      int lRt = 1;
//      while(i < len && uA.get(i) - uA.get(i - 1) == 1) {
//        lRt += 1;
//        i++;
//      }
//      rt = Math.max(rt, lRt);
//    }
//    return rt;

    //Better T O(N) S O(N)
        /*
    3,-2,7,9,8,1,2,0,-1,5,8
     */
    Map<Integer, Integer> valIdx = new HashMap<>();
    for(int i = 0; i < A.size(); i++) {
      valIdx.put(A.get(i), i);
    }

    int rt = 0;
    for(int val : valIdx.keySet()) {
      if(valIdx.get(val) == null) {
        continue;
      }
      int lRt = 0;
      int nVal = val;
      while(valIdx.get(nVal) != null) {
        valIdx.put(nVal, null);
        nVal++;
        lRt++;
      }
      nVal = val - 1;
      while(valIdx.get(nVal) != null) {
        valIdx.put(nVal, null);
        nVal--;
        lRt++;
      }
      rt = Math.max(rt, lRt);
    }

    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestContainedInterval.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
