package epi;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;
public class SuccessorInTree {

  public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
    /*
      Check if current node has right child
      Y-> find left most child of cur right child, or return the right child directly
      N-> find if the parent is the left child of grand parent and return the grand parent
      T O(h) h logN-N S O(1)
    */
    if(node == null) {
      return null;
    }

    if(node.right != null) {
      node = node.right;
      while(node.left != null) {
        node = node.left;
      }
      return node;
    }

    BinaryTree<Integer> parent = node.parent;
    while(parent != null && parent.left != node) {
      node = parent;
      parent = parent.parent;
    }

    return parent;
  }
  @EpiTest(testDataFile = "successor_in_tree.tsv")
  public static int findSuccessorWrapper(TimedExecutor executor,
                                         BinaryTree<Integer> tree, int nodeIdx)
      throws Exception {
    BinaryTree<Integer> n = BinaryTreeUtils.mustFindNode(tree, nodeIdx);

    BinaryTree<Integer> result = executor.run(() -> findSuccessor(n));

    return result == null ? -1 : result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SuccessorInTree.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
