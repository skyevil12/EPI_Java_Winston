package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DutchNationalFlag {
  public enum Color { RED, WHITE, BLUE }

  public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
    /*Color sample = A.get(pivotIndex);
    int index = -1, end = A.size();

    for(int i = 0; i < A.size(); i++) {
      if(A.get(i).ordinal() < sample.ordinal()) {
        swap(A, i, ++index);
      }
    }

    index++;

    for(int i = A.size() - 1; i >= index; i--) {
      if (A.get(i).ordinal() > sample.ordinal()) {
        swap(A, i, --end);
      }
    }

    return;*/
    Color pivot = A.get(pivotIndex);
    int bottom = -1, equal = 0, top = A.size();

    while(equal < top) {
      if(A.get(equal).ordinal() < pivot.ordinal()) {
        Collections.swap(A, equal++, ++bottom);
      } else if(A.get(equal).ordinal() == pivot.ordinal()) {
        equal++;
      } else {
        Collections.swap(A, equal, --top);
      }
    }
  }

  private static void swap(List<Color> A, int i, int j) {
    Color tmp = A.get(j);
    A.set(j, A.get(i));
    A.set(i, tmp);
  }

  @EpiTest(testDataFile = "dutch_national_flag.tsv")
  public static void dutchFlagPartitionWrapper(TimedExecutor executor,
                                               List<Integer> A, int pivotIdx)
      throws Exception {
    List<Color> colors = new ArrayList<>();
    int[] count = new int[3];

    Color[] C = Color.values();
    for (int i = 0; i < A.size(); i++) {
      count[A.get(i)]++;
      colors.add(C[A.get(i)]);
    }

    Color pivot = colors.get(pivotIdx);
    executor.run(() -> dutchFlagPartition(pivotIdx, colors));

    int i = 0;
    while (i < colors.size() && colors.get(i).ordinal() < pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    while (i < colors.size() && colors.get(i).ordinal() == pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    while (i < colors.size() && colors.get(i).ordinal() > pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    if (i != colors.size()) {
      throw new TestFailure("Not partitioned after " + Integer.toString(i) +
                            "th element");
    } else if (count[0] != 0 || count[1] != 0 || count[2] != 0) {
      throw new TestFailure("Some elements are missing from original array");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DutchNationalFlag.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
