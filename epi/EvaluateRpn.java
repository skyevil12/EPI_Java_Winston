package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateRpn {
  @EpiTest(testDataFile = "evaluate_rpn.tsv")

  public static int eval(String expression) {
    /*
      Edge cases: empty and illegal rpn
      Split all by ',' using stack, then calculate the mul and div on the fly
      Sum all to get the result
     */
    //T O(N) S O(N)
    String[] exps = expression.split(",");
    Deque<Integer> stack = new ArrayDeque<>();
    for (String exp : exps) {
      if (exp.length() == 1 && "+-*/".contains(exp)) {
        int second = stack.pop(), first = stack.pop();
        switch(exp.charAt(0)) {
          case '+':
            stack.push(first + second);
            break;
          case '-':
            stack.push(first - second);
            break;
          case '*':
            stack.push(first * second);
            break;
          case '/':
            stack.push(first / second);
            break;
          default:
            throw new RuntimeException("Illegal input!");
        }
      } else {
        stack.push(Integer.parseInt(exp));
      }
    }

    return stack.removeFirst();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
