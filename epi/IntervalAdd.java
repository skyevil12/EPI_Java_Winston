package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class IntervalAdd {
  @EpiUserType(ctorParams = {int.class, int.class})

  public static class Interval {
    public int left, right;

    public Interval(int l, int r) {
      this.left = l;
      this.right = r;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Interval interval = (Interval)o;

      if (left != interval.left) {
        return false;
      }
      return right == interval.right;
    }

    @Override
    public String toString() {
      return "[" + left + ", " + right + "]";
    }
  }

  @EpiTest(testDataFile = "interval_add.tsv")

  public static List<Interval> addInterval(List<Interval> disjointIntervals,
                                           Interval newInterval) {
    //T O(NlogN)  S O(N)
    disjointIntervals.add(newInterval);
    Collections.sort(disjointIntervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        if(o1.left == o2.left) {
          return o1.right - o2.right;
        }
        return o1.left - o2.left;
      }
    });

    List<Interval> rtList = new ArrayList<>();
    for(Interval e : disjointIntervals) {
      if(!rtList.isEmpty() && rtList.get(rtList.size() - 1).right >= e.left) {
        Interval prev = rtList.get(rtList.size() - 1);
        prev.left = Math.min(e.left, prev.left);
        prev.right = Math.max(e.right, prev.right);
      } else {
        rtList.add(e);
      }
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntervalAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
