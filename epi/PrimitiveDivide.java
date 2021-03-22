package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PrimitiveDivide {
  @EpiTest(testDataFile = "primitive_divide.tsv")
  public static int divide(int x, int y) {
    if(x < y) {
      return 0;
    } else if(x == y) {
      return 1;
    } else if(y == 1) {
      return x;
    }
    /*
      x   64
      y   3
      rt  1 2 4   8   16
      lY  3 6 12  24  48
     */
    long rt = 1;
    long lY = y;
    //If lY is int, here would be overflow
    while(x >= lY << 1) {
      lY <<= 1;
      rt <<= 1;
    }

    //Because if rt is int, here would overflow
    while(x >= (rt + 1) * y) {
      rt++;
    }
    return (int) rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveDivide.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
