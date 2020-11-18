package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.List;
public class IsValidSudoku {
  @EpiTest(testDataFile = "is_valid_sudoku.tsv")

  // Check if a partially filled matrix has any conflicts.
  public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
    //T O(N^2) S O(1)
    boolean[] check = new boolean[10];
    //Check all row
    for(int i = 0; i < 9; i++) {
      Arrays.fill(check, false);
      for(int j = 0; j < 9; j++) {
        int val = partialAssignment.get(i).get(j);
        if(val == 0) {
          continue;
        }

        if(check[val]) {
          return false;
        }

        check[val] = true;
      }
    }

    //Check all column
    for(int j = 0; j < 9; j++) {
      Arrays.fill(check, false);
      for(int i = 0; i < 9; i++) {
        int val = partialAssignment.get(i).get(j);
        if(val == 0) {
          continue;
        }

        if(check[val]) {
          return false;
        }

        check[val] = true;
      }
    }

    //Check all block(3*3)
    int r = 0, c = 0;
    while(r < 9) {
      c = 0;
      while (c < 9) {
        Arrays.fill(check, false);
        for (int i = r; i < r + 3; i++) {
          for (int j = c; j < c + 3; j++) {
            int val = partialAssignment.get(j).get(i);
            if(val == 0) {
              continue;
            }

            if(check[val]) {
              return false;
            }

            check[val] = true;
          }
        }
        c += 3;
      }
      r += 3;
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidSudoku.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
