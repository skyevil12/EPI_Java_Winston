package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.List;
public class SearchForMinMaxInArray {
  @EpiUserType(ctorParams = {Integer.class, Integer.class})

  public static class MinMax {
    public Integer smallest;
    public Integer largest;

    public MinMax(Integer smallest, Integer largest) {
      this.smallest = smallest;
      this.largest = largest;
    }

    private static MinMax minMax(Integer a, Integer b) {
      return Integer.compare(b, a) < 0 ? new MinMax(b, a) : new MinMax(a, b);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      MinMax minMax = (MinMax)o;

      if (!smallest.equals(minMax.smallest)) {
        return false;
      }
      return largest.equals(minMax.largest);
    }

    @Override
    public String toString() {
      return "min: " + smallest + ", max: " + largest;
    }
  }

  @EpiTest(testDataFile = "search_for_min_max_in_array.tsv")

  public static MinMax findMinMax(List<Integer> A) {
    int min = A.get(0), max = A.get(0);

    for(int i = 0; i < A.size() - 1; i+=2) {
      int cur = A.get(i), next = A.get(i + 1);
      if(cur > next) {
        max = Math.max(cur, max);
        min = Math.min(next, min);
      } else {
        min = Math.min(cur, min);
        max = Math.max(next, max);
      }
    }

    if(A.size() > 1 && A.size() % 2 != 0) {
      int cur = A.get(A.size() - 2), next = A.get(A.size() - 1);
      if(cur > next) {
        max = Math.max(cur, max);
        min = Math.min(next, min);
      } else {
        min = Math.min(cur, min);
        max = Math.max(next, max);
      }
    }
    return new MinMax(min, max);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchForMinMaxInArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
