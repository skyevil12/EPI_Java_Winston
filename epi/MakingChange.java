package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class MakingChange {
  @EpiTest(testDataFile = "making_change.tsv")

  public static int changeMaking(int cents) {
    int[] coins = {1, 5, 10, 25, 50, 100};
    int rt = 0;
    for(int i = coins.length - 1; i >= 0; i--) {
      rt += cents / coins[i];
      cents %= coins[i];
    }
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MakingChange.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
