package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.BitSet;
import java.util.List;
public class AbsentValueArray {
  private static final int BUCKET_DIGIT = 16;//Cannot be < 2 or > 29
  private static final int REMAIN_DIGIT = 32 - BUCKET_DIGIT;
  private static final int NUM_BUCKET = 1 << BUCKET_DIGIT;
  private static final int NUM_REMAIN = 1 << REMAIN_DIGIT;

  public static int findMissingElement(Iterable<Integer> stream) {
    int[] buckets = new int[NUM_BUCKET];

    for(int num : stream) {
      buckets[num >>> REMAIN_DIGIT]++;
    }

    for(int i = 0; i < buckets.length; i++) {
      if(buckets[i] < NUM_REMAIN) {
        BitSet bitVec = new BitSet(NUM_REMAIN);
        for(int num : stream) {
          if(num >>> REMAIN_DIGIT == i) {
            bitVec.set((NUM_REMAIN - 1) & num);
          }
        }

        for(int j = 0; j < NUM_REMAIN; j++) {
          if(!bitVec.get(j)) {
            return (i << BUCKET_DIGIT) | j;
          }
        }
      }
    }

    throw new IllegalArgumentException("No missing ip address!!");
  }
  @EpiTest(testDataFile = "absent_value_array.tsv")
  public static void findMissingElementWrapper(List<Integer> stream)
      throws Exception {
    try {
      int res = findMissingElement(stream);
      if (stream.stream().filter(a -> a.equals(res)).findFirst().isPresent()) {
        throw new TestFailure(String.valueOf(res) + " appears in stream");
      }
    } catch (IllegalArgumentException e) {
      throw new TestFailure("Unexpected no missing element exception");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AbsentValueArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
