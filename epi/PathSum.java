package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class PathSum {
  @EpiTest(testDataFile = "path_sum.tsv")

  public static boolean hasPathSum(BinaryTreeNode<Integer> tree,
                                   int remainingWeight) {
    /*
      Consider the null input, return false even the remainHeight is 0 initially
      And suppose the node contains negative val
      T O(N) S O(h) h is logN to N
      preOrder
     */
    if(tree == null) {
      return false;
    }

    remainingWeight -= tree.data;
    //Need to confirm if it is leaf
    if(tree.left == null && tree.right == null && remainingWeight == 0) {
      return true;
    }
    //Here || is the short circuiting and once left is true no more right operation, but the | will check both
    return hasPathSum(tree.left, remainingWeight) || hasPathSum(tree.right, remainingWeight);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PathSum.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
