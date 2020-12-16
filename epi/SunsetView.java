package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class SunsetView {
  public static List<Integer>
  examineBuildingsWithSunset(Iterator<Integer> sequence) {
    //T O(N) worst case still S O(N) but in best case would be S O(1)
    Deque<int[]> stack = new ArrayDeque<>();
    int i = 0;
    while(sequence.hasNext()) {
      int cur = sequence.next();
      while(!stack.isEmpty() && stack.peek()[1] <= cur) {
        stack.pop();
      }

      stack.push(new int[]{i, cur});
      i++;
    }

    List<Integer> rtList = new ArrayList<>();
    while(!stack.isEmpty()) {
      rtList.add(stack.pop()[0]);
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
