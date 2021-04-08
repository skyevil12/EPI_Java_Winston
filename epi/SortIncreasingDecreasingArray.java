package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingArray {
  @EpiTest(testDataFile = "sort_increasing_decreasing_array.tsv")

  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
//    List<List<Integer>> tmp = new ArrayList<>();
//    int len = A.size(), st = 0;
//    boolean isIncrease = true;
//
//    for(int i = 1; i <= len; i++) {
//      if(i == len
//      || ((A.get(i - 1) < A.get(i)) && !isIncrease)
//      || ((A.get(i - 1) > A.get(i)) && isIncrease)) {
//        List<Integer> l = A.subList(st, i);
//        if(!isIncrease) {
//          Collections.reverse(l);
//        }
//        tmp.add(l);
//        isIncrease = !isIncrease;
//        st = i;
//      }
//    }
//
//    return SortedArraysMerge.mergeSortedArrays(tmp);
    return epi.kt.SortIncreasingDecreasingArray.INSTANCE.sortKIncreasingDecreasingArray(A);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
