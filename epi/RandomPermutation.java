package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.RandomSequenceChecker;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class RandomPermutation {

  public static List<Integer> computeRandomPermutation(int n) {
//    //Brute force
//    Set<Integer> set = new HashSet<>();
//    List<Integer> rt = new ArrayList<>();
//    Random random = new Random();
//    while(set.size() < n) {
//      int num = random.nextInt(n);
//      if(set.add(num)) {
//        rt.add(num);
//      }
//    }
//    return rt;
    Integer[] rt = new Integer[n];
    for(int i = 0; i < n; i++) {
      rt[i] = i;
    }

    Random random = new Random();
    //Should only consume N time api
    for(int i = 0; i < n; i++) {
      swap(rt, i, i + random.nextInt(n - i));
    }

    return Arrays.asList(rt);
  }

  private static void swap(Integer[] nums, int i, int j) {
    Integer tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  private static int factorial(int n) {
    return n <= 1 ? 1 : n * factorial(n - 1);
  }

  private static int permutationIndex(List<Integer> perm) {
    int idx = 0;
    int n = perm.size();
    for (int i = 0; i < perm.size(); ++i) {
      int a = perm.get(i);
      idx += a * factorial(n - 1);
      for (int j = i + 1; j < perm.size(); ++j) {
        if (perm.get(j) > a) {
          perm.set(j, perm.get(j) - 1);
        }
      }
      --n;
    }
    return idx;
  }

  private static boolean computeRandomPermutationRunner(TimedExecutor executor,
                                                        int n)
      throws Exception {
    List<List<Integer>> results = new ArrayList<>();

    executor.run(() -> {
      for (int i = 0; i < 1000000; ++i) {
        results.add(computeRandomPermutation(n));
      }
    });

    List<Integer> sequence = new ArrayList<>();
    for (List<Integer> result : results) {
      sequence.add(permutationIndex(result));
    }
    return RandomSequenceChecker.checkSequenceIsUniformlyRandom(
        sequence, factorial(n), 0.01);
  }

  @EpiTest(testDataFile = "random_permutation.tsv")
  public static void computeRandomPermutationWrapper(TimedExecutor executor,
                                                     int n) throws Exception {
    RandomSequenceChecker.runFuncWithRetries(
        () -> computeRandomPermutationRunner(executor, n));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RandomPermutation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
