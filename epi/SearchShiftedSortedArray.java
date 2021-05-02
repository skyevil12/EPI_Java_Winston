package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchShiftedSortedArray {
  @EpiTest(testDataFile = "search_shifted_sorted_array.tsv")

  //Variant2 - Leetcode #81(https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

  public static int searchSmallest(List<Integer> A) {
//    /*
//      378 478 550 631 103 203 220 234 279 368
//      l 0 3 4
//      r 9 4
//      m 4 2 3
//      T O(logN) S O(1)
//     */
//    int len = A.size(), l = 0, r = len - 1;
//    while(l < r) {
//      int m = l + (r - l) / 2;
//      int cur = A.get(m);
//      if(cur < A.get(r)) {
//        r = m;
//      } else {
//        l = m + 1;
//      }
//    }
//    return l;
      return new epi.kt.SearchShiftedSortedArray().searchSmallest(A);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchShiftedSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
