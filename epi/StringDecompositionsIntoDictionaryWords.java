package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class StringDecompositionsIntoDictionaryWords {
  @EpiTest(testDataFile = "string_decompositions_into_dictionary_words.tsv")

  public static List<Integer> findAllSubstrings(String s, List<String> words) {
    int wLen = words.get(0).length();
    int len = words.size() * wLen;
    Map<String, Integer> wordCnt = new HashMap();
    for(String word : words) {
      wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
    }

    List<Integer> rtList = new ArrayList<>();
    for(int i = 0; i + len - 1 < s.length(); i++) {
      if(match(s.substring(i, i + len), wLen, wordCnt)) {
        rtList.add(i);
      }
    }

    return rtList;
  }

  private static boolean match(String str, int uLen, Map<String, Integer> map) {
    Map<String, Integer> lMap = new HashMap<>();
    for(String kStr : map.keySet()) {
      lMap.put(kStr, map.get(kStr));
    }

    for(int i = 0; i < str.length(); i += uLen) {
      String uStr = str.substring(i, i + uLen);
      if(lMap.get(uStr) == null) {
        return false;
      } else {
        if(lMap.get(uStr) == 1) {
          lMap.remove(uStr);
        } else {
          lMap.put(uStr, lMap.get(uStr) - 1);
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
