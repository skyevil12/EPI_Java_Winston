package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    if(numAsString.equals("0") || numAsString.isEmpty()) {
      return numAsString;
    }

    int idx = 0;
    boolean isNeg = false;

    if(numAsString.charAt(idx) == '-') {
      isNeg = true;
      idx++;
    } else if(numAsString.charAt(idx) == '+') {
      idx++;
    }

    long rt = 0;
    for(int i = idx; i < numAsString.length(); i++) {
      char ch = numAsString.charAt(i);
      rt *= b1;
      rt += charToNum(ch);
    }

    StringBuilder rtSb = new StringBuilder();

    while(rt > 0) {
      long mod = rt % b2;
      rtSb.insert(0, numToChar((int) mod));
      rt /= b2;
    }

    if(isNeg) {
      rtSb.insert(0, '-');
    }

    return rtSb.toString();
  }

  private static int charToNum(char ch) {
    if(ch >= '0' && ch <= '9') {
      return ch - '0';
    } else {
      return ch - 'A' + 10;
    }
  }

  private static char numToChar(int num) {
    if(num >= 10) {
      return (char) ((num - 10) + 'A');
    } else {
      return (char) (num - 0 + '0');
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
