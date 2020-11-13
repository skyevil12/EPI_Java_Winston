package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class ApplyPermutation {
  public static void applyPermutation(List<Integer> perm, List<Integer> A) {
    //T O(N) S O(N)
    /*
    List<Integer> dup = new ArrayList(perm);
    for(int i = 0; i < A.size(); i++) {
      dup.set(perm.get(i), A.get(i));
    }

    for(int i = 0; i < dup.size(); i++) {
      A.set(i, dup.get(i));
    }*/

    /*
      perm  [-2, -4, -3, -1]
      A     [b, c, a, d]

      pos     0 2 1 0 3 3
      posVal  a c b a d d
      nPos    2 1 0   3
      nPosVal c b a   d
     */

    //T O(N) S O(1)
    /*
    int len = perm.size();
    for(int i = 0; i < len; i++) {
      if(perm.get(i) < 0) {
        continue;
      }
      int pos = i;
      int posVal = A.get(i);
      while(perm.get(pos) >= 0) {
        int nPos = perm.get(pos);
        int nPosVal = A.get(nPos);
        A.set(nPos, posVal);
        perm.set(pos, nPos - len);
        pos = nPos;
        posVal = nPosVal;
      }
    }

    //restore perm
    for(int i = 0; i < len; i++) {
      perm.set(i, perm.get(i) + len);
    }*/

    int len = A.size();
    //T O(N^2) S O(1)
    for(int i = 0; i < len; i++) {
      //find left most
      boolean isLeftMost = true;
      int j = perm.get(i);
      while(j != i) {
        if(j < i) {
          isLeftMost = false;
          break;
        }

        j = perm.get(j);
      }

      if(isLeftMost) {
        cylicPermutation(perm, A, i);
      }
    }

    return;
  }

  private static void cylicPermutation(List<Integer> perm, List<Integer> A, int st) {
      int pos = st;
      int posVal = A.get(pos);

      do {
        int nPos = perm.get(pos);
        int nPosVal = A.get(nPos);
        A.set(nPos, posVal);
        pos = nPos;
        posVal = nPosVal;
      } while (pos != st);
  }

  @EpiTest(testDataFile = "apply_permutation.tsv")
  public static List<Integer> applyPermutationWrapper(List<Integer> perm,
                                                      List<Integer> A) {
    applyPermutation(perm, A);
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ApplyPermutation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
