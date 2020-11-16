package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MatrixRotation {

  public static void rotateMatrix(List<List<Integer>> squareMatrix) {
    /*
    //T O(M^2) S O(M^2)
    if(squareMatrix.size() == 0) {
      return;
    }
    int m = squareMatrix.size();

    List<List<Integer>> rt = new ArrayList<>(m);
    for(int i = 0; i < m; i++) {
      List<Integer> unit = new ArrayList<>(m);
      for(int j = 0; j < m; j++) {
        unit.add(j);
      }
      rt.add(unit);
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < m; j++) {
        rt.get(j).set(m - 1 - i, squareMatrix.get(i).get(j));
      }
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < m; j++) {
        squareMatrix.get(i).set(j, rt.get(i).get(j));
      }
    }
    */

    //Inplace, T O(N^2) S O(1)
    if(squareMatrix.size() == 0) {
      return;
    }

    int m = squareMatrix.size(), max = m - 1;;

    for(int i = 0; i < m / 2; i++) {
      for(int j = i; j < max - i; j++) {
        int ori = squareMatrix.get(i).get(j);
        int sec = squareMatrix.get(j).get(max - i);
        int third = squareMatrix.get(max - i).get(max - j);
        int fourth = squareMatrix.get(max - j).get(i);
        //Set ori val
        squareMatrix.get(j).set(max - i, ori);
        squareMatrix.get(max - i).set(max - j, sec);
        squareMatrix.get(max - j).set(i, third);
        squareMatrix.get(i).set(j, fourth);
      }
    }

    //TODO: Last solution?? T O(1) S O(1)
    
    return;
  }
  @EpiTest(testDataFile = "matrix_rotation.tsv")
  public static List<List<Integer>>
  rotateMatrixWrapper(List<List<Integer>> squareMatrix) {
    rotateMatrix(squareMatrix);
    return squareMatrix;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixRotation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
