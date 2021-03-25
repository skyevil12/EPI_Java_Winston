package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class CollatzChecker {
  private static Map<Integer, Boolean> cache = new HashMap<>();

  @EpiTest(testDataFile = "collatz_checker.tsv")

  public static boolean testCollatzConjecture(int n) {
    if(cache.containsKey(n)) {
      return cache.get(n);
    }
    boolean rt = core(n);
    cache.put(n, rt);
    return rt;
  }

  private static boolean core(long n) {
    if(n == 1) {
      return true;
    } else if(n > Integer.MAX_VALUE) {
      return false;
    } else if(cache.containsKey(n)) {
      return cache.get(n);
    }

    if(n % 2 != 0) {
      long nO = n * 3 + 1;
      boolean rt = core(nO);
      cache.put((int) nO, rt);
      return rt;
    } else {
      long nE = n / 2;
      boolean rt = core(nE);
      cache.put((int) nE, rt);
      return rt;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CollatzChecker.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
