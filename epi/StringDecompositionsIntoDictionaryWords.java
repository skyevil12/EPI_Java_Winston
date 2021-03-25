package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class StringDecompositionsIntoDictionaryWords {
  @EpiTest(testDataFile = "string_decompositions_into_dictionary_words.tsv")

  public static List<Integer> findAllSubstrings(String s, List<String> words) {
    List<Integer> rtList = new ArrayList<>();
    /*
    "amanaplanacanal"
    "can","apl","ana"
     */
    if(words.isEmpty()) {
      return rtList;
    }
    int uLen = words.get(0).length();
    int wLen = uLen * words.size();
    Map<String, Integer> map = new HashMap<>();
    for(String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for(int i = 0; i + wLen - 1 < s.length(); i++) {
      if(match(s.substring(i, i + wLen), uLen, map)) {
        rtList.add(i);
      }
    }
    return rtList;
  }

  private static boolean match(String str, int uLen, Map<String, Integer> map) {
    Map<String, Integer> lMap = new HashMap<>();
    for(String key : map.keySet()) {
      lMap.put(key, map.get(key));
    }

    for(int i = 0; i < str.length(); i += uLen) {
      String cur = str.substring(i, i + uLen);
      if(lMap.get(cur) == null) {
        return false;
      } else {
        int cnt = lMap.get(cur);
        if(cnt == 1) {
          lMap.remove(cur);
        } else {
          lMap.put(cur, cnt - 1);
        }
      }
    }

    return lMap.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, "StringDecompositionsIntoDictionaryWords.java",
                        new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
