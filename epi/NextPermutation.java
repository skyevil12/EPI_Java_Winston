package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class NextPermutation {
  @EpiTest(testDataFile = "next_permutation.tsv")
  public static List<Integer> nextPermutation(List<Integer> perm) {
    //get the first decreasing num from tail and swap the first
    //T O(N) S O(1)
    int len = perm.size(), pivot = -1;

    for(int i = len - 1; i >= 1; i--) {
      int cur = perm.get(i), next = perm.get(i - 1);
      if(cur > next) {
        pivot = i - 1;
        break;
      }
    }

    if(pivot == -1) {
      return new ArrayList<>();
    }

    int swapIdx = 0;
    for(int i = len - 1; i >= 0; i--) {
      if(perm.get(i) > perm.get(pivot)) {
        swapIdx = i;
        break;
      }
    }

    Collections.swap(perm, pivot, swapIdx);
    revert(perm, pivot + 1, len - 1);
    return perm;
  }

  private static void revert(List<Integer> perm, int st, int ed) {
    while(st < ed) {
      Collections.swap(perm, st++, ed--);
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NextPermutation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
