package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  //T O(N) S O(C) C is distinct char in s
  public static boolean canFormPalindrome(String s) {
    int len = s.length();
    Map<Character, Integer> chCnt = new HashMap();

    for(char ch : s.toCharArray()) {
      chCnt.put(ch, chCnt.getOrDefault(ch, 0) + 1);
    }

    int oddCntMax = len % 2 == 0 ? 0 : 1;
    int oddCnt = 0;
    for(char key : chCnt.keySet()) {
      if(chCnt.get(key) % 2 != 0) {
        if(oddCnt < oddCntMax) {
          oddCnt++;
        } else {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
