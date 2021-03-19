package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "reverse_digits.tsv")
  public static long reverse(int x) {
    //T O(N) S O(N)
    long lX = x;
    if(lX < 0) {
      lX *= -1;
    }
    StringBuilder xStrSb = new StringBuilder(String.valueOf(lX));
    return x < 0 ? -1 * Long.parseLong(xStrSb.reverse().toString()) : Long.parseLong(xStrSb.reverse().toString());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
