package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PascalTriangle {
  @EpiTest(testDataFile = "pascal_triangle.tsv")

  public static List<List<Integer>> generatePascalTriangle(int numRows) {
    /*List<List<Integer>> rtList = new ArrayList<>();
    if(numRows == 0) {
      return rtList;
    }

    rtList.add(Arrays.asList(1));

    //T O(N^2) S O(N^2)
    for(int i = 1; i < numRows; i++) {
      List<Integer> prev = rtList.get(rtList.size() - 1), cur = new ArrayList<>();

      cur.add(1);
      for(int j = 1; j < prev.size(); j++) {
          cur.add(prev.get(j - 1) + prev.get(j));
      }
      cur.add(1);

      rtList.add(cur);
    }

    return rtList;*/
    List<List<Integer>> rtList = new ArrayList<>();

    for(int i = 0; i < numRows; i++) {
      List<Integer> numRow = new ArrayList<>();
      for(int j = 0; j <= i; j++) {
        numRow.add(j > 0 && j < i ? rtList.get(i - 1).get(j) + rtList.get(i - 1).get(j - 1) : 1);
      }
      rtList.add(numRow);
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PascalTriangle.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
