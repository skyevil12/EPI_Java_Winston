package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class CollatzChecker {
  private static Map<Integer, Boolean> cache = new HashMap<>();

  @EpiTest(testDataFile = "collatz_checker.tsv")

  public static boolean testCollatzConjecture(int n) {
    return core(n);
  }

  private static boolean core(int n) {
    if(cache.containsKey(n)) {
      return cache.get(n);
    } else if(n == 1) {
      return true;
    } else if(n == 0) {
      return false;
    }

    if(n % 2 == 0) {
      n /= 2;
    } else {
      n = n * 3 + 1;
    }
    cache.put(n, core(n));
    return cache.get(n);
  }

  public static void main(String[] args) {
    System.exit(
            GenericTest
                    .runFromAnnotations(args, "CollatzChecker.java",
                            new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
