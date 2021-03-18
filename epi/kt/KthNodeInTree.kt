package epi.kt

import epi.KthNodeInTree

object KthNodeInTree {
    fun findKthNodeBinaryTree(tree: KthNodeInTree.BinaryTreeNode<Int>?, k : Int) : KthNodeInTree.BinaryTreeNode<Int>? {
        /*
            tree -> null
            return null
            if(tree.left != null) {
                if(k == tree.left.size + 1) {
                    return tree
                } else if(k > tree.left.size + 1) {
                    return findKthNodeBinaryTree(tree.right, k - tree.left.size - 1)
                } else {
                    return findKthNodeBinaryTree(tree.left, k)
                }
            } else {
                if(k == 1) {
                    return tree;
                } else if(k > 1) {
                    return findKthNodeBinaryTree(tree.right, k - 1)
                }
            }
         */
//        if(tree == null) {
//            return null
//        }
//
//        if(tree.left != null) {
//            return when {
//                k == tree.left.size + 1 -> {
//                    tree
//                }
//                k > tree.left.size + 1 -> {
//                    findKthNodeBinaryTree(tree.right, k - tree.left.size - 1)
//                }
//                else -> {
//                    findKthNodeBinaryTree(tree.left, k)
//                }
//            }
//        } else {
//            return if(k == 1) {
//                tree
//            } else {
//                //if(k > 1)
//                findKthNodeBinaryTree(tree.right, k - 1)
//            }
//        }
        if(tree == null) {
            return tree
        }

        //T O(h) S O(1)
        var cur: KthNodeInTree.BinaryTreeNode<Int> = tree
        var lK = k
        while(true) {
            var lSize = 0
            if(cur.left != null) {
                lSize = cur.left.size
            }

            when {
                lK == lSize + 1 -> {
                    return cur
                }
                lK > lSize + 1 -> {
                    cur = cur.right
                    lK -= (lSize + 1)
                }
                else -> {
                    cur = cur.left
                }
            }
        }
    }
}