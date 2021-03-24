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
    /* Leetcode 727
    apple banana cat apple

    banana apple
     */
    Subarray rt = new Subarray(0, paragraph.size() - 1);
    int len = paragraph.size(), kLen = keywords.size();
    //Brute force T O(N^2) S O(1)
    for(int i = 0; i < len; i++) {
      String word = paragraph.get(i);
      if(!word.equals(keywords.get(0))) {
        continue;
      }
      if(kLen == 1) {
        rt.start = i;
        rt.end = i;
        break;
      }
      int kIdx = 1;
      for(int j = i + 1; j < len; j++) {
        word = paragraph.get(j);
        if(word.equals(keywords.get(kIdx))) {
          if(kIdx == keywords.size() - 1) {
            if(j - i < rt.end - rt.start) {
              rt.start = i;
              rt.end = j;
            }
            break;
          }
          kIdx++;
        }
      }
    }

    return rt;
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
