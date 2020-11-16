package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SpiralOrdering {
  @EpiTest(testDataFile = "spiral_ordering.tsv")

  public static List<Integer>
  matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    //T O(N^2) S O(N^2)
    /*List<Integer> rtList = new ArrayList<>();

    int m = squareMatrix.size();
    boolean[][] visited = new boolean[m][m];
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int r = 0, c = -1, sIdx = 0, nR = 0, nC = 0;
    while(rtList.size() < m * m) {
      while(true) {
        nR = r + dir[sIdx][0];
        nC = c + dir[sIdx][1];
        if(nR < 0 || nR >= m || nC < 0 || nC >= m || visited[nR][nC]) {
          break;
        }
        visited[nR][nC] = true;
        r = nR;
        c = nC;
        rtList.add(squareMatrix.get(r).get(c));
      }
      sIdx++;
      sIdx %= dir.length;
    }

    return rtList;*/
    //In place solution
    int m = squareMatrix.size();

    List<Integer> rtList = new ArrayList<>();
    if(m == 0) {
      return rtList;
    } else if(m == 1) {
      return Arrays.asList(squareMatrix.get(0).get(0));
    }
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int r = 0, c = 0;

    while(true) {
      for (int[] shift : dir) {
        for(int i = 0; i < m - 1; i++) {
          rtList.add(squareMatrix.get(r).get(c));
          r += shift[0];
          c += shift[1];
        }
      }
      //Revert to legal pt
      r -= dir[3][0];
      c -= dir[3][1];
      //Shift to inner start pt
      r += dir[0][0];
      c += dir[0][1];
      m -= 2;
      if(m == 0) {
        break;
      } else if(m == 1) {
        rtList.add(squareMatrix.get(r).get(c));
        break;
      }
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
