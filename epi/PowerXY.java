package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PowerXY {
  @EpiTest(testDataFile = "power_x_y.tsv")
  public static double power(double x, int y) {
//    int absY = Math.abs(y);
//
//    double rt = 1;
//    while(absY != 0) {
//      if((absY & 1) != 0) {
//        rt *= x;
//      }
//
//      x *= x;
//      absY >>>= 1;
//    }
//
//    return y < 0 ? 1 / rt : rt;
      return epi.kt.PowerXY.INSTANCE.power(x, y);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerXY.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
