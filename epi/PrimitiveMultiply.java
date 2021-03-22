package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveMultiply {
  @EpiTest(testDataFile = "primitive_multiply.tsv")
  public static long multiply(long x, long y) {
//    if(x == 0 || y == 0) {
//      return 0;
//    }
//
//    long rt = 0;
//
//    while(x != 0) {
//      if((x & 1) != 0) {
//        rt = add(rt, y);
//      }
//
//      x >>>= 1;
//      y <<= 1;
//    }
//
//    return rt;
    return epi.kt.PrimitiveMultiply.INSTANCE.multiply(x, y);
  }

  private static long add(long x, long y) {
    long k = 1, sum = 0;
    long carryIn = 0;
    long tX = x,tY = y;

    while(tX > 0 || tY > 0) {
      int kX = (int) (x & k), kY = (int) (y & k);
      long carryOut = (kX & kY) | (kX & carryIn) | (kY & carryIn);
      sum |= (kX ^ kY ^ carryIn);
      carryIn = carryOut << 1;
      k <<= 1;
      tX >>>= 1;
      tY >>>= 1;
    }

    return sum | carryIn;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
