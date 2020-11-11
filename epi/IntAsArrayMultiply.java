package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
    int n1 = num1.size(), n2 = num2.size();
    if((n1 == 1 && num1.get(0) == 0)
    || (n2 == 1 && num2.get(0) == 0)) {
      return Arrays.asList(0);
    }

    boolean isNeg = num1.get(0) * num2.get(0) < 0;
    if(num1.get(0) < 0) {
      num1.set(0, -1 * num1.get(0));
    }

    if(num2.get(0) < 0) {
      num2.set(0, -1 * num2.get(0));
    }
    int[] rt = new int[n1 + n2];

    /*
     i2   1 0
     i1   1 0
     mul  8 4 10
     rt   [4, 0, 8]
     */
    for(int i2 = n2 - 1; i2 >= 0; i2--) {
      for(int i1 = n1 - 1; i1 >= 0; i1--) {
        int idx = i1 + i2 + 1;
        int mul = num2.get(i2) * num1.get(i1) + rt[idx];
        rt[idx] = (mul % 10);
        rt[idx - 1] += (mul / 10);
      }
    }

    List<Integer> rtList = new ArrayList();
    int nonZeroIdx = 0;
    while(rt[nonZeroIdx] == 0) {
      nonZeroIdx++;
    }

    for(int i = nonZeroIdx; i < rt.length; i++) {
      rtList.add(rt[i]);
    }

    if(isNeg) {
      rtList.set(0, rtList.get(0) * -1);
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
