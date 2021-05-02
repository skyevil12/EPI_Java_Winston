package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntSquareRoot {
  @EpiTest(testDataFile = "int_square_root.tsv")

  public static int squareRoot(int k) {
//    long l = 0, r = k;
//    //T O(logK) S O(1)
//    /*
//      8
//      l   0 1 2
//      r   8 3
//      m   4 1 2 2
//     */
//    while(l < r) {
//      long m = l + (r - l) / 2;
//      long product = m * m;
//      if(product >= k) {
//        r = m;
//      } else {
//        l = m + 1;
//      }
//    }
//
//    if(l * l > k) {
//      return (int) (l - 1);
//    } else {
//      return (int) l;
//    }
      return epi.kt.IntSquareRoot.INSTANCE.squareRoot(k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntSquareRoot.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
