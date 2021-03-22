package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {
//    //T O(log10 X) S O(1)
//    boolean isNeg = x < 0;
//    long lX = x;
//    if(isNeg) {
//      lX *= -1;
//    }
//
//    long rt = 0;
//    while(lX > 0) {
//      rt = rt * 10 + lX % 10;
//      lX /= 10;
//    }
//
//    return isNeg ? -rt : rt;
    return epi.kt.ReverseDigits.INSTANCE.reverse(x);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
