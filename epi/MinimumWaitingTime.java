package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class MinimumWaitingTime {
  @EpiTest(testDataFile = "minimum_waiting_time.tsv")

  public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
    //T O(NlogN) S O(1)
    Collections.sort(serviceTimes);
    int rt = 0;
    //No need to wait the last execution, that is why the upper bound is size - 2
    for(int i = 0; i < serviceTimes.size() - 1; i++) {
        int waitCnt = serviceTimes.size() - (i + 1);
        rt += waitCnt * serviceTimes.get(i);
    }
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MinimumWaitingTime.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
