package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;
public class KLargestInHeap {
  @EpiTest(testDataFile = "k_largest_in_heap.tsv")

  public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
//    //Supposed A is the flatten max heap, must output list without modifying the heap
//    List<Integer> rtList = new ArrayList<>(k);
//    Queue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        return o2[1] - o1[1];
//      }
//    });
//    //idx 0 is array heap index. index 1 is value of the array heap element
//    maxHeap.offer(new int[]{0, A.get(0)});
//
//    for(int i = 0; i < k; i++) {
//      int idx = maxHeap.peek()[0];
//      rtList.add(maxHeap.poll()[1]);
//
//      int l = 2 * idx + 1;
//      if(l < A.size()) {
//        maxHeap.offer(new int[]{l, A.get(l)});
//      }
//
//      int r = 2 * idx + 2;
//      if(r < A.size()) {
//        maxHeap.offer(new int[]{r, A.get(r)});
//      }
//    }
//
//    return rtList;
      return epi.kt.KLargestInHeap.INSTANCE.kLargestInBinaryHeap(A, k);
  }
  @EpiTestComparator
  public static boolean comp(List<Integer> expected, List<Integer> result) {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KLargestInHeap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
