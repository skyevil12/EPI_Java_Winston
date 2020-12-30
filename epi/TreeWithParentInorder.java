package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class TreeWithParentInorder {
  @EpiTest(testDataFile = "tree_with_parent_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
    /*
      T O(N) S O(1) except output space
     */
    List<Integer> rtList = new ArrayList<>();
    if(tree == null) {
      return rtList;
    }
    //Find the left most
    BinaryTree<Integer> next = tree;
    while(next.left != null) {
      next = next.left;
    }

    rtList.add(next.data);
    //Use successor function to add rt
    while((next = SuccessorInTree.findSuccessor(next)) != null) {
      rtList.add(next.data);
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeWithParentInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
