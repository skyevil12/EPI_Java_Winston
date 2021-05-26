package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    Map<Character, Integer> letMap = new HashMap();
    //T O(L + M) S O(distinct of L), it is better to construct letter map because this should be smaller than magazine
    for(char ch : letterText.toCharArray()) {
      letMap.put(ch, letMap.getOrDefault(ch, 0) + 1);
    }

    for(char ch : magazineText.toCharArray()) {
      if(!letMap.containsKey(ch)) {
        continue;
      }

      int cnt = letMap.get(ch);
      if(cnt == 1) {
        letMap.remove(ch);
      } else {
        letMap.put(ch, cnt - 1);
      }
    }

    return letMap.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
