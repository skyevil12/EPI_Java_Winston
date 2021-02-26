package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchFirstKey {
  @EpiTest(testDataFile = "search_first_key.tsv")

  public static int searchFirstOfK(List<Integer> A, int k) {
    if(A == null || A.isEmpty()) {
      return -1;
    }
    int l = 0, r = A.size() - 1;
    /*
      l 0 3
      r 10  4 3
      m 5(243)  2(2)  3

      T O(logA) S O(1)
     */
    while(l < r) {
      int m = l + (r - l) / 2;
      int cur = A.get(m);
      if(cur == k) {
        r = m;
      } else if(cur > k) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }

    return A.get(l) == k ? l : -1;
  }

//  //Another style of BS
//  public static int searchFirstOfK(List<Integer> A, int k) {
//    int l = 0, r = A.size() - 1, rt = -1;
//
//    while(l <= r) {
//      int m = l + (r - l) / 2, cur = A.get(m);
//      if(cur == k) {
//        rt = m;
//        r = m - 1;
//      } else if(cur > k) {
//        r = m - 1;
//      } else {
//        l = m + 1;
//      }
//    }
//
//    return rt;
//  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
