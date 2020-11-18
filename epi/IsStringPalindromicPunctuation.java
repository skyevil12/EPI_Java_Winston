package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPalindromicPunctuation {
  @EpiTest(testDataFile = "is_string_palindromic_punctuation.tsv")

  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int i = 0, j = s.length() - 1;

    while(i < j) {
      char head = s.charAt(i);
      if(!isAlphaNumeric(head)) {
        i++;
        continue;
      }

      char tail = s.charAt(j);
      if(!isAlphaNumeric(tail)) {
        j--;
        continue;
      }

      if(head != tail) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  private static boolean isAlphaNumeric(char ch) {
    if((ch >= '0' && ch <= '9')
    || (ch >= 'a' && ch <= 'z')
    || (ch >= 'A' && ch <= 'Z')) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPalindromicPunctuation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
