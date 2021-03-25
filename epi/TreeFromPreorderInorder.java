package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFromPreorderInorder {
  @EpiTest(testDataFile = "tree_from_preorder_inorder.tsv")

  public static BinaryTreeNode<Integer>
  binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {
    /*
        1
      2   3

    1 2 3
    2 1 3
    T O(N^2) S O(logN)
    N is preorder step forward size, the other N is search root in inorder list
    preOrder root first
    inOrder left most first
    */
//    return core(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
//    Map<Integer, Integer> iIdxMap = new HashMap<>();
//    for(int i = 0; i < inorder.size(); i++) {
//      iIdxMap.put(inorder.get(i), i);
//    }
//    //CoreEx is T O(N) S O(N + h(logN)) because use map to accelerate search root action
//    return coreEx(preorder, iIdxMap, 0, preorder.size() - 1, 0, inorder.size() - 1);
    return epi.kt.TreeFromPreorderInorder.INSTANCE.binaryTreeFromPreorderInorder(preorder, inorder);
  }

  private static BinaryTreeNode<Integer> coreEx(List<Integer> preOrder, Map<Integer, Integer> iIdxMap, int pSt, int pEd, int iSt, int iEd) {
    if(pSt > pEd || iSt > iEd) {
      return null;
    }

    int rVal = preOrder.get(pSt);
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rVal);
    int i = iIdxMap.get(rVal);
    root.left = coreEx(preOrder, iIdxMap,pSt + 1, pSt + (i - 1 - iSt + 1), iSt, i - 1);
    root.right = coreEx(preOrder, iIdxMap, pSt + (i - 1 - iSt + 1) + 1, pEd, i + 1, iEd);
    return root;
  }

  private static BinaryTreeNode<Integer> core(List<Integer> preorder, List<Integer> inorder, int pSt, int pEd, int iSt, int iEd) {
    if(pSt > pEd || iSt > iEd) {
      return null;
    }

    int rVal = preorder.get(pSt);
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rVal);
    int i = -1;
    for(i = iSt; i <= iEd; i++) {
      if(inorder.get(i) == rVal) {
        break;
      }
    }

    root.left = core(preorder, inorder, pSt + 1, pSt + (i - 1 - iSt + 1), iSt, i - 1);
    root.right = core(preorder, inorder, pSt + (i - 1 - iSt + 1) + 1, pEd, i + 1, iEd);
    return root;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeFromPreorderInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
