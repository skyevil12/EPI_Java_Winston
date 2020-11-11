package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ClosestIntSameWeight {
  @EpiTest(testDataFile = "closest_int_same_weight.tsv")
  public static long closestIntSameBitCount(long x) {
    //T O(1)
    /*long one = x & ~(x - 1), zero = ~x & (x + 1);
    if(one > zero) {
      return x ^ (one | one >> 1);
    } else {
      return x ^ (zero | zero >> 1);
    }*/

    //T O(N)
    for(int i = 0; i < 62; i++) {
      if(((x >> i) & 1) != ((x >> (i + 1)) & 1)) {
        long mask = (1 << i) | (1 << (i + 1));
        return x ^ mask;
      }
    }

    throw new RuntimeException("No answer!");
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ClosestIntSameWeight.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
