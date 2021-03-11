package epi;
import epi.kt.LowestCommonAncestorV1;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class LowestCommonAncestor {
  private static class Status {
    BinaryTreeNode<Integer> parent;
    int expectedNum;

    Status(BinaryTreeNode<Integer> parent, int expectedNum) {
      this.parent = parent;
      this.expectedNum = expectedNum;
    }
  }

  private static Status find(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> node0, BinaryTreeNode<Integer> node1) {
    if(node == null) {
      return new Status(null, 0);
    }

    Status ls = find(node.left, node0, node1);
    if(ls.expectedNum == 2) {
      return ls;
    }

    Status rs = find(node.right, node0, node1);
    if(rs.expectedNum == 2) {
      return rs;
    }

    int expectedNum = ls.expectedNum + rs.expectedNum + (node == node0 ? 1 : 0) + (node == node1 ? 1 : 0);
    return new Status(expectedNum == 2 ? node : null, expectedNum);
  }

  /*
    T O(N) S O(h), h is logN -> N(skewed tree)
   */
  public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> tree,
                                            BinaryTreeNode<Integer> node0,
                                            BinaryTreeNode<Integer> node1) {
    return LowestCommonAncestorV1.INSTANCE.lca(tree, node0, node1);
//    return epi.kt.LowestCommonAncestor.INSTANCE.lca(tree, node0, node1);
//    return find(tree, node0, node1).parent;
//    if (tree == null || tree == node0 || tree == node1) {
//      return tree;
//    }
//
//    BinaryTreeNode<Integer> lFound = lca(tree.left, node0, node1);
//    BinaryTreeNode<Integer> rFound = lca(tree.right, node0, node1);
//
//    if(lFound != null && rFound != null) {
//      return tree;
//    } else {
//      return lFound == null ? rFound : lFound;
//    }
  }
  @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor,
                               BinaryTreeNode<Integer> tree, Integer key0,
                               Integer key1) throws Exception {
    BinaryTreeNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTreeNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTreeNode<Integer> result =
        executor.run(() -> lca(tree, node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestor.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
