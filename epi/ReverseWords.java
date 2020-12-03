package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class ReverseWords {

  public static void reverseWords(char[] input) {
    /*reverse(input, 0, input.length - 1);

    int st = 0, end = -1;
    while((end = find(input, st, ' ')) != -1) {
      reverse(input, st, end - 1);
      st = end + 1;
    }*/
    //Edge case empty input or 1 char, could change the input cuz, should not trim the tail or heading space
    //T O(N) S O(1)
    //Two pass solution, reverse all then reverse individually
    //Split input by space,
    /*int len = input.length;
    reverse(input, 0, len - 1);
    // ad bg cf

    int lSt = 0, lEd = -1;
    while((lEd = find(input, lSt, ' ')) != -1) {
      reverse(input, lSt, lEd - 1);
      lSt = lEd + 1;
    }*/
    epi.kt.ReverseWords.INSTANCE.reverseWords(input);
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
