package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    //T O(L + M)  S O(distinct char in L)
    Map<Character, Integer> map = new HashMap<>();
    for(char ch : letterText.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for(char ch : magazineText.toCharArray()) {
      if(map.containsKey(ch)) {
        if(map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      }
    }

    return map.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
