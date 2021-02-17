package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {
  @EpiTest(testDataFile = "tree_level_order.tsv")

  public static List<List<Integer>>
  binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
//    List<List<Integer>> rtList = new ArrayList<>();
//    if(tree == null) {
//      return rtList;
//    }
//
//    Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
//    queue.offer(tree);
//
//    while(!queue.isEmpty()) {
//      List<Integer> lList = new ArrayList<>();
//      Queue<BinaryTreeNode<Integer>> nextQueue = new ArrayDeque<>();
//
//      while(!queue.isEmpty()) {
//        BinaryTreeNode<Integer> cur = queue.poll();
//        lList.add(cur.data);
//
//        if (cur.left != null) {
//          nextQueue.offer(cur.left);
//        }
//
//        if(cur.right != null) {
//          nextQueue.offer(cur.right);
//        }
//      }
//
//      rtList.add(lList);
//      queue = nextQueue;
//    }
//
//    return rtList;
    return epi.kt.TreeLevelOrder.INSTANCE.binaryTreeDepthOrder(tree);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeLevelOrder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
