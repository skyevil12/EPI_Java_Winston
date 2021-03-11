package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SumRootToLeaf {
  @EpiTest(testDataFile = "sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    /*
      T O(N) S O(h) h is logN if complete tree or N if skewed tree
      full tree is the node either 0 or 2 children
      complete tree is the case that last level has all keys as left as possible
      perfect tree is all nodes have two children and all leaves are at same level
      preorder
     */
//    int[] rt = {0};
//    core(tree, 0, rt);
//    return rt[0];
    return epi.kt.SumRootToLeaf.INSTANCE.sumRootToLeaf(tree);
  }

  private static void core(BinaryTreeNode<Integer> node, int cur, int[] rt) {
    if(node == null) {
      return;
    }

    cur += node.data;
    if(node.left == null && node.right == null) {
      rt[0] += cur;
      return;
    }

    core(node.left, cur * 2, rt);
    core(node.right, cur * 2, rt);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SumRootToLeaf.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
