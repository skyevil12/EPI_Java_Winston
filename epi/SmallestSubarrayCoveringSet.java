package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class SmallestSubarrayCoveringSet {

  // Represent subarray by starting and ending indices, inclusive.
  private static class Subarray {
    public Integer start;
    public Integer end;

    public Subarray(Integer start, Integer end) {
      this.start = start;
      this.end = end;
    }
  }

  private static Map.Entry<String, Integer> getFirstEntry(Map<String, Integer> keyIdx) {
    Map.Entry<String, Integer> rt = null;
    for(Map.Entry entry : keyIdx.entrySet()) {
      rt = entry;
      break;
    }
    return rt;
  }

  public static Subarray findSmallestSubarrayCoveringSetIter(Iterator<String> iter, List<String> keywords) {
    Map<String, Integer> keyIdx = new LinkedHashMap<>();
    for (String key : keywords) {
      keyIdx.put(key, null);
    }
    Subarray rt = new Subarray(-1, -1);
    int keyCnt = 0;
    int right = 0;
    while (iter.hasNext()) {
      String cur = iter.next();
      if (keyIdx.containsKey(cur)) {
        if (keyIdx.get(cur) == null) {
          keyCnt++;
        }

        keyIdx.remove(cur);
        keyIdx.put(cur, right);
      }

      if (keyCnt == keywords.size() && ((rt.start == -1 && rt.end == -1)
              || (right - getFirstEntry(keyIdx).getValue() < rt.end - rt.start))) {
        rt.start = getFirstEntry(keyIdx).getValue();
        rt.end = right;
      }

      right++;
    }

    return rt;
  }

  public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                         Set<String> keywords) {
//    Subarray rt = new Subarray(0, Integer.MAX_VALUE - 1);
//    Map<String, Integer> strCnt = new HashMap();
//    int left = 0;
//
//    for(int i = 0; i < paragraph.size(); i++) {
//      String cur = paragraph.get(i);
//      if(keywords.contains(cur)) {
//        strCnt.put(cur, strCnt.getOrDefault(cur, 0) + 1);
//      }
//      /*
//      My paramount object in this struggle is to save the Union,
//      T O(P)  S O(K)
//       */
//      while(strCnt.size() == keywords.size()) {
//        //Only update when found minimum
//        if(i - left + 1 < rt.end - rt.start + 1) {
//          rt.start = left;
//          rt.end = i;
//        }
//        String lStr = paragraph.get(left++);
//        if(strCnt.containsKey(lStr)) {
//          if(strCnt.get(lStr) == 1) {
//            strCnt.remove(lStr);
//          } else {
//            strCnt.put(lStr, strCnt.get(lStr) - 1);
//          }
//        }
//      }
//    }
//
//    return rt;

    return findSmallestSubarrayCoveringSetIter(paragraph.iterator(), new ArrayList<>(keywords));
  }
  @EpiTest(testDataFile = "smallest_subarray_covering_set.tsv")
  public static int findSmallestSubarrayCoveringSetWrapper(
      TimedExecutor executor, List<String> paragraph, Set<String> keywords)
      throws Exception {
    Set<String> copy = new HashSet<>(keywords);

    Subarray result = executor.run(
        () -> findSmallestSubarrayCoveringSet(paragraph, keywords));

    if (result.start < 0 || result.start >= paragraph.size() ||
        result.end < 0 || result.end >= paragraph.size() ||
        result.start > result.end)
      throw new TestFailure("Index out of range");

    for (int i = result.start; i <= result.end; i++) {
      copy.remove(paragraph.get(i));
    }

    if (!copy.isEmpty()) {
      throw new TestFailure("Not all keywords are in the range");
    }
    return result.end - result.start + 1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SmallestSubarrayCoveringSet.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
