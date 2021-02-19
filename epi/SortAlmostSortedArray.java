package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class SortAlmostSortedArray {

  public static List<Integer>
  sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    List<Integer> rtList = new ArrayList();
    Queue<Integer> pq = new PriorityQueue<>();

    /*
      3, -1, 2, 6, 4, 5, 8

      q       5, 6, 8
      rtList  -1, 2, 3, 4, 5
     */
    //T O(Nlogk)  S O(k) + output space O(N)
    while(sequence.hasNext()) {
      pq.offer(sequence.next());
      if(pq.size() == k + 1) {
        rtList.add(pq.poll());
      }
    }

    while(!pq.isEmpty()) {
      rtList.add(pq.poll());
    }

    return rtList;
  }
  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer>
  sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
