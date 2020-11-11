package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Parity {
  private static int[] sMap = new int[(int) (Math.pow(2, 16) + 1)];
  private static final int SHIFT = 16;
  private static final int MASK = 0xFFFF;

  static {
    Arrays.fill(sMap, -1);
  }

  @EpiTest(testDataFile = "parity.tsv")
  public static short parity(long x) {
//    x ^= x >> 32;
//    x ^= x >> 16;
//    x ^= x >> 8;
//    x ^= x >> 4;
//    x ^= x >> 2;
//    x ^= x >> 1;
    return (short) (precomputeParity((int) (x >> (SHIFT * 3)))
                ^ precomputeParity((int) (x >> (SHIFT * 2) & MASK))
                ^ precomputeParity((int) (x >> (SHIFT * 1) & MASK))
                ^ precomputeParity((int) (x & MASK)));
//    return (short) (x & 1);
  }

  private static short precomputeParity(int num) {
    short rt = 0;

    if(sMap[num] != -1) {
      return (short) sMap[num];
    }

    int ori = num;
    num ^= num >> 8;
    num ^= num >> 4;
    num ^= num >> 2;
    num ^= num >> 1;

    rt = (short) (num & 1);
    sMap[ori] = rt;
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
