package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {

//  @EpiTest(testDataFile = "is_tree_balanced.tsv")
//  /*
//    T O(N) S O(h) h is O logN if complete binary tree or N is skewed binary tree
//   */
//  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
//    if(tree == null) {
//      return true;
//    }
//    return heightAndCheckBalanced(tree) > 0;
//  }
//
//  private static int heightAndCheckBalanced(BinaryTreeNode<Integer> node) {
//    if(node == null) {
//      return 0;
//    }
//
//    int l = heightAndCheckBalanced(node.left);
//    if(l < 0) {
//      return -1;
//    }
//
//    int r = heightAndCheckBalanced(node.right);
//    if(r < 0) {
//      return -1;
//    }
//
//    int diff = Math.abs(l - r);
//    return diff > 1 ? -1 : 1 + Math.max(l, r);
//  }

  private static class TreeStatus {
    boolean isBalanced = false;
    int height = 0;

    TreeStatus(boolean isBalanced, int height) {
      this.isBalanced = isBalanced;
      this.height = height;
    }
  }

  @EpiTest(testDataFile = "is_tree_balanced.tsv")
  /*
    T O(N) S O(h) h is O logN if complete binary tree or N is skewed binary tree
   */
  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return checkBalanced(tree).isBalanced;
  }

  private static TreeStatus checkBalanced(BinaryTreeNode<Integer> node) {
    if(node == null) {
      return new TreeStatus(true, 0);
    }

    TreeStatus ls = checkBalanced(node.left);
    if(!ls.isBalanced) {
      return ls;
    }

    TreeStatus rs = checkBalanced(node.right);
    if(!rs.isBalanced) {
      return rs;
    }

    boolean isBalanced = Math.abs(ls.height - rs.height) <= 1;
    int height = 1 + Math.max(ls.height, rs.height);

    return new TreeStatus(isBalanced, height);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
