package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class TreeWithParentInorder {
  @EpiTest(testDataFile = "tree_with_parent_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
//    /*
//      T O(N) S O(1) except output space
//     */
//    List<Integer> rtList = new ArrayList<>();
//    if(tree == null) {
//      return rtList;
//    }
//    //Find the left most
//    BinaryTree<Integer> next = tree;
//    while(next.left != null) {
//      next = next.left;
//    }
//
//    rtList.add(next.data);
//    //Use successor function to add rt
//    while((next = SuccessorInTree.findSuccessor(next)) != null) {
//      rtList.add(next.data);
//    }
//
//    return rtList;
    //Extra assert
    //For variant1 of 10.13
    List<Integer> gList = new ArrayList<>();
    postOrderWithNull(tree, gList);
    BinaryTree<Integer> rt = epi.kt.TreeFromPostorderWithNull.INSTANCE.reconstructPostorder(gList);
    List<Integer> rtList = new ArrayList<>();
    postOrderWithNull(rt, rtList);
    assert rtList.size() == gList.size();
    for(int i = 0; i < rtList.size(); i++) {
      assert rtList.get(i) == gList.get(i);
    }

//    List<Integer> gList = new ArrayList<>();
//    postOrder(tree, gList);
//    List<Integer> list = epi.kt.TreeWithParentInorder.INSTANCE.postorderTraversal(tree);
//    for(int i = 0; i < gList.size(); i++) {
//      assert gList.get(i) == list.get(i);
//    }

//    List<Integer> gList = new ArrayList<>();
//    preOrder(tree, gList);
//    List<Integer> list = epi.kt.TreeWithParentInorder.INSTANCE.preorderTraversal(tree);
//    for(int i = 0; i < gList.size(); i++) {
//      assert gList.get(i) == list.get(i);
//    }

    return epi.kt.TreeWithParentInorder.INSTANCE.inorderTraversal(tree);
  }

  private static void postOrderWithNull(BinaryTree<Integer> tree, List<Integer> rtList) {
    if(tree == null) {
      rtList.add(null);
      return;
    }

    postOrder(tree.left, rtList);
    postOrder(tree.right, rtList);
    rtList.add(tree.data);
  }

  private static void postOrder(BinaryTree<Integer> tree, List<Integer> rtList) {
    if(tree == null) {
      return;
    }

    postOrder(tree.left, rtList);
    postOrder(tree.right, rtList);
    rtList.add(tree.data);
  }

  private static void preOrder(BinaryTree<Integer> tree, List<Integer> rtList) {
    if(tree == null) {
      return;
    }

    rtList.add(tree.data);
    preOrder(tree.left, rtList);
    preOrder(tree.right, rtList);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeWithParentInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
