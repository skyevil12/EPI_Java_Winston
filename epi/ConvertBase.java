package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import javax.crypto.spec.ChaCha20ParameterSpec;

public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    //empty input or startWith negative/positive or input is "0"
    //N is input length, T O(N) S O(N)
    /*if(numAsString.isEmpty() || numAsString.equals("0")) {
      return numAsString;
    }

    StringBuilder rtSb = new StringBuilder();

    boolean isNeg = false;
    int st = 0;
    if(numAsString.charAt(st) == '+') {
      st++;
    } else if(numAsString.charAt(st) == '-') {
      isNeg = true;
      st++;
    }

    long tmp = 0;
    for(int i = st; i < numAsString.length(); i++) {
      char ch = numAsString.charAt(i);
      tmp = tmp * b1 + chToInt(ch);
    }

    while(tmp > 0) {
      rtSb.append(numToChar((int) (tmp % b2)));
      tmp /= b2;
    }

    if(isNeg) {
      rtSb.append('-');
    }

    return rtSb.reverse().toString();*/
    return epi.kt.ConvertBase.INSTANCE.convertBase(numAsString, b1, b2);
  }

  private static int chToInt(char ch) {
    if(Character.isDigit(ch)) {
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
