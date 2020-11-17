package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    if(x == 0) {
      return "0";
    }

    long lx = x;
    boolean isNeg = false;
    StringBuilder rtSb = new StringBuilder();
    //For Integer_MIN_VALUE to pos would be overflow
    if(lx < 0) {
      lx *= -1;
      isNeg = true;
    }

    while(lx > 0) {
      rtSb.append(lx % 10);
      lx /= 10;
    }

    if(isNeg) {
      rtSb.append('-');
    }

    return rtSb.reverse().toString();
  }
  public static int stringToInt(String s) {
    int rt = 0, idx = 0;
    if(s.isEmpty()) {
      return rt;
    }

    boolean isNeg = false;
    if(s.charAt(idx) == '-') {
      isNeg = true;
      idx++;
    } else if(s.charAt(idx) == '+') {
      idx++;
    }

    for(int i = idx; i < s.length(); i++) {
      char ch = s.charAt(i);
      rt *= 10;
      rt += (ch - '0');
    }

    return isNeg ? -rt : rt;
  }
  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (Integer.parseInt(intToString(x)) != x) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
