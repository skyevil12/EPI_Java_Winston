package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CalendarRendering {
  @EpiUserType(ctorParams = {int.class, int.class})

  public static class Event {
    public int start, finish;

    public Event(int start, int finish) {
      this.start = start;
      this.finish = finish;
    }
  }

  private static class Endpoint {
    public int time;
    public boolean isStart;

    Endpoint(int time, boolean isStart) {
      this.time = time;
      this.isStart = isStart;
    }
  }

  @EpiTest(testDataFile = "calendar_rendering.tsv")

  public static int findMaxSimultaneousEvents(List<Event> A) {
    //T O(NlogN)  S O(N)
    Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      }
    });

    for(Event e : A) {
      pq.offer(new int[]{e.start, 1});
      pq.offer(new int[]{e.finish + 1, -1});
    }

    int lSum = 0, rt = 0;

    while(!pq.isEmpty()) {
      lSum += pq.poll()[1];
      rt = Math.max(rt, lSum);
    }

    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CalendarRendering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
