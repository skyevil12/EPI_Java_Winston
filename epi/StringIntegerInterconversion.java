package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    //Edge case, consider the Integer.MIN_VALUE, use long instead
    //suppose digit len of x is N, T O(N) S O(N)
    /*if(x == 0) {
      return "0";
    }

    long lX = x;
    boolean isNeg = lX < 0;
    if(isNeg) {
      lX *= -1;
    }

    StringBuilder rtSb = new StringBuilder();
    while(lX > 0) {
      rtSb.append(lX % 10);
      lX /= 10;
    }

    if(isNeg) {
      rtSb.append('-');
    }

    return rtSb.reverse().toString();*/
    return epi.kt.StringIntegerInterconversion.INSTANCE.integerToString(x);
  }
  public static int stringToInt(String s) {
    //Exist the boundary case Integer.MIN String, overflow if I toggle it to positive, so use rt type long
    //Supposed s only prefix '+' or '-' and there is no space inside
    //T O(N) S O(1)
    /*int st = 0;
    if(s.isEmpty()) {
      return st;
    }
    boolean isNeg = false;
    if(!Character.isDigit(s.charAt(st))) {
      if(s.charAt(st) == '-') {
        isNeg = true;
      }
      st++;
    }

    long rt = 0;
    for(int i = st; i < s.length(); i++) {
      char ch = s.charAt(i);
      rt = rt * 10 + (ch - '0');
    }

    return (int) (isNeg ? -rt : rt);*/
    return epi.kt.StringIntegerInterconversion.INSTANCE.stringToInteger(s);
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
