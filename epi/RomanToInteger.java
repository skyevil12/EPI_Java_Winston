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

  //T O(N) S O(1) + map constant space
  public static int romanToInteger(String s) {
    int rt = 0, len = s.length();

    for(int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if(i < len - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
        rt -= map.get(ch);
      } else {
        rt += map.get(ch);
      }
    }

    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
