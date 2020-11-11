package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class ReverseWords {

  public static void reverseWords(char[] input) {
    reverse(input, 0, input.length - 1);

    int st = 0, end = -1;
    while((end = find(input, st, ' ')) != -1) {
      reverse(input, st, end - 1);
      st = end + 1;
    }
  }

  private static void reverse(char[] input, int l, int r) {
    while(l < r) {
      char tmp = input[l];
      input[l] = input[r];
      input[r] = tmp;
      l++;
      r--;
    }
    return;
  }

  private static int find(char[] input, int st, char target) {
    if(st >= input.length) {
      return -1;
    }

    for(int i = st; i < input.length; i++) {
      if(input[i] == target) {
        return i;
      }
    }

    return input.length;
  }

  @EpiTest(testDataFile = "reverse_words.tsv")
  public static String reverseWordsWrapper(TimedExecutor executor, String s)
      throws Exception {
    char[] sCopy = s.toCharArray();

    executor.run(() -> reverseWords(sCopy));

    return String.valueOf(sCopy);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseWords.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
