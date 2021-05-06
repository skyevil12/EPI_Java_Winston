package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchRowColSortedMatrix {
  @EpiTest(testDataFile = "search_row_col_sorted_matrix.tsv")

  public static boolean matrixSearch(List<List<Integer>> A, int x) {
//    //T O(M + N) S O(1)
//    int m = A.size(), n = A.get(0).size();
//    int r = m - 1, c = 0;
//
//    while(r >= 0 && c < n) {
//      int cur = A.get(r).get(c);
//      if(cur == x) {
//        return true;
//      } else if(cur > x) {
//        r--;
//      } else if(cur < x) {
//        c++;
//      }
//    }
//    return false;
    return epi.kt.SearchRowColSortedMatrix.INSTANCE.matrixSearch(A, x);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchRowColSortedMatrix.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
