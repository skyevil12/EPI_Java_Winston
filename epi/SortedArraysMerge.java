package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class SortedArraysMerge {
  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    /*
      (3,5,7), (0,6), and (0,6, 28)
     */
//    Queue<Queue<Integer>> sorted = new PriorityQueue<>(new Comparator<Queue<Integer>>() {
//      @Override
//      public int compare(Queue<Integer> o1, Queue<Integer> o2) {
//        return o1.peek() - o2.peek();
//      }
//    });
//
//    for(List<Integer> sortedArray : sortedArrays) {
//      Queue<Integer> queue = new ArrayDeque<>(sortedArray);
//      sorted.offer(queue);
//    }
//
//    List<Integer> rtList = new ArrayList<>();
//    while(!sorted.isEmpty()) {
//      Queue<Integer> minQ = sorted.poll();
//      rtList.add(minQ.poll());
//      if(!minQ.isEmpty()) {
//        sorted.offer(minQ);
//      }
//    }
//    return rtList;
      return epi.kt.SortedArraysMerge.INSTANCE.mergeSortedArrays(sortedArrays);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
