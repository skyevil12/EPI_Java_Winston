package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubarrayWithDistinctValues {
  @EpiTest(testDataFile = "longest_subarray_with_distinct_values.tsv")

  public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
    /*
    f s f e t w e n w e
    s f e t w
    len     10
    rt      0 2 5
    left    0 1 4 6 7
    valIdx  e, 9  w, 8  n, 7

    T O(N) S O(N)
     */
    int rt = 0, left = 0, len = A.size();
    Map<Integer, Integer> valIdx = new HashMap<>();

    for(int i = 0; i < len; i++) {
      int cur = A.get(i);

      if(valIdx.get(cur) != null && valIdx.get(cur) >= left) {
        rt = Math.max(rt, i - 1 - left + 1);
        left = valIdx.get(cur) + 1;
      }
      valIdx.put(cur, i);
    }
    rt = Math.max(rt, len - 1 - left + 1);
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestSubarrayWithDistinctValues.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
