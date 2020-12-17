package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class RunLengthCompression {
  /*
  "3e4f2e" returns "eeeffffee".
   */
  public static String decoding(String s) {
    StringBuilder rtSb = new StringBuilder();
    int len = s.length();

    for(int i = 0; i < len; i++) {
      int cnt = 0;
      while(isNumeric(s.charAt(i))) {
        cnt *= 10;
        cnt += s.charAt(i) - '0';
        i++;
      }

      for(int j = 0; j < cnt; j++) {
        rtSb.append(s.charAt(i));
      }
    }
    
    return rtSb.toString();
  }

  private static boolean isNumeric(char ch) {
    return ch >= '0' && ch <= '9';
  }

  /*
  "aaaabcccaa" is "4alb3c2a".
   */
  public static String encoding(String s) {
    StringBuilder rtSb = new StringBuilder();
    int len = s.length();

    for(int i = 0; i < len; i++) {
      int cnt = 1;
      char ch = s.charAt(i);
      while(i + 1 < len && s.charAt(i + 1) == ch) {
        cnt++;
        i++;
      }
      rtSb.append(cnt).append(ch);
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
