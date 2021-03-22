package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
//    /*
//      3 3 1 0 2 0 1
//
//      3 2 0 0 2 0 1
//     */
//    //T O(N)  S O(1)
//    int len = maxAdvanceSteps.size(), min = len - 1;
//
//    for(int i = len - 2; i >= 0; i--) {
//      if(maxAdvanceSteps.get(i) + i - min >= 0) {
//        min = i;
//      }
//    }
//
//    return min == 0;
    return epi.kt.AdvanceByOffsets.INSTANCE.canReachEnd(maxAdvanceSteps);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AdvanceByOffsets.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
