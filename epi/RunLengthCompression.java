package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class RunLengthCompression {

  public static String decoding(String s) {
    StringBuilder rtSb = new StringBuilder();
    int len = s.length();
    /*3e4f
      len 4
       i  0 2
       sb 3e4f
    */
    for(int i = 0; i < len; i++) {
      int cnt = 0;
      while (i < s.length() && isNumeric(s.charAt(i))) {
        cnt *= 10;
        cnt += (s.charAt(i) - '0');
        i++;
      }

      char cur = s.charAt(i);
      for(int j = 0; j < cnt; j++) {
        rtSb.append(cur);
      }
    }

    return rtSb.toString();
  }

  private static boolean isNumeric(char ch) {
    return ch >= '0' && ch <= '9';
  }

  public static String encoding(String s) {
    //T O(N) S O(1) except output space
    StringBuilder rtSb = new StringBuilder();
    int cnt = 1, len = s.length();
    for(int i = 0; i < len - 1; i++) {
      char cur = s.charAt(i);
      if(cur == s.charAt(i + 1)) {
        cnt++;
        if(i == len - 2) {
          rtSb.append(cnt).append(cur);
        }
      } else {
        rtSb.append(cnt).append(cur);
        cnt = 1;
        if(i == len - 2) {
          rtSb.append(cnt).append(s.charAt(i + 1));
        }
      }
    }

    return rtSb.toString();
  }
  @EpiTest(testDataFile = "run_length_compression.tsv")
  public static void rleTester(String encoded, String decoded)
      throws TestFailure {
    if (!decoding(encoded).equals(decoded)) {
      throw new TestFailure("Decoding failed");
    }
    if (!encoding(decoded).equals(encoded)) {
      throw new TestFailure("Encoding failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RunLengthCompression.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
