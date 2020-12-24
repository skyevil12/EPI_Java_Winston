package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorWithParent {
  public static BinaryTree<Integer> lca(BinaryTree<Integer> node0,
                                        BinaryTree<Integer> node1) {
    /*
      T O(h) S O(1)
     */
    int dep0 = 0, dep1 = 0;
    BinaryTree<Integer> c0 = node0, c1 = node1;
    while(c0 != null) {
      dep0++;
      c0 = c0.parent;
    }

    while(c1 != null) {
      dep1++;
      c1 = c1.parent;
    }

    while(dep0 > dep1) {
      node0 = node0.parent;
      dep0--;
    }

    while(dep1 > dep0) {
      node1 = node1.parent;
      dep1--;
    }

    while(node0 != node1) {
      node0 = node0.parent;
      node1 = node1.parent;
    }

    return node0;
  }
  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor, BinaryTree<Integer> tree,
                               Integer key0, Integer key1) throws Exception {
    BinaryTree<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTree<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTree<Integer> result = executor.run(() -> lca(node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestorWithParent.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
