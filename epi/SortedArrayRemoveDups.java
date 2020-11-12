package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.List;
public class SortedArrayRemoveDups {
  // Returns the number of valid entries after deletion.
  public static int deleteDuplicates(List<Integer> A) {
    if(A.size() == 0) {
      return 0;
    }

    int rt = 1, len = A.size();
    for(int i = 1; i < len; i++) {
      int cur = A.get(i).intValue();
      if(cur != A.get(i - 1).intValue()) {
        rt++;
        A.set(rt - 1, cur);
      }
    }

    return rt;
  }

  private static void swap(List<Integer> A, int i, int j) {
    Integer tmp = A.get(j);
    A.set(j, A.get(i));
    A.set(i, tmp);
  }

  @EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
  public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor,
                                                      List<Integer> A)
      throws Exception {
    int end = executor.run(() -> deleteDuplicates(A));
    return A.subList(0, end);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArrayRemoveDups.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
