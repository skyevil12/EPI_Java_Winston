package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class LongestContainedInterval {
  @EpiTest(testDataFile = "longest_contained_interval.tsv")

  public static int longestContainedRange(List<Integer> A) {
    /*
      (3,-2,7,9,8,1,2,0,-1,5,8)
      3, -2, 7, 9, 8, 1, 2, 0, -1, 5
      T O(N) S O(N)
     */
    Map<Integer, Boolean> map = new HashMap<>();
    for(int cur : A) {
      map.put(cur, true);
    }
    int rt = 0;
    for(int cur : map.keySet()) {
      if(map.get(cur) == null) {
        continue;
      }
      int lCur = cur, lRt = 1;
      map.put(lCur, null);
      while(map.get(lCur + 1) != null) {
        lRt++;
        lCur++;
        map.put(lCur, null);
      }
      lCur = cur;
      while(map.get(lCur - 1) != null) {
        lRt++;
        lCur--;
        map.put(lCur, null);
      }

      rt = Math.max(rt, lRt);
    }

    return rt;
    /*
      //FIXME #202 TC runtime too much
    Set<Integer> set = new HashSet<>(A);
    int rt = 0;
    while(!set.isEmpty()) {
      int cur = set.iterator().next();
      set.remove(cur);
      int lRt = 1, lCur = cur;
      while(set.contains(lCur + 1)) {
        lRt++;
        lCur++;
        set.remove(lCur);
      }

      lCur = cur;
      while(set.contains(lCur - 1)) {
        lRt++;
        lCur--;
        set.remove(lCur);
      }

      rt = Math.max(lRt, rt);
    }

    return rt;
     */
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestContainedInterval.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
