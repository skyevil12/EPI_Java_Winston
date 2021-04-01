package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class IntersectSortedArrays {
  @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    List<Integer> rtList = new ArrayList<>();
    if(A.size() > B.size()) {
      return intersectTwoSortedArrays(B, A);
    }

    //T O(min(A, B) log max(A, B)), could be the option when A is quite smaller than B
    for(int i = 0; i < A.size(); i++) {
      int vA = A.get(i);
      if(Collections.binarySearch(B, vA) >= 0 && (rtList.isEmpty() || vA > rtList.get(rtList.size() - 1))) {
        rtList.add(vA);
      }
    }

    return rtList;

//    List<Integer> rtList = new ArrayList<>();
//    int iA = 0, iB = 0, lenA = A.size(), lenB = B.size();
//    //T O(A + B) S O(1) except output space
//    while(iA < lenA && iB < lenB) {
//      int vA = A.get(iA), vB = B.get(iB);
//      if(vA < vB) {
//        iA++;
//      } else if(vA > vB) {
//        iB++;
//      } else {
//        if(rtList.isEmpty() || rtList.get(rtList.size() - 1) < vA) {
//          rtList.add(vA);
//        }
//        iA++;
//        iB++;
//      }
//    }
//
//    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
