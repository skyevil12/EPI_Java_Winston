package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")

  //T O(n * 2^n) S O(2^n)
  public static String lookAndSay(int n) {
    StringBuilder rtSb = new StringBuilder();
    StringBuilder tmpSb = new StringBuilder();
    rtSb.append("1");
    for(int i = 1; i < n; i++) {
      int idx = 0, len = rtSb.length();
      tmpSb.setLength(0);
      while(idx < len) {
        int cnt = 0;
        char ch = rtSb.charAt(idx);
        while (idx < len && rtSb.charAt(idx) == ch) {
          cnt++;
          idx++;
        }
        tmpSb.append(cnt).append(ch);
      }
      rtSb.setLength(0);
      rtSb.append(tmpSb);
    }

    return rtSb.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
