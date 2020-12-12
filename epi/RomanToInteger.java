package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  private static Map<Character, Integer> map = new HashMap<>(){
    {
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }
  };
  @EpiTest(testDataFile = "roman_to_integer.tsv")
//T O(N) S O(1)
  public static int romanToInteger(String s) {
//    assert(isValid(s));
//    int rt = 0, prev = Integer.MAX_VALUE;
//
//    for(char ch : s.toCharArray()) {
//      int val = map.get(ch);
//      if(val > prev) {
//        rt -= prev;
//        rt += (val - prev);
//      } else {
//        rt += val;
//      }
//      prev = val;
//    }
//
//    return rt;
    return epi.kt.RomanToInteger.INSTANCE.romanToInteger(s);
  }

  private static boolean isValid(String s) {
    /*
      0. Check if there contains any illegal char
      1. Check if correct preceding char
      2. Check if back to back exception exist
     */
    boolean hasPre = false;
    int prev = Integer.MAX_VALUE;
    for(char ch : s.toCharArray()) {
      Integer val = map.get(ch);
      //Check if there contains any illegal char
      if(val == null) {
        return false;
      }

      if(val > prev) {
        if(hasPre) {
          //Back to back
          return false;
        }
        //Check if correct preceding char
        if(((ch == 'V' || ch == 'X') && prev != 1)
        ||  ((ch == 'L' || ch == 'C') && prev != 10)
        ||  ((ch == 'D' || ch == 'M') && prev != 100)) {
          return false;
        }

        hasPre = true;
      } else {
        hasPre = false;
      }
      prev = val;
    }

    return true;
  }

  public static void main(String[] args) {
    //Back to back
    assert (!isValid("IXC"));
    assert (!isValid("CDM"));
    //Illegal char
    assert (!isValid("ACD"));
    //Wrong preceding char
    assert (!isValid("IDM"));
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
