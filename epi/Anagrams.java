package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.*;
import java.util.function.BiPredicate;
public class Anagrams {
  @EpiTest(testDataFile = "anagrams.tsv")

  public static List<List<String>> findAnagrams(List<String> dictionary) {
    //suppose size is N, T O(NMlogM)
    Map<String, List<String>> map = new HashMap<>();
    for(String  str : dictionary) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if(!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(str);
    }

    List<List<String>> rtList = new ArrayList<>();
    for(List<String> list : map.values()) {
      if(list.size() > 1) {
        rtList.add(list);
      }
    }
    return rtList;
  }
  @EpiTestComparator
  public static boolean comp(List<List<String>> expected,
                             List<List<String>> result) {
    if (result == null) {
      return false;
    }
    for (List<String> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<String> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Anagrams.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
