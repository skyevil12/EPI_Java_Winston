package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TreeExterior {

  public static List<BinaryTreeNode<Integer>>
  exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
    List<BinaryTreeNode<Integer>> rtList = new ArrayList<>();
    if(tree == null) {
      return rtList;
    }

    rtList.add(tree);
    List<BinaryTreeNode<Integer>> lList = new ArrayList<>();
    lCore(tree.left, lList, true);
    rtList.addAll(lList);

    List<BinaryTreeNode<Integer>> rList = new ArrayList<>();
    rCore(tree.right, rList, true);
    rtList.addAll(rList);

    return rtList;
  }

  //PreOrder - could get the left exterior before the left leaves
  private static void lCore(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> list, boolean isBoundary) {
    if(tree == null) {
      return;
    }

    if(isBoundary || (tree.left == null && tree.right == null)) {
      list.add(tree);
    }

    lCore(tree.left, list, isBoundary);
    lCore(tree.right, list, isBoundary && tree.left == null);
  }

  //PostOrder - could get the right exterior after the right leaves
  private static void rCore(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> list, boolean isBoundary) {
    if(tree == null) {
      return;
    }

    rCore(tree.left, list, isBoundary && tree.right == null);
    rCore(tree.right, list, isBoundary);
    if(isBoundary || (tree.left == null && tree.right == null)) {
      list.add(tree);
    }
  }

  private static List<Integer> createOutputList(List<BinaryTreeNode<Integer>> L)
      throws TestFailure {
    if (L.contains(null)) {
      throw new TestFailure("Resulting list contains null");
    }
    List<Integer> output = new ArrayList<>();
    for (BinaryTreeNode<Integer> l : L) {
      output.add(l.data);
    }
    return output;
  }

  @EpiTest(testDataFile = "tree_exterior.tsv")
  public static List<Integer>
  exteriorBinaryTreeWrapper(TimedExecutor executor,
                            BinaryTreeNode<Integer> tree) throws Exception {
    List<BinaryTreeNode<Integer>> result =
        executor.run(() -> exteriorBinaryTree(tree));

    return createOutputList(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeExterior.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
