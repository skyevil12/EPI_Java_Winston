package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SnakeString {
  @EpiTest(testDataFile = "snake_string.tsv")
//T O(N) S O(N)
  public static String snakeString(String s) {
    int len = s.length();
    StringBuilder rtSb = new StringBuilder();
    for(int i = 1; i < len; i+=4) {
      rtSb.append(s.charAt(i));
    }

    for(int i = 0; i < len; i+=2) {
      rtSb.append(s.charAt(i));
    }

    for(int i = 3; i < len; i+=4) {
      rtSb.append(s.charAt(i));
    }

    return rtSb.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SnakeString.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
