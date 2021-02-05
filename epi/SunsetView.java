package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class SunsetView {
  public static List<Integer>
  examineBuildingsWithSunset(Iterator<Integer> sequence) {
    //T O(N) worst case still S O(N) but in best case would be S O(1)
    //Min stack
    Deque<int[]> dq = new ArrayDeque<>();
    int i = 0;
    while(sequence.hasNext()) {
      int cur = sequence.next();

      while(!dq.isEmpty() && cur >= dq.peekFirst()[1]) {
        dq.pollFirst();
      }

      dq.offerFirst(new int[]{i++, cur});
    }

    List<Integer> rtList = new ArrayList<>();
    while(!dq.isEmpty()) {
      rtList.add(dq.pollFirst()[0]);
    }
    return rtList;
  }
  @EpiTest(testDataFile = "sunset_view.tsv")
  public static List<Integer>
  examineBuildingsWithSunsetWrapper(List<Integer> sequence) {
    return examineBuildingsWithSunset(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SunsetView.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
