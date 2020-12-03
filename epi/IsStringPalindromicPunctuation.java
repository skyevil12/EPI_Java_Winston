package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsStringPalindromicPunctuation {
  @EpiTest(testDataFile = "is_string_palindromic_punctuation.tsv")

  public static boolean isPalindrome(String s) {
    /*s = s.toLowerCase();
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

    return true;*/
    //Empty return true?, upper and Lower case mixed, if we only need to take care the alpha numeric
    //Is Case sensitive
    //T O(N) S O(1)
    /*int len = s.length(), left = 0, right = len - 1;

    while(left < right) {
      char lCh = s.charAt(left), rCh = s.charAt(right);
      if(!isAlphaNumeric(lCh)) {
        left++;
        continue;
      }

      if(!isAlphaNumeric(rCh)) {
        right--;
        continue;
      }

      if(lowerCase(lCh) != lowerCase(rCh)) {
        return false;
      }
      left++;
      right--;
    }

    return true;*/
    return epi.kt.IsStringPalindromicPunctuation.INSTANCE.isPalindrome(s);
  }

  private static char lowerCase(char ch) {
    if(ch >= 'A' && ch <= 'Z') {
      return (char) (ch - 'A' + 'a');
    } else {
      return ch;
    }
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
