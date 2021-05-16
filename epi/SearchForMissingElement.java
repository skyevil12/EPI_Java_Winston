package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class SearchForMissingElement {
  @EpiUserType(ctorParams = {Integer.class, Integer.class})

  public static class DuplicateAndMissing {
    public Integer duplicate;
    public Integer missing;

    public DuplicateAndMissing(Integer duplicate, Integer missing) {
      this.duplicate = duplicate;
      this.missing = missing;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      DuplicateAndMissing that = (DuplicateAndMissing)o;

      if (!duplicate.equals(that.duplicate)) {
        return false;
      }
      return missing.equals(that.missing);
    }

    @Override
    public int hashCode() {
      int result = duplicate.hashCode();
      result = 31 * result + missing.hashCode();
      return result;
    }

    @Override
    public String toString() {
      return "duplicate: " + duplicate + ", missing: " + missing;
    }
  }

  @EpiTest(testDataFile = "find_missing_and_duplicate.tsv")

  public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
    //T O(N) S O(1)
    int rt = 0;
    int n = A.size();
    //XOR all index and value to get miss ^ dup
    for(int i = 0; i < n; i++) {
      rt ^= i;
      rt ^= A.get(i);
    }

    //Know the least diff bit
    int rightDiff = rt &(~(rt - 1));

    //Find least diff bit valid num and XOR all of them
    int cand = 0;
    for(int i = 0; i < n; i++) {
      if((rightDiff & i) != 0) {
        cand ^= i;
      }

      if((rightDiff & A.get(i)) != 0) {
        cand ^= A.get(i);
      }
    }

    for(int i = 0; i < n; i++) {
      if(cand == A.get(i)) {
        return new DuplicateAndMissing(cand, rt ^ cand);
      }
    }

    return new DuplicateAndMissing(rt ^ cand, cand);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchForMissingElement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
