package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeFromPreorderWithNull {
  public static BinaryTreeNode<Integer>
  reconstructPreorder(List<Integer> preorder) {
    //T O(N) S O(N)
//    Queue<Integer> pQ = new LinkedList<>(preorder);
//    return core(pQ);
    //T O(N) S O(1) except input list
//    sI = 0;
    return coreEx(preorder, new int[]{0});
  }

//  private static int sI = 0;

  private static BinaryTreeNode<Integer> coreEx(List<Integer> preorder, int[] i) {
    Integer rVal = preorder.get(i[0]);
    i[0]++;
    if(rVal == null) {
      return null;
    }
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rVal);
    root.left = coreEx(preorder, i);
    root.right = coreEx(preorder, i);
    return root;
  }

  private static BinaryTreeNode<Integer> core(Queue<Integer> pQ) {
    if(pQ.isEmpty()) {
      System.out.println("Should not see me!");
      return null;
    }

    Integer rVal = pQ.poll();
    if(rVal == null) {
      return null;
    }

    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rVal);
    root.left = core(pQ);
    root.right = core(pQ);
    return root;
  }

  @EpiTest(testDataFile = "tree_from_preorder_with_null.tsv")
  public static BinaryTreeNode<Integer>
  reconstructPreorderWrapper(TimedExecutor executor, List<String> strings)
      throws Exception {
    List<Integer> ints = new ArrayList<>();
    for (String s : strings) {
      if (s.equals("null")) {
        ints.add(null);
      } else {
        ints.add(Integer.parseInt(s));
      }
    }

    return executor.run(() -> reconstructPreorder(ints));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeFromPreorderWithNull.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
