package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseBits {
  private static final int SIZE = 16;
  private static final int MASK = 0xFFFF;
  private static long precomputedReverse[] = new long[1 << SIZE];

  static {
    for(int i = 0; i < (1 << SIZE); i++) {
      precomputedReverse[i] = swapBits(i, SIZE);
    }
  }

  @EpiTest(testDataFile = "reverse_bits.tsv")
  public static long reverseBits(long x) {
    return precomputedReverse[(int) (x >> (3 * SIZE))] | (precomputedReverse[(int) ((x >> (2 * SIZE)) & MASK)] << SIZE) | (precomputedReverse[(int) ((x >> SIZE) & MASK)] << (2 * SIZE)) | (precomputedReverse[(int) (x & MASK)] << (3 * SIZE));
  }

  private static long swapBits(long x, int j) {
    long rt = x;
    for(int i = 0; i < j / 2; i++) {
      //Must do this, because ^ not work if same two bit values
      if((rt >> i & 1) == (rt >> (j - 1 - i) & 1)) {
        continue;
      }
      rt ^= ((1L << i) | (1L << (j - 1 - i)));
    }
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
