package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class TwoSortedArraysMerge {
  //T O(A + B)  S O(1)
  public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                          List<Integer> B, int n) {
    int iA = m - 1, iB = n - 1, idx = A.size() - 1;

    while(iA >= 0 && iB >= 0) {
      int vA = A.get(iA), vB = B.get(iB);
      if(vA >= vB) {
        A.set(idx--, vA);
        iA--;
      } else if(vB > vA) {
        A.set(idx--, vB);
        iB--;
      }
    }

    //This could be removed because iA should be equal to idx at this case
//    while(iA >= 0) {
//      int vA = A.get(iA);
//      A.set(idx--, vA);
//      iA--;
//    }

    while(iB >= 0) {
      int vB = B.get(iB);
      A.set(idx--, vB);
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
