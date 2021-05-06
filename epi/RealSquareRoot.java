package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class RealSquareRoot {
  @EpiTest(testDataFile = "real_square_root.tsv")
  //T O(log(x/tolerance)) S O(1)
  public static double squareRoot(double x) {
//    //x >= 1 case
//    double l = 1, r = x;
//    //x < 1 case
//    if(x < 1) {
//      l = x;
//      r = 1.0;
//    }
//
//    while (compare(l, r) == -1) {
//      double m = l + (r - l) * 0.5;
//      double sq = m * m;
//      if(compare(sq, x) == 1) {
//        r = m;
//      } else if(compare(sq, x) == -1) {
//        l = m;
//      } else {
//        return m;
//      }
//    }
//
//    return l;
    return epi.kt.RealSquareRoot.INSTANCE.squareRoot(x);
  }

  public static int compare(double a, double b) {
    double EPSILON = 0.000000000000001;
    double diff = (a - b) / b;
    return diff < -EPSILON ? -1 : diff > EPSILON ? 1 : 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RealSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
