package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class SmallestSubarrayCoveringAllValues {

  public static class Subarray {
    // Represent subarray by starting and ending indices, inclusive.
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
      this.start = start;
      this.end = end;
    }
  }

  public static Subarray
  findSmallestSequentiallyCoveringSubset(List<String> paragraph,
                                         List<String> keywords) {
//    Subarray rt = new Subarray(0, paragraph.size() - 1);
//    int left = 0, len = paragraph.size();
//    int keyIdx = 0;
//    for(int i = 0; i < len; i++) {
//      String word = paragraph.get(i);
//      if(keywords.get(keyIdx).equals(word)) {
//        if(keyIdx == 0) {
//          left = i;
//        } else if(keyIdx == keywords.size() - 1) {
//          if(i - left < rt.end - rt.start) {
//            rt.start = left;
//            rt.end = i;
//          }
//        }
//        keyIdx++;
//      }
//    }
    return new Subarray(-1, -1);
  }
  @EpiTest(testDataFile = "smallest_subarray_covering_all_values.tsv")
  public static int findSmallestSequentiallyCoveringSubsetWrapper(
      TimedExecutor executor, List<String> paragraph, List<String> keywords)
      throws Exception {
    Subarray result = executor.run(
        () -> findSmallestSequentiallyCoveringSubset(paragraph, keywords));

    int kwIdx = 0;
    if (result.start < 0) {
      throw new TestFailure("Subarray start index is negative");
    }
    int paraIdx = result.start;

    while (kwIdx < keywords.size()) {
      if (paraIdx >= paragraph.size()) {
        throw new TestFailure("Not all keywords are in the generated subarray");
      }
      if (paraIdx >= paragraph.size()) {
        throw new TestFailure("Subarray end index exceeds array size");
      }
      if (paragraph.get(paraIdx).equals(keywords.get(kwIdx))) {
        kwIdx++;
      }
      paraIdx++;
    }
    return result.end - result.start + 1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SmallestSubarrayCoveringAllValues.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
