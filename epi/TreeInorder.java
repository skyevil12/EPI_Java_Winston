package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class TreeInorder {

  private static class NodeAndState {
    public BinaryTreeNode<Integer> node;
    public Boolean leftSubtreeTraversed;

    public NodeAndState(BinaryTreeNode<Integer> node,
                        Boolean leftSubtreeTraversed) {
      this.node = node;
      this.leftSubtreeTraversed = leftSubtreeTraversed;
    }
  }

  @EpiTest(testDataFile = "tree_inorder.tsv")
  public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
//    //T O(N) S O(h)
//    List<Integer> rtList = new ArrayList<>();
//    Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
//    BinaryTreeNode<Integer> root = tree;
//    while(!stack.isEmpty() || root != null) {
//      while(root != null) {
//        stack.push(root);
//        root = root.left;
//      }
//
//      BinaryTreeNode<Integer> node = stack.pop();
//      rtList.add(node.data);
//      root = node.right;
//    }
//    return rtList;
    return epi.kt.TreeInorder.INSTANCE.inorderTraversal(tree);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
