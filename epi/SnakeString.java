package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SnakeString {
  @EpiTest(testDataFile = "snake_string.tsv")

  public static String snakeString(String s) {
    //T O(N) S O(N)
    StringBuilder rtSb = new StringBuilder();
    //start from 1 and step 4
    for(int i = 1; i < s.length(); i+=4) {
      rtSb.append(s.charAt(i));
    }

    //start from 0 and step 2
    for(int i = 0; i < s.length(); i+=2) {
      rtSb.append(s.charAt(i));
    }

    //start from 3 and step 4
    for(int i = 3; i < s.length(); i+=4) {
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
