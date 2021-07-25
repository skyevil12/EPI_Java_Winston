package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class TwoSortedArraysMerge {

  public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                          List<Integer> B, int n) {
    /*
      A (5,13,17, ) 7
      B (3,7,11,19) 4
     */
    int rtIdx = m + n - 1;

    int iA = m - 1, iB = n - 1;
    //T O(M + N) S O(1)
    while(iA >= 0 && iB >= 0) {
      if(A.get(iA) > B.get(iB)) {
        A.set(rtIdx, A.get(iA));
        rtIdx--;
        iA--;
      } else {
        A.set(rtIdx, B.get(iB));
        rtIdx--;
        iB--;
      }
    }

    while(iB >= 0) {
      A.set(rtIdx, B.get(iB));
      rtIdx--;
      iB--;
    }

    return;
  }
  @EpiTest(testDataFile = "two_sorted_arrays_merge.tsv")
  public static List<Integer>
  mergeTwoSortedArraysWrapper(List<Integer> A, int m, List<Integer> B, int n) {
    mergeTwoSortedArrays(A, m, B, n);
    return A;
  }

  public static void main(String[] args) {
    System.exit(
            GenericTest
                    .runFromAnnotations(args, "TwoSortedArraysMerge.java",
                            new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
