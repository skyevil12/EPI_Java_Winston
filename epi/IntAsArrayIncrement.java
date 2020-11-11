package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    boolean isAdd = true;
    int end = A.size() - 1;

    while(isAdd && end >= 0) {
      int tmp = A.get(end) + 1;
      A.set(end, tmp % 10);
      isAdd = tmp > 9;
      end--;
    }

    if(isAdd) {
      A.add(0, 1);
    }

    return A;
  }

  //Variant Leetcode 415, 67

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
