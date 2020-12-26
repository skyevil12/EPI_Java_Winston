package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class TreePreorder {

  private static class NodeAndState {
    public BinaryTreeNode<Integer> node;
    public Boolean nodeProcessed;

    public NodeAndState(BinaryTreeNode<Integer> node, Boolean nodeProcessed) {
      this.node = node;
      this.nodeProcessed = nodeProcessed;
    }
  }

  @EpiTest(testDataFile = "tree_preorder.tsv")
  public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
    /*
      T O(N) S O(h) h is logN - N
     */
    List<Integer> rtList = new ArrayList<>();

    Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
    BinaryTreeNode<Integer> root = tree;

    while(!stack.isEmpty() || root != null) {
      while(root != null) {
        rtList.add(root.data);
        stack.push(root);
        root = root.left;
      }

      BinaryTreeNode tmp = stack.pop();
      root = tmp.right;
    }

    return rtList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePreorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
