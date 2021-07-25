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
    public int isStart;

    Endpoint(int time, int isStart) {
      this.time = time;
      this.isStart = isStart;
    }
  }

  @EpiTest(testDataFile = "calendar_rendering.tsv")

  public static int findMaxSimultaneousEvents(List<Event> A) {
    int lSum = 0, rt = 0;

    Queue<Endpoint> pq = new PriorityQueue<>(new Comparator<Endpoint>() {
      @Override
      public int compare(Endpoint o1, Endpoint o2) {
        if(o1.time != o2.time) {
          return o1.time - o2.time;
        }

        return o1.isStart - o2.isStart;
      }
    });

    for(Event e : A) {
      pq.offer(new Endpoint(e.start, 1));
      pq.offer(new Endpoint(e.finish + 1, -1));
    }

    while(!pq.isEmpty()) {
      lSum += pq.poll().isStart;
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
