package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {
  @EpiTest(testDataFile = "nearest_repeated_entries.tsv")

  public static int findNearestRepetition(List<String> paragraph) {
//    Map<String, Integer> strIdx = new HashMap<>();
//    int minDis = Integer.MAX_VALUE;
//    //T O(N)  S O(dis N)
//    for(int i = 0; i < paragraph.size(); i++) {
//      String str = paragraph.get(i);
//
//      if(strIdx.containsKey(str)) {
//        minDis = Math.min(minDis, i - strIdx.get(str));
//      }
//
//      strIdx.put(str, i);
//    }
//
//    return minDis == Integer.MAX_VALUE ? -1 : minDis;
    return epi.kt.NearestRepeatedEntries.INSTANCE.findNearestRepetition(paragraph);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NearestRepeatedEntries.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
