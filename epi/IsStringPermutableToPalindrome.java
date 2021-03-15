package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  public static boolean canFormPalindrome(String s) {
    /*
      "edified" can be permuted to form "deified"

        T O(N) S O(C) C is the length of distinct character in s
     */
    Map<Character, Integer> chCnt = new HashMap<>();
    for(char ch : s.toCharArray()) {
      chCnt.put(ch, chCnt.getOrDefault(ch, 0) + 1);
    }

    //Should only have one odd at most
    boolean hasOdd = false;
    for(Integer cnt : chCnt.values()) {
      if(cnt % 2 != 0) {
        if(!hasOdd) {
          hasOdd = true;
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
