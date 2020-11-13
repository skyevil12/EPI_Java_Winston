package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    /*List<Integer> rtList = new ArrayList<>();

    //If target has no divisor less or equal to sqrt of itself, then it is prime
    //T O(N ^ 3/2)
    for(int i = 2; i <= n; i++) {
      boolean isPrime = true;
      for(int j = 2; j * j <= i; j++) {
        if(i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if(isPrime) {
        rtList.add(i);
      }
    }

    return rtList;*/

    List<Integer> rtList = new ArrayList<>();
    //S O(N)
    List<Boolean> primeList = new ArrayList<>(Collections.nCopies(n + 1, true));
    primeList.set(0, false);
    primeList.set(1, false);

    //T O(NlogN)
    for(int i = 2; i <= n; i++) {
      if(primeList.get(i)) {
        rtList.add(i);
        for(int j = i + i; j <= n; j += i){
          primeList.set(j, false);
        }
      }
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
