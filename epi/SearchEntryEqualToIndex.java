package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.List;
public class SearchEntryEqualToIndex {

  //T O(logN) S O(1)
  public static int searchEntryEqualToItsIndex(List<Integer> A) {
    int len = A.size(), l = 0, r = len - 1;
    /*
      [-5, -3, -2, -1, 1, 2, 3, 4, 6, 8, 9, 11]
      l 0   6 9 11
      r 11
      m 5   8 10
     */
    while(l <= r) {
      int m = l + (r - l) / 2;
      int cur = A.get(m);
      if(cur == m) {
        return m;
      } else if(cur < m) {
        l = m + 1;
      } else {
        //cur > m
        r = m - 1;
      }
    }
    return -1;
  }
  @EpiTest(testDataFile = "search_entry_equal_to_index.tsv")
  public static void searchEntryEqualToItsIndexWrapper(TimedExecutor executor,
                                                       List<Integer> A)
      throws Exception {
    int result = executor.run(() -> searchEntryEqualToItsIndex(A));

    if (result != -1) {
      if (A.get(result) != result) {
        throw new TestFailure("Entry does not equal to its index");
      }
    } else {
      for (int i = 0; i < A.size(); ++i) {
        if (A.get(i) == i) {
          throw new TestFailure("There are entries which equal to its index");
        }
      }
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchEntryEqualToIndex.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
