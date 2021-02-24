package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class OnlineMedian {
  /*
    median
    odd cnt / 2
    even  avg(cnt / 2 , cnt / 2 - 1)
   */
  public static List<Double> onlineMedian(Iterator<Integer> sequence) {
//    //T O(logN) for each update, N would be the current total elements count / 2
//    Queue<Integer> minHeap = new PriorityQueue<>(), maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//    List<Double> rtList = new ArrayList<>();
//
//    while(sequence.hasNext()) {
//      int cur = sequence.next();
//
//      if(minHeap.isEmpty()) {
//        minHeap.offer(cur);
//      } else {
//        if(cur > minHeap.peek()) {
//          minHeap.offer(cur);
//        } else {
//          maxHeap.offer(cur);
//        }
//      }
//
//      if(minHeap.size() > maxHeap.size() + 1) {
//        maxHeap.offer(minHeap.poll());
//      } else if(maxHeap.size() > minHeap.size()) {
//        minHeap.offer(maxHeap.poll());
//      }
//
//      rtList.add(minHeap.size() == maxHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : minHeap.peek());
//    }
//
//    return rtList;
    return epi.kt.OnlineMedian.INSTANCE.onlineMedian(sequence);
  }
  @EpiTest(testDataFile = "online_median.tsv")
  public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
    return onlineMedian(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "OnlineMedian.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
