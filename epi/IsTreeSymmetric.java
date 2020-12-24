package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeSymmetric {
  @EpiTest(testDataFile = "is_tree_symmetric.tsv")

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    /*
    left.left == right.right
    left.right == right.left
    Suppose empty input is symmetric
    T O(N) S O(h) h is logN ~ N
     */
    if(tree == null) {
      return true;
    }

    return isSubTreeSym(tree.left, tree.right);
  }

  private static boolean isSubTreeSym(BinaryTreeNode<Integer> l, BinaryTreeNode<Integer> r) {
    if(l == null && r == null) {
      return true;
    } else if(l != null && r != null){
      return l.data == r.data && isSubTreeSym(l.left, r.right) && isSubTreeSym(l.right, r.left);
    }

    return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
