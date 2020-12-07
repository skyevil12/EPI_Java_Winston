package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsValidParenthesization {
  static Map<Character, Character> sMap = new HashMap<>(){
    {
      this.put('(', ')');
      this.put('[', ']');
      this.put('{', '}');
    }
  };
  @EpiTest(testDataFile = "is_valid_parenthesization.tsv")
  public static boolean isWellFormed(String s) {
    /*
          ([]){()}
    stack {(
      T O(N) S O(N)
     */
    Deque<Character> stack = new ArrayDeque();
    for(char ch : s.toCharArray()) {
      if(sMap.containsKey(ch)) {
        stack.push(ch);
      } else {
        if(!stack.isEmpty() && sMap.get(stack.pop()) == ch) {

        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidParenthesization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
