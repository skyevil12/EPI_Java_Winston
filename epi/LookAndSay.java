package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")

  public static String lookAndSay(int n) {
//    if(n <= 0) {
//      return "";
//    }
    /*
      <1,11, 21,1211,111221,312211,13112221,1113213211>
      n 4
      rt    "1" "11"  "21"  "1211"
      tmpSb ""  "11"  ""  "21"  ""  "1211"  ""
      ch    '1' '2' '1'
      cnt   2 1 1
      i     4
      j     0
      next  '1'
     */
//    String rt = "1";
//    StringBuilder tmpSb = new StringBuilder();
//    //T O(N * 2^N) S O(2N)
//    for(int i = 1; i < n; i++) {
//      char ch = rt.charAt(0);
//      int cnt = 1;
//      for(int j = 0; j < rt.length() - 1; j++) {
//        char next = rt.charAt(j + 1);
//        if(ch == next) {
//          cnt++;
//        } else {
//          tmpSb.append(cnt).append(ch);
//          ch = next;
//          cnt = 1;
//        }
//      }
//      tmpSb.append(cnt).append(ch);
//      rt = tmpSb.toString();
//      tmpSb.setLength(0);
//    }
//
//    return rt;
    return epi.kt.LookAndSay.INSTANCE.lookAndSay(n);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
